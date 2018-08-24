package _20180824;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/24.
 * <p>
 * 题目描述
 * 对于财务处的工作人员来说，发工资那天是最忙碌的。财务处的NowCoder最近在考虑一个问题：如果每个员工的工资额都知道，最少需要准备多少张人民币，才能在给每位同事发工资的时候都不用找零呢？
 * 这里假设员工的工资都是正整数，单位元，人民币一共有100元、50元、20元、10元、5元、2元和1元七种。
 * 输入描述:
 * 输入数据包含多个测试实例，每个测试实例的第一行是一个整数n (n≤100)，表示人数，然后是n个员工的工资。
 * 输出描述:
 * 对于每个测试实例输出一个整数x,表示至少需要准备的人民币张数。每个输出占一行。
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 2 3
 * 3
 * 100 200 300
 * 输出
 * 复制
 * 4
 * 6
 */
public class Q3 {

    private static int[] p = {1, 2, 5, 10, 20, 50, 100};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += calculate(sc.nextInt());
            }
            System.out.println(ans);
        }
    }

    private static int calculate(int n) {
        int k = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            int t = n / p[i];
            n -= t * p[i];
            k += t;
            if (n == 0)
                break;
        }
        return k;
    }
}
