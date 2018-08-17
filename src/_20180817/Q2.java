package _20180817;

import java.util.*;

/**
 * Created by YotWei on 2018/8/17.
 * <p>
 * 题目描述
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 * 输入描述:
 * 第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
 * 输出描述:
 * 输出一行，代表所求概率(保留到2位小数)
 * 示例1
 * 输入
 * 复制
 * 2 2 1
 * 2 1
 * 输出
 * 复制
 * 0.50
 */

public class Q2 {

    /*
     * 解题思路
     *
     * 不能用可达路径/总路径数，因为每条路径选择的概率不一样
     *
     * 应该用概率迭代
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[][] mushroomMap;
        double[][] p;

        int n = sc.nextInt(), m = sc.nextInt();
        int k = sc.nextInt();

        mushroomMap = new boolean[m][n];
        p = new double[m][n];

        int tempX, tempY;
        for (int i = 0; i < k; i++) {
            tempX = sc.nextInt();
            tempY = sc.nextInt();
            mushroomMap[tempY - 1][tempX - 1] = true;
        }

        if (mushroomMap[m - 1][n - 1]) {
            System.out.println("0.00");
            return;
        }

        p[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mushroomMap[i][j])
                    continue;
                if (i < m - 1 && j < n - 1) {
                    /*
                     * 可能选择往下走，也可能往右走，概率相等
                     */
                    p[i + 1][j] += 0.5 * p[i][j];
                    p[i][j + 1] += 0.5 * p[i][j];
                } else {
                    /*
                     * 遇到边界，只有一个方向可以选择
                     */
                    if (i < m - 1) {
                        p[i + 1][j] += p[i][j];
                    } else if (j < n - 1) {
                        p[i][j + 1] += p[i][j];
                    }
                }
            }
        }
        System.out.println(String.format("%.2f", p[m - 1][n - 1]));
    }
}
