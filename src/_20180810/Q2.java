package _20180810;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/10.
 * <p>
 * 题目描述
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 * 输入描述:
 * 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
 * 输出描述:
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 * <p>
 * 示例1
 * <p>
 * 输入
 * 20
 * <p>
 * 输出
 * 3
 */
public class Q2 {

    private static final int MAX = 101;

    /*
     *  解法一：广度优先搜索
     *
     *
     *

    private static boolean[] vis = new boolean[MAX];
    private static int[] count = new int[MAX];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n % 2 != 0 || n < 6) {
            System.out.println(-1);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        vis[n] = true;
        count[n] = 0;

        int ans = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 0) {
                ans = count[cur];
                break;
            }

            for (int next : new int[]{cur - 8, cur - 6}) {
                if (next >= 0 && !vis[next]) {
                    queue.add(next);
                    count[next] = count[cur] + 1;
                    vis[next] = true;
                }
            }
        }


        System.out.println(ans);
    }

    *
    *
    */

    /*
     * 解法二：动态规划
     */

    private static int[] save = new int[MAX];

    public static void main(String[] args) {
        save[6] = save[8] = 1;
        Scanner s = new Scanner(System.in);
        int ans = dp(s.nextInt());
        System.out.println(ans);
    }

    private static int dp(int x) {
        if (x < 0)
            return -1;
        if (x == 0) {
            return 0;
        }
        if (save[x] == 0) {
            int a = dp(x - 6), b = dp(x - 8);
            if (a != -1 && b != -1) {
                save[x] = a < b ? a : b;
            } else if (a == -1 && b == -1) {
                save[x] = -1;
            } else {
                save[x] = b == -1 ? a : b;
            }
            if (save[x] != -1) {
                save[x]++;
            }
        }
        return save[x];
    }
}
