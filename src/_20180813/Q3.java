package _20180813;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/13.
 * <p>
 * 题目描述
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1
 * 输入
 * 复制
 * abcd12345ed125ss123456789
 * 输出
 * 复制
 * 123456789
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] str = s.next().toCharArray();

        int maxLength = 0;
        int startMark = 0, endMark = 0;

        for (int i = 0; i < str.length; i++) {
            if (isNumberChar(str[i])) {
                int j = i + 1;
                while (j < str.length && isNumberChar(str[j]) && str[j] - str[i] == j - i) j++;
                if (j - i > maxLength) {
                    maxLength = j - i;
                    startMark = i;
                    endMark = j;
                }
                i = j;
            }
        }

        for (int i = startMark; i < endMark; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }

    private static boolean isNumberChar(char c) {
        return '0' <= c && c <= '9';
    }
}
