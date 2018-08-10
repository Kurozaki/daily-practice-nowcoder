package _20180810;

import java.util.*;

/**
 * Created by YotWei on 2018/8/10.
 * <p>
 * 题目描述
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 * <p>
 * 输入描述:
 * 输入包括n+1行:
 * 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 * 接下来的n行:
 * 每行m个0或者1,以空格分隔
 * <p>
 * 输出描述:
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 * <p>
 * 示例1
 * 输入
 * <p>
 * 4 4
 * 10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1
 * <p>
 * 输出
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */
public class Q1 {

    /*
     * 解题思路：广度优先搜索
     *
     **/

    private static int width, height;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        width = s.nextInt();
        height = s.nextInt();

        Map2d<Integer> powerMap = new Map2d<>(width, height);
        Map2d<Integer> visFlagMap = new Map2d<>(width, height);

        powerMap.set(0, 0, s.nextInt());
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                visFlagMap.set(x, y, s.nextInt() - 1);
            }
        }

        LinkedList<Point> steps = new LinkedList<>();

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        int flagId = 1;
        visFlagMap.set(0, 0, flagId);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == 0 && p.y == height - 1) {
                if (powerMap.get(p.x, p.y) >= 0) {
                    int id = visFlagMap.get(p.x, p.y) - 1;
                    Point cur = new Point(p.x, p.y);

                    steps.addFirst(cur);

                    while (id != 1) {

                        for (Point point : new Point[]{
                                new Point(cur.x + 1, cur.y),
                                new Point(cur.x - 1, cur.y),
                                new Point(cur.x, cur.y + 1),
                                new Point(cur.x, cur.y - 1)
                        }) {
                            if (inbound(point.x, point.y)) {
                                if (visFlagMap.get(point.x, point.y) == id) {
                                    steps.addFirst(point);
                                    cur = point;
                                    break;
                                }
                            }
                        }
                        id--;
                    }
                    steps.addFirst(new Point(0, 0));
                }
                break;
            }

            int nx, ny;

            nx = p.x + 1;
            ny = p.y;
            if (check(nx, ny, visFlagMap)) {
                queue.add(new Point(nx, ny));
                visFlagMap.set(nx, ny, visFlagMap.get(p.x, p.y) + 1);
                powerMap.set(nx, ny, powerMap.get(p.x, p.y));
            }

            nx = p.x - 1;
            ny = p.y;
            if (check(nx, ny, visFlagMap)) {
                if (powerMap.get(p.x, p.y) >= 3) {
                    queue.add(new Point(nx, ny));
                    visFlagMap.set(nx, ny, visFlagMap.get(p.x, p.y) + 1);
                    powerMap.set(nx, ny, powerMap.get(p.x, p.y) - 3);
                }
            }

            nx = p.x;
            ny = p.y + 1;
            if (check(nx, ny, visFlagMap)) {
                if (powerMap.get(p.x, p.y) >= 1) {
                    queue.add(new Point(nx, ny));
                    visFlagMap.set(nx, ny, visFlagMap.get(p.x, p.y) + 1);
                    powerMap.set(nx, ny, powerMap.get(p.x, p.y) - 1);
                }
            }

            nx = p.x;
            ny = p.y - 1;
            if (check(nx, ny, visFlagMap)) {
                if (powerMap.get(p.x, p.y) >= 1) {
                    queue.add(new Point(nx, ny));
                    visFlagMap.set(nx, ny, visFlagMap.get(p.x, p.y) + 1);
                    powerMap.set(nx, ny, powerMap.get(p.x, p.y) - 1);
                }
            }
        }

        if (steps.isEmpty()) {
            System.out.println("Can not escape!");
        } else {
            for (int i = 0; i < steps.size(); i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.print(steps.get(i));
            }
        }
    }

    private static boolean inbound(int x, int y) {
        return 0 <= x && x < width &&
                0 <= y && y < height;
    }

    private static boolean check(int x, int y, Map2d<Integer> visFlagMap) {
        return inbound(x, y) &&
                visFlagMap.get(x, y) == 0;
    }


    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    static class Map2d<T> {

        Map2d(int width, int height) {
            map = new Object[width][height];
        }

        private Object[][] map;

        @SuppressWarnings("unchecked")
        T get(int x, int y) {
            return (T) map[x][y];
        }

        void set(int x, int y, T val) {
            map[x][y] = val;
        }
    }
}
