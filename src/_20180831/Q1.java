package _20180831;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/31.
 * <p>
 * 题目描述
 * 题目说明
 * <p>
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * <p>
 * 样例输入
 * <p>
 * 5
 * <p>
 * 样例输出
 * <p>
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * <p>
 * int Num：输入的正整数N
 * <p>
 * 输入描述:
 * 输入正整数N（N不大于100）
 * <p>
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * 输出
 * 复制
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] m = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n - row; col++) {
                    if (col == 0 && row == 0) {
                        m[row][col] = 1;
                    } else if (col == 0) {
                        m[row][col] = m[row - 1][col] + row;
                    } else {
                        m[row][col] = m[row][col - 1] + (row + col + 1);
                    }
                    System.out.print(m[row][col] + " ");
                }
                System.out.println();
            }
        }
    }
}
