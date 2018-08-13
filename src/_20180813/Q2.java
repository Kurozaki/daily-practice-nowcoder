package _20180813;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/13.
 * <p>
 * 题目描述
 * 小易喜欢的单词具有以下特性：
 * 1.单词每个字母都是大写字母
 * 2.单词没有连续相等的字母
 * 3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
 * 例如：
 * 小易不喜欢"ABBA"，因为这里有两个连续的'B'
 * 小易不喜欢"THETXH"，因为这里包含子序列"THTH"
 * 小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
 * 小易喜欢"A","ABA"和"ABCBA"这些单词
 * 给你一个单词，你要回答小易是否会喜欢这个单词（只要不是不喜欢，就是喜欢）。
 * 输入描述:
 * 输入为一个字符串，都由大写字母组成，长度小于100
 * 输出描述:
 * 如果小易喜欢输出"Likes",不喜欢输出"Dislikes"
 * 示例1
 * 输入
 * 复制
 * AAA
 * 输出
 * 复制
 * Dislikes
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[] str = scn.next().toUpperCase().toCharArray();

        boolean flag = true;

        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == str[i + 1]) {
                flag = false;
                break;
            }
        }


        if (str.length >= 4 && flag) {
            for (int i = 0; i < str.length - 3; i++) {
                for (int j = i + 1; j < str.length - 2; j++) {

                    for (int ii = j + 1; ii < str.length - 1; ii++) {
                        if (str[i] == str[ii]) {
                            for (int jj = ii + 1; jj < str.length; jj++) {
                                if (str[jj] == str[j]) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag)
                            break;
                    }
                    if (!flag)
                        break;
                }
                if (!flag)
                    break;
            }
        }

        System.out.println(flag ? "Likes" : "Dislikes");
    }
}
