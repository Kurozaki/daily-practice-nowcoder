package _20180817;

import java.util.Scanner;

/**
 * 题目描述
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式（一组测试用例可能包含多组数据，请注意处理）？
 * 输入描述:
 * 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
 * 输出描述:
 * 一行输出答案。
 * 示例1
 * 输入
 * 复制
 * 3 100 2
 * 1 2 3
 * 输出
 * 复制
 * 2
 */

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), t = sc.nextInt(), c = sc.nextInt();
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i <= n - c; i++) {
                if (sum[i + c] - sum[i] <= t) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
