package _20180818;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/18.
 * <p>
 * 题目描述
 * 给定一个递增序列，a1 < a2 <...< an。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 * 输入描述:
 * 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 2 3 7 8
 * 输出
 * 复制
 * 4
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int[] arr = new int[sc.nextInt()];
            int maxIntval = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                if (i > 0) {
                    if (arr[i] - arr[i - 1] > maxIntval) {
                        maxIntval = arr[i] - arr[i - 1];
                    }
                }
            }

            int minIntval = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i - 1] < minIntval) {
                    minIntval = arr[i + 1] - arr[i - 1];
                }
            }

            System.out.println(Math.max(minIntval, maxIntval));
        }
    }
}
