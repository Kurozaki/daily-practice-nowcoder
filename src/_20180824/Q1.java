package _20180824;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/24.
 * <p>
 * 题目描述
 * NowCoder最近在把玩股票，但因为他工作很慢，一天只能做一次“买”和“卖”。
 * 现在告诉你每天从早上9:00到下午17:00，每个整点时刻的股票价格，请你帮他算出当天最多只做一次买卖操作（即当天要么什么都不做，要么买一次并且卖一次），每只股票最大的收益能有多少？
 * 输入描述:
 * 输入有多组数据。
 * <p>
 * 每组数据包含9个实数，分别代表9:00、10:00、...、17:00的股票价格。
 * 输出描述:
 * 对应每一组数据，输出当天只做一次买卖操作的前提下最大收益有多少。
 * <p>
 * 结果保留两位小数（四舍五入）。
 * 示例1
 * 输入
 * 复制
 * 9.3 10.1 8.3 7.7 9.2 9.4 10.5 9.9 9.8
 * 100.3 99.2 102.1 101.8 101.3 101.1 100.9 102.3 99.9
 * 输出
 * 复制
 * 2.80
 * 3.10
 */

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double[] prices = new double[9];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = sc.nextDouble();
            }

            double[] dp = new double[prices.length];
            double max = 0;

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (prices[i] > prices[j] && prices[i] - prices[j] > dp[i]) {
                        dp[i] = prices[i] - prices[j];
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            System.out.printf("%.2f\n", max);
        }
    }

}