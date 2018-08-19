package _20180818;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/18.
 * <p>
 * 题目描述
 * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一块黑色的瓷砖上，只能向相邻的（上下左右四个方向）黑色瓷砖移动。请写一个程序，计算你总共能够到达多少块黑色的瓷砖。
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据第一行是两个整数 m 和 n（1≤m, n≤20）。紧接着 m 行，每行包括 n 个字符。每个字符表示一块瓷砖的颜色，规则如下：
 * <p>
 * 1. “.”：黑色的瓷砖；
 * 2. “#”：白色的瓷砖；
 * 3. “@”：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。
 * 输出描述:
 * 对应每组数据，输出总共能够到达多少块黑色的瓷砖。
 * 示例1
 * 输入
 * 复制
 * 9 6
 * ....#.
 * .....#
 * ......
 * ......
 * ......
 * ......
 * ......
 * #@...#
 * .#..#.
 * 输出
 * 复制
 * 45
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int height = sc.nextInt(), width = sc.nextInt();

            boolean[][] map = new boolean[height][width];

            Queue<Point> queue = new LinkedList<>();

            for (int i = 0; i < height; i++) {
                char[] line = sc.next().toCharArray();
                for (int j = 0; j < line.length; j++) {
                    if (line[j] == '#') {
                        map[i][j] = true;
                    } else if (line[j] == '@') {
                        queue.add(new Point(j, i));
                        map[i][j] = true;
                    }
                }
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                ans++;

                for (Point next : new Point[]{
                        new Point(cur.x + 1, cur.y),
                        new Point(cur.x - 1, cur.y),
                        new Point(cur.x, cur.y + 1),
                        new Point(cur.x, cur.y - 1)
                }) {
                    if (next.x >= 0 && next.x < width && next.y >= 0 && next.y < height
                            && !map[next.y][next.x]
                            ) {
                        queue.add(new Point(next.x, next.y));
                        map[next.y][next.x] = true;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}