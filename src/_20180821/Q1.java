package _20180821;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/21.
 * <p>
 * 题目描述
 * 小世界现象（又称小世界效应），也称六度分隔理论（英文：Six Degrees of Separation）。
 * 假设世界上所有互不相识的人只需要很少中间人就能建立起联系。后来1967年哈佛大学的心理学教授斯坦利·米尔格拉姆根据这概念做过一次连锁信实验，尝试证明平均只需要5个中间人就可以联系任何两个互不相识的美国人。
 * Redraiment最近获得了社交网站Footbook的好友关系资料，请你帮忙分析一下某两个用户之间至少需要几个中间人才能建立联系？
 * 输入描述:
 * 输入第一行是一个整数t，表示紧接着有t组数据。
 * 每组数据包含两部分：第一部分是好友关系资料；第二部分是待分析的用户数据。
 * 好友资料部分第一行包含一个整数n (5≤n≤50)，表示有n个用户，用户id用1->n表示。
 * 紧接着是一个只包含0和1的n×n矩阵，其中第y行第x列的值表示id是y的用户是否是id为x的用户的好友（1代表是，0代表不是）。假设好友关系是相互的，即A是B的好友意味着B也是A的好友。
 * 待分析的用户数据第一行包含一个整数m，紧接着有m行用户组数据。
 * 每组有两个用户ID，A和B (1≤A, B≤n; A != B)。
 * 输出描述:
 * 对于每组待分析的用户，输出用户A至少需要通过几个中间人才能认识用户B。
 * 如果A无论如何也无法认识B，输出“Sorry”。
 * 示例1
 * 输入
 * 复制
 * [ 2 5 1 0 1 0 1 0 1 1 1 0 1 1 1 0 0 0 1 0 1 0 1 0 0 0 1 3 1 2 2 4 3 5 6 1 1 0 0 1 0 1 1 0 1 0 1 0 0 1 0 0 1 0 1 0 1 0 1 1 0 0 0 1 0 0 1 1 1 0 1 4 2 3 3 6 5 1 4 2
 * 输出
 * 复制
 * 1 0 Sorry 1 0 2 1
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[][] map = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt() == 1;
                }
            }

            int cc = sc.nextInt();
            while (cc-- > 0) {
                int ans = bfs(map, sc.nextInt() - 1, sc.nextInt() - 1, n);
                if (ans == -1) {
                    System.out.println("Sorry");
                } else {
                    System.out.println(ans - 1);
                }
            }
        }
    }

    private static int bfs(boolean[][] map, int start, int end, int n) {
        boolean[] vis = new boolean[n];
        int[] cost = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        vis[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return cost[cur];
            }

            for (int i = 0; i < n; i++) {
                if (map[cur][i] && !vis[i]) {
                    cost[i] = cost[cur] + 1;
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
        return -1;
    }
}
