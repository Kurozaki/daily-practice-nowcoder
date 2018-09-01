package _20180901;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/9/1.
 * <p>
 * 题目描述
 * 移动推出的校内网短号和亲情网短号非常方便，但在某款新手机里却出现了尴尬的bug。例如，当通讯录中包含如下号码时：
 * 1.小王：600
 * 2.小李：467654
 * 3.小张：600010
 * 输入600时，手机会直接自动打给了小王，因此永远没法打给小张。现在有很多部手机都有这种问题，<span>nowcoder</span>想要找到一个办法来判断每个号码簿里的号码是不是有这种冲突。
 * 输入描述:
 * 输入有多组数据。
 * <p>
 * 每组数据第一行是一个整数n，(1≤n≤10000)。
 * <p>
 * 紧接着有n行电话号码，号码只有数字组成，长度不超过11位。
 * 输出描述:
 * 对应每组输入，有一行输出：如果电话簿中存在冲突的号码，就输出“Yes”；否则输出“No”。
 * 示例1
 * 输入
 * 复制
 * 3
 * 911
 * 97625999
 * 91125426
 * 5
 * 113
 * 12340
 * 123440
 * 12345
 * 98346
 * 输出
 * 复制
 * Yes
 * No
 */
@SuppressWarnings("Duplicates")
public class Q2 {

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

            boolean flag = false;
            for (String word : words) {
                WordTreeNode cur = root;
                char[] w = word.toCharArray();
                int p;
                for (p = 0; p < w.length; p++) {
                    cur = cur.childs.get(w[p]);
                    if (cur.wordCount == 1) {
                        break;
                    }
                }
                if (p == w.length) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "Yes" : "No");
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
