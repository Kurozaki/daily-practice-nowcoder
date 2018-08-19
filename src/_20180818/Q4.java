package _20180818;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/18.
 * <p>
 * 题目描述
 * NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
 * 现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
 * <p>
 * 入口在第一行第二列；出口在最后一行第九列。
 * <p>
 * 从任意一个“.”点都能一步走到上下左右四个方向的“.”点。
 * 输出描述:
 * 对应每组数据，输出从入口到出口最短需要几步。
 * 示例1
 * 输入
 * 复制
 * #.########
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * ########.#
 * <p>
 * #.########
 * #........#
 * ########.#
 * #........#
 * #.########
 * #........#
 * ########.#
 * #........#
 * #.######.#
 * ########.#
 * 输出
 * 复制
 * 16
 * 30
 */
public class Q4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {

            boolean[][] map = new boolean[10][10];
            int[][] steps = new int[10][10];

            for (int i = 0; i < 10; i++) {
                char[] lineChars = s.next().toCharArray();
                for (int j = 0; j < lineChars.length; j++) {
                    if (lineChars[j] == '#') {
                        map[i][j] = true;
                    }
                }
            }

            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(1, 0));

            int step = -1;
            while (!queue.isEmpty()) {

                Point cur = queue.poll();
                if (cur.x == 8 && cur.y == 9) {
                    step = steps[9][8];
                    break;
                }

                for (Point next : new Point[]{
                        new Point(cur.x + 1, cur.y),
                        new Point(cur.x - 1, cur.y),
                        new Point(cur.x, cur.y + 1),
                        new Point(cur.x, cur.y - 1)}) {

                    if (next.x >= 0 && next.x < 10 && next.y >= 0 && next.y < 10
                            && !map[next.y][next.x]) {
                        queue.add(next);
                        steps[next.y][next.x] = steps[cur.y][cur.x] + 1;
                        map[next.y][next.x] = true;
                    }
                }
            }

            System.out.println(step);
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
