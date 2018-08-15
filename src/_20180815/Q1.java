package _20180815;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/15.
 * <p>
 * 题目描述
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 * 输入描述:
 * 输入包括一个整数n,(3 ≤ n < 1000)
 * 输出描述:
 * 输出对数
 * 示例1
 * 输入
 * 复制
 * 10
 * 输出
 * 复制
 * 2
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = 2; j * i <= n; j++) {
                arr[j * i] = true;
            }
        }

        int ans = 0;
        int half = (n + 1) / 2;
        for (int i = 2; i <= half; i++) {
            if (!arr[i] && !arr[n - i]) {
//                System.out.println(i + "," + (n - i));
                ans++;
            }
        }

        System.out.println(ans);
    }
}
