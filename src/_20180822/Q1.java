package _20180822;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/22.
 * <p>
 * 题目描述
 * “呼！！终于到了，可是接下来要怎么走才能到达楚楚街港港呢？”亮亮在醋溜港直发愁。 突然“啾”的一下，
 * 一只银色小船出现在亮亮的面前，上面坐着小精灵丹丹“又见面了，有什么可以帮助你的么？”小精灵向亮亮眨了眨眼睛，
 * 微笑着说。 “我想去楚楚街港，但我不知道要怎么走，请问你可以告诉我么？”亮亮按捺着激动的心情轻声问道。
 * “楚楚街港呀......那是个特别美好的地方”小精灵歪着头想了想，说“我只能告诉你大海上所有的航线，剩下的就只能靠你自己啦~”
 * “只有所有的航线呀”，亮亮的内心再三挣扎，却又没有其他的办法。 “不管有多困难，我一定要达到楚楚街港，
 * 请你告诉我吧”亮亮坚定地对小精灵说。 小精灵欣赏地点了点头，递给亮亮一张航线图，并叮嘱道“时限是1000天，一定要到哦~”，
 * 然后如来时一般“啾”的一声，消失了。 亮亮现在迫切地想要抵达楚楚街港，请问亮亮最快能在第几天抵达楚楚街港呢？
 * 输入描述:
 * 一行包含两个整数N(2<=N<=500),M(1<=M<=2000)，用单个空格隔开。表示公有N个港，M条航线。起点为1，终点为N。
 * 接下来M行，每行包含五个整数P,Q(1<=P,Q<=n), K(1<=K<=1000), X,Y(0<=X,Y<=10000),代表P,Q两个港有航线并需要K天，
 * 并且该航线在第X天到第Y天天气恶劣不可通行。
 * 输出描述:
 * 一个整数，即亮亮最快能在第几天抵达楚楚街港
 * 示例1
 * <p>
 * 输入
 * 4 4
 * 2 1 1 7 13
 * 4 3 2 10 11
 * 1 3 8 9 12
 * 2 3 3 2 10
 * <p>
 * 输出
 * 14
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt();

            Route[][] routes = new Route[n][n];
            int[] costs = new int[n];
            boolean[] vis = new boolean[n];

            for (int i = 0; i < m; i++) {
                int s = sc.nextInt() - 1;
                int e = sc.nextInt() - 1;
                int k = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                routes[s][e] = routes[e][s] = new Route(k, x, y);
            }

            vis[0] = true;
            for (int i = 1; i < n; i++) {
                if (routes[0][i] != null) {
                    costs[i] = routes[0][i].getRealCost(costs[0]);
                } else {
                    costs[i] = Integer.MAX_VALUE;
                }
            }

            int count = 1;
            while (count < n) {

                int min = Integer.MAX_VALUE;
                int sel = 0;

                for (int i = 0; i < n; i++) {
                    if (!vis[i] && min > costs[i]) {
                        min = costs[i];
                        sel = i;
                    }
                }

                vis[sel] = true;
                for (int i = 0; i < n; i++) {
                    if (i != sel && routes[sel][i] != null) {
                        int rc = routes[sel][i].getRealCost(costs[sel]);
                        if (rc < costs[i]) {
                            costs[i] = rc;
                        }
                    }

                }
                count++;
            }

            System.out.println(costs[n - 1] + 1);
        }
    }

    static class Route {

        Route(int cost, int disableStart, int disableEnd) {
            this.cost = cost;
            this.disableStart = disableStart;
            this.disableEnd = disableEnd;
        }

        int cost;
        int disableStart, disableEnd;

        int getRealCost(int start) {
            if (start + cost < disableStart || start > disableEnd) {
                return start + cost;
            }
            return disableEnd + cost;
        }
    }
}
