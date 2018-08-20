package _20180820;

import java.util.Scanner;

/**
 * 题目描述
 * NowCoder今年买了一辆新车，他决定自己开车回家过年。回家过程中要经过n个大小收费站，每个收费站的费用不同，你能帮他计算一下最少需要给多少过路费吗？
 * 输入描述:
 * 输入包含多组数据，每组数据第一行包含两个正整数m（1≤m≤500）和n（1≤n≤30），其中n表示有n个收费站，编号依次为1、2、…、n。出发地的编号为0，终点的编号为n，即需要从0到n。
 * <p>
 * 紧接着m行，每行包含三个整数f、t、c，（0≤f, t≤n; 1≤c≤10），分别表示从编号为f的地方开到t，需要交c元的过路费。
 * 输出描述:
 * 对应每组数据，请输出至少需要交多少过路费。
 * 示例1
 * 输入
 * 复制
 * 8 4
 * 0 1 10
 * 0 2 5
 * 1 2 2
 * 1 3 1
 * 2 1 3
 * 2 3 9
 * 2 4 2
 * 3 4 4
 * 输出
 * 复制
 * 7
 */
public class Q3 {

    private static final int INF = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = INF;
                }
            }

            for (int i = 0; i < m; i++) {

                int f = sc.nextInt();
                int t = sc.nextInt();
                int c = sc.nextInt();
                map[f][t] = c;
            }

            int[] cost = new int[n + 1];
            boolean[] vis = new boolean[n + 1];
            vis[0] = true;
            for (int i = 1; i < cost.length; i++) {
                cost[i] = map[0][i];
            }

            int count = 1;
            while (count < vis.length) {

                int sel = -1;
                int min = INF;
                for (int i = 0; i < cost.length; i++) {
                    if (!vis[i] && cost[i] != INF) {
                        if (cost[i] < min) {
                            min = cost[i];
                            sel = i;
                        }
                    }
                }
                vis[sel] = true;

                for (int i = 0; i < cost.length; i++) {
                    if (!vis[i] && cost[sel] + map[sel][i] < cost[i]) {
                        cost[i] = cost[sel] + map[sel][i];
                    }
                }
                count++;
            }

            System.out.println(cost[n]);
        }
    }
}
