package _20180823;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/23.
 * <p>
 * 求最长公共字串
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            char[] c1 = sc.next().toCharArray();
            char[] c2 = sc.next().toCharArray();

            int[][] m = new int[c1.length + 1][c2.length + 1];

            for (int i = 1; i < m.length; i++) {
                for (int j = 1; j < m[i].length; j++) {
                    if (c1[i - 1] == c2[j - 1]) {
                        m[i][j] = Math.max(Math.max(m[i - 1][j], m[i][j - 1]), m[i - 1][j - 1] + 1);
                    } else {
                        m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]);
                    }
                }
            }

            System.out.println(m[c1.length][c2.length]);
        }
    }
}
