package _20180810;

import java.util.Scanner;

/**
 * 题目描述
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 * <p>
 * 输入描述:
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 * <p>
 * 输出描述:
 * 输出为一个整数，即为优雅的点的个数
 * 示例1
 * <p>
 * 输入
 * 25
 * <p>
 * 输出
 * 12
 * <p>
 * Created by YotWei on 2018/8/10.
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rr = s.nextInt();
        int sqrt = (int) Math.sqrt(rr);

        int ans = 0;

        for (int i = 1; i <= sqrt; i++) {
            int b = (int) Math.sqrt(rr - i * i);
            if (b * b + i * i == rr) {
                System.out.println(i + "," + b);
                ans += 4;
            }
        }
        System.out.println(ans);
    }
}
