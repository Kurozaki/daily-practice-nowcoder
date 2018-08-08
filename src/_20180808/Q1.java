package _20180808;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/8.
 *
 * 题目难度: 2/5
 *
 * 题目描述
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，
 * 每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），
 * 接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * <p>
 * 输出描述:
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * <p>
 * 示例1
 * 输入
 * 4
 * 7 15 9 5
 * <p>
 * 输出
 * 3
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), sum = 0, avg;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }
        avg = sum / n;
        if (avg * n == sum) {
            int step = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] - avg) % 2 == 0) {
                    step = step + Math.abs(arr[i] - avg) / 2;
                } else {
                    step = -1;
                    break;
                }
            }
            if (step > 0) {
                step /= 2;
            }
            System.out.println(step);
        } else {
            System.out.println("-1");
        }
    }
}
