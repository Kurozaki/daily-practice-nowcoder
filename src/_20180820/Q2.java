package _20180820;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/20.
 * <p>
 * 题目描述
 * 考虑仅用1分、5分、10分、25分和50分这5种硬币支付某一个给定的金额。例如需要支付11分钱，有一个1分和一个10分、一个1分和两个5分、六个1分和一个5分、十一个1分这4种方式。
 * 请写一个程序，计算一个给定的金额有几种支付方式。
 * 注：假定支付0元有1种方式。
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据包含一个正整数n（1≤n≤10000），即需要支付的金额。
 * 输出描述:
 * 对应每一组数据，输出一个正整数，表示替换方式的种数。
 * 示例1
 * 输入
 * 复制
 * 11
 * 26
 * 输出
 * 复制
 * 4
 * 13
 */
public class Q2 {

    private static final int[] den = {1, 5, 10, 25, 50};
    private static long[][] save;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        save = new long[den.length][10000 + 1];

        while (sc.hasNext()) {
            int sum = sc.nextInt();
            System.out.println(f(den.length - 1, sum));
        }
    }

    static long f(int di, int sum) {
        if (di == 0 || sum == 0) {
            return 1;
        }
        if (save[di][sum] == 0) {
            long ans = 0;
            for (int i = 0; i * den[di] <= sum; i++) {
                ans += f(di - 1, sum - den[di] * i);
            }
            save[di][sum] = ans;
        }
        return save[di][sum];
    }
}
