package _20180814;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YotWei on 2018/8/14.
 * <p>
 * 题目描述
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 输入描述:
 * 每个测试输入包含2个整数,n和m
 * 输出描述:
 * 按每个组合的字典序排列输出,每行输出一种组合
 *
 * 示例1
 *
 * 输入
 * 5 5
 *
 * 输出
 * 1 4
 * 2 3
 * 5
 */
public class Q2 {

    private static int[] arr;
    private static Stack<Integer> step = new Stack<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        bt(0, m);
    }

    private static void bt(int index, int sum) {
        if (sum == 0) {
            for (int i = 0; i < step.size(); i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(step.get(i));
            }
            System.out.println();
            return;
        }
        if (sum < 0 || index == arr.length) {
            return;
        }

        step.push(arr[index]);
        bt(index + 1, sum - arr[index]);
        step.pop();

        bt(index + 1, sum);
    }
}
