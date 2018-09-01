package algorithm.onedraw;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YotWei on 2018/8/28.
 * <p>
 * "一笔画"破解器
 */
public class OneDraw {


    public void oneDraw(boolean[][] map) {
        this.map = map;
        this.ss = new char[map.length][map[0].length];

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (!map[y][x]) {
                    start = new Point(x, y);
                    dfs(x, y, Step.UP);
                    dfs(x, y, Step.DOWN);
                    dfs(x, y, Step.LEFT);
                    dfs(x, y, Step.RIGHT);
                }
            }
        }
    }

    private boolean[][] map;
    private char[][] ss;
    private Point start;

    private void dfs(int x, int y, Step step) {
        ss[y][x] = step.toChar();
        map[y][x] = true;

        if (isMovable(x, y, step)) {
            switch (step) {
                case RIGHT:
                    dfs(x + 1, y, step);
                    break;

                case LEFT:
                    dfs(x - 1, y, step);
                    break;

                case DOWN:
                    dfs(x, y + 1, step);
                    break;

                case UP:
                    dfs(x, y - 1, step);
            }
        } else {
            List<Step> nexts = new ArrayList<>();
            for (Step next : step.nexts()) {
                if (isMovable(x, y, next)) {
                    nexts.add(next);
                }
            }
            if (nexts.isEmpty() && fullCheck()) {
                System.out.println(start);
                for (char[] s : ss) {
                    System.out.println(Arrays.toString(s));
                }
            } else {
                for (Step next : nexts) {
                    dfs(x, y, next);
                }
            }
        }

        map[y][x] = false;
        ss[y][x] = 0;
    }

    private boolean isMovable(int x, int y, Step step) {
        switch (step) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length && !map[y][x];
    }

    private boolean fullCheck() {
        for (boolean[] m : map) {
            for (boolean b : m) {
                if (!b)
                    return false;
            }
        }
        return true;
    }

    enum Step {
        UP, DOWN, LEFT, RIGHT;

        Step[] nexts() {
            if (this == LEFT || this == RIGHT)
                return new Step[]{UP, DOWN};
            else
                return new Step[]{LEFT, RIGHT};
        }

        char[] dir = {'↑', '↓', '←', '→'};

        public char toChar() {

            return dir[this.ordinal()];
        }
    }

    public static boolean[][] parse(String[] str) {
        boolean[][] map = new boolean[str.length][];
        for (int i = 0; i < str.length; i++) {
            map[i] = new boolean[str[i].length()];
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = str[i].charAt(j) == '#';
            }
        }
        return map;
    }

    public static void main(String[] args) {
        OneDraw od = new OneDraw();
        od.oneDraw(OneDraw.parse(
                new String[]{
                        "#........",
                        "..#......",
                        ".........",
                        ".....#...",
                        "...#.....",
                        ".#....#..",
                        "....#....",
                        ".........",
                        "........."
                }));

    }
}
