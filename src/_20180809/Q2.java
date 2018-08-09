package _20180809;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 输入描述:
 * 输入为两行:
 * 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 * 第二行为n个正整数A[i](32位整数)，以空格隔开。
 * 输出描述:
 * 输出所求的方案数
 * 示例1
 * 输入
 * 复制
 * 5 15 5 5 10 2 3
 * 输出
 * 复制
 * 4
 */

public class Q2 {

    /*
     *  解题思路：动态规划
     *
     **/

    private static long[][] save = new long[1001][1001];
    private static int[] arr;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        arr = new int[s.nextInt()];
        int sum = s.nextInt();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        long ans = dp(0, sum);
        System.out.println(ans);
    }

    private static long dp(int index, int sum) {
        if (sum == 0)
            return 1;
        if (sum <= 0 || index >= arr.length) {
            return 0;
        }
        if (save[index][sum] == 0) {
            save[index][sum] = dp(index + 1, sum)
                    + dp(index + 1, sum - arr[index]);
        }
        return save[index][sum];
    }
}
