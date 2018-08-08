package _20180808;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/8.
 * <p>
 * 题目难度 3/5
 * <p>
 * 题目描述
 * 航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，产生了 x 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。
 * <p>
 * 输出描述:
 * 输出一行一个整数表示结果。
 * <p>
 * 示例1
 * 输入
 * 10
 * <p>
 * 输出
 * 2
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long l = s.nextLong();
        long left = 0, right = l, mid = 0;

        while (left < right) {
            mid = left / 2 + right / 2;
            if (mid > l / (mid + 1)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (mid != 0) {
            while (mid + 1 < l / mid) {
                mid++;
            }
            while (mid + 1 > l / mid) {
                mid--;
            }
        }
        System.out.println(mid);

        s.close();
    }

}
