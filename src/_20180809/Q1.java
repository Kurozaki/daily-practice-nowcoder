package _20180809;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/9.
 * <p>
 * 题目描述
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 * <p>
 * 输入描述:
 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 * <p>
 * 输出描述:
 * 输出一个最多可以放的蛋糕数
 * 示例1
 * <p>
 * 输入
 * 3 2
 * <p>
 * 输出
 * 4
 */
public class Q1 {

    /*
     * 解题思路
     * 对于任意 width x height，有如下摆放
     *
     * |xx  xx  xx  xx  xx  x|
     * |xx  xx  xx  xx  xx  x|
     * |  xx  xx  xx  xx  xx |
     * |  xx  xx  xx  xx  xx |
     * |xx  xx  xx  xx  xx  x|
     *
     * */

    private static boolean[][] panel = new boolean[1024][1024];

    public static void main(String[] args) {
        int width, height;
        Scanner s = new Scanner(System.in);
        width = s.nextInt();
        height = s.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                panel[i][j] = (((i / 2) % 2 == 0) && (j / 2) % 2 == 0)
                        || ((i / 2) % 2 != 0 && (j / 2) % 2 != 0);
            }
        }

        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (panel[i][j])
                    count++;
            }
        }
        count = Math.max(count, width * height - count);
        System.out.println(count);
    }

}
