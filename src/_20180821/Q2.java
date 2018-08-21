package _20180821;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/21.
 * <p>
 * 判断字符串是否包含回文字串
 */
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int start = 0, end = 0;

            char[] str = sc.next().toCharArray();
            for (int i = 0; i < str.length - 1; i++) {
                for (int j = i + 1; j < str.length; j++) {
                    if (f(str, i, j)) {
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }
            }

            for (int i = start; i <= end; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        }
    }

    private static boolean f(char[] s, int i, int j) {
        while (i < j && s[i] == s[j]) {
            i++;
            j--;
        }
        return i >= j;
    }
}
