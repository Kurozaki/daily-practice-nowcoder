package _20180901;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/9/1.
 * <p>
 * 题目描述
 * 一个字符串的前缀是从该字符串的第一个字符起始的一个子串。例如“carbon”的前缀是有“c”，“ca”，“car”，“carb”，“carbo”，和“carbon”。空串不是前缀，但是每个非空串是它自身的子串。
 * 我们希望能用前缀来缩略地表示单词。例如“carbohydrate”通常用“carb”来表示。在下面的例子中，“carbohydrate”能被缩写成“carboh”，但是不能被缩写成“carbo”（或其余更短的前缀），因为已经有一个单词用“carbo”开始。
 * carbohydrate
 * cart
 * carbonic
 * caribou
 * carriage
 * car
 * 一个完全匹配会覆盖一个前缀匹配，例如“car”完全匹配单词“car”。因此“car”是“car”的缩略语是没有二义性的，“car”不会被当成“carriage”或者任何在列表中以“car”开始的单词。
 * 现在给你一组单词，要求找到所有单词唯一标识的最短前缀。
 * 输入描述:
 * 输入包含多组数据，每组数据第一行包含一个正整数n（2≤n≤1000）。
 * <p>
 * 紧接着n行单词，单词只有小写字母组成，长度不超过20个字符。
 * 输出描述:
 * 对应每一组数据，按照输入顺序依次输出每个单词的最短前缀。
 * <p>
 * 每组数据之后输出一个空格作为分隔。
 * 示例1
 * 输入
 * 复制
 * 3
 * ab
 * a
 * acb
 * 6
 * carbohydrate
 * cart
 * carbonic
 * caribou
 * carriage
 * car
 * 输出
 * 复制
 * ab
 * a
 * ac
 * <p>
 * carboh
 * cart
 * carbon
 * cari
 * carr
 * car
 */
public class Q1 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] words = new String[n];
            WordTreeNode root = new WordTreeNode();
            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
                WordTreeNode cur = root;
                for (char c : words[i].toCharArray()) {
                    if (!cur.childs.containsKey(c)) {
                        cur.childs.put(c, new WordTreeNode());
                    }
                    cur.wordCount++;
                    cur = cur.childs.get(c);
                }
                cur.wordCount++;
            }
            for (String word : words) {
                WordTreeNode cur = root;
                char[] w = word.toCharArray();
                int p;
                for (p = 0; p < w.length; p++) {
                    cur = cur.childs.get(w[p]);
                    if (cur.wordCount == 1 || p == w.length - 1) {
                        break;
                    }
                }
                for (int i = 0; i <= p; i++) {
                    System.out.print(w[i]);
                }
                System.out.println();
            }
        }
    }

    static class WordTreeNode {

        private Map<Character, WordTreeNode> childs;
        private int wordCount = 0;

        public WordTreeNode() {
            childs = new HashMap<>();
        }

        @Override
        public String toString() {
            return "WordTreeNode{" +
                    ", childs=" + childs +
                    '}';
        }
    }
}
