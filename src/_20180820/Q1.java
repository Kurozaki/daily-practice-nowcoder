package _20180820;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/20.
 * <p>
 * 题目描述
 * 原来是要到醋溜站台乘坐醋溜快车到醋溜港”，亮亮解出了地图隐藏的秘密，赶紧奔向醋溜站台，但到了之后，亮亮忧桑地发现，从醋溜站台到醋溜港沿途的每个车站都有很多美女被他飒爽的英姿所吸引，只要经过车站就会被这些漂亮的女孩搭讪，但是现在亮亮一心想要寻找楚楚街而没空去搭理她们，所以亮亮希望在抵达醋溜港的时候被搭讪的次数最少。问亮亮抵达醋溜港最少会被搭讪多少次？
 * 输入描述:
 * 第一行包含两个整数N(2<=N<=5000),M(1<=M<=50000)。N表示公有N个汽车站，M表示公有M条公路，起点为1，终点为N。 第二行包含N个整数(0<=K<=10000)，第i个整数表示在第i站有K个美女想要搭讪亮亮。 接下来M行，每行包含两个整数P(1<=P<=N),Q(1<=Q<=N),代表P,Q两个站是有班车直达的。
 * 输出描述:
 * 一个整数，即亮亮抵达醋溜港最少需要被搭讪的次数。
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 0 1 1 3 6
 * 1 2
 * 1 4
 * 2 3
 * 3 5
 * 4 5
 * 输出
 * 复制
 * 8
 */
public class Q1 {

    /*
     * 迪杰斯特拉算法
     *
     * 顶点带权先转化为边带权
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt();

            int[] eVals = new int[n];
            int[][] adjmap = new int[n][n];

            for (int i = 0; i < n; i++) {
                eVals[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjmap[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < m; i++) {
                int s = sc.nextInt() - 1, e = sc.nextInt() - 1;
                adjmap[s][e] = eVals[e];
                adjmap[e][s] = eVals[s];
            }

            boolean[] vis = new boolean[n];
            int[] dis = new int[n];

            vis[0] = true;
            dis[0] = eVals[0];
            for (int i = 1; i < n; i++) {
                dis[i] = adjmap[0][i];
            }

            int count = 1;
            while (count < n) {
                int min = Integer.MAX_VALUE;
                int sel = -1;

                for (int i = 0; i < n; i++) {
                    if (!vis[i] && dis[i] < min) {
                        min = dis[i];
                        sel = i;
                    }
                }

                vis[sel] = true;
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && adjmap[sel][i] != Integer.MAX_VALUE) {
                        if (dis[sel] + adjmap[sel][i] < dis[i]) {
                            dis[i] = dis[sel] + adjmap[sel][i];
                        }
                    }
                }
                count++;
            }
            System.out.println(dis[n - 1]);
        }
    }
}
