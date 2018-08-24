package _20180824;

/**
 * Created by YotWei on 2018/8/24.
 * <p>
 * 题目描述
 * NowCoder最近专注于股票，他准备投资10000元，现在告诉你某一段时间内股票价格的历史数据，在不考虑税收等费用的前提下，请你帮忙计算10000元最多能变成多少元？
 * 注：交易的时间和次数没有限制。
 * 输入描述:
 * 输入有多组数据。每组数据第一行是一个整数n (2≤n≤10)，紧接着有n个正整数代表股票价格（假设股票价格都为整数）。
 * 输出描述:
 * 对应每一组数据，输出最初的10000元最多能变成多少元。
 * <p>
 * 结果保留两位小数（四舍五入）。
 * 示例1
 * 输入
 * 复制
 * 5 1 2 3 4 5
 * 5 3 1 2 5 4
 * 4 4 3 2 1
 * 输出
 * 复制
 * 50000.00
 * 50000.00
 * 10000.00
 */

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] price = new int[sc.nextInt()];
            for (int i = 0; i < price.length; i++) {
                price[i] = sc.nextInt();
            }
            rr = 1.0;
            max = rr;
            backtrace(0, price, true);
            System.out.printf("%.2f\n", max * 10000);
        }
    }

    private static double rr, max;

    private static void backtrace(int index, int[] prices, boolean sellable) {
        if (index == prices.length) {
            if (rr > max) {
                max = rr;
            }
            return;
        }

        // 什么也不干
        backtrace(index + 1, prices, sellable);

        double temp = rr;
        if (sellable) {
            // 卖出
            rr /= prices[index];
            backtrace(index + 1, prices, false);
        } else {
            // 买入
            rr *= prices[index];
            backtrace(index + 1, prices, true);
        }
        rr = temp;
    }
}
