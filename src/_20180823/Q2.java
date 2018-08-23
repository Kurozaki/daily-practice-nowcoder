package _20180823;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/23.
 * <p>
 * 题目描述
 * 广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，其中最长的长度为4。
 * 输入描述:
 * 输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000）。
 * <p>
 * 紧接着第二行包含n个正整数m（1≤n≤10000），代表队伍中每位队员的身高。
 * 输出描述:
 * 对应每一组数据，输出最长递增子序列的长度。
 * 示例1
 * 输入
 * 复制
 * 7
 * 1 7 3 5 9 4 8
 * 6
 * 1 3 5 2 4 6
 * 输出
 * 复制
 * 4
 * 4
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int[] arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(arr));

            int[] dp = new int[arr.length];
            dp[0] = 1;
            int ans = 1;

            for (int i = 1; i < arr.length; i++) {
                int max = dp[0];

                for (int j = 0; j < i; j++) {
                    int temp;
                    if (arr[i] > arr[j]) {
                        temp = dp[j] + 1;
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
                dp[i] = max;
                if (dp[i] > ans) {
                    ans = dp[i];
                }
            }
            System.out.println(ans);
        }
    }
}
