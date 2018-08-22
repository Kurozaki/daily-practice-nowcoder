package _20180822;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/22.
 * <p>
 * 题目描述
 * 会下国际象棋的人都很清楚：皇后可以在横、竖、斜线上不限步数地吃掉其他棋子。如何将 8 个皇后放在棋盘上（有8×8个方格），使它们谁也不能被吃掉！这就是著名的八皇后问题。
 * 对于某个满足要求的8皇后的摆放方法，定义一个皇后串a与之对应，即 a=b1b2...b8, 其中bi（1≤bi≤8）为相应摆法中第 i 行皇后所处的列数。已经知道8皇后问题一共有92组解（即92个不同的皇后串）。给出一个数n，要求输出第n个串。串的比较是这样的:皇后串x置于皇后串y之前，当且仅当将x视为整数时比y小。
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据包含一个正整数n（1≤n≤92）。
 * 输出描述:
 * 对应每一组输入，输出第n个皇后串。
 * 示例1
 * 输入
 * 复制
 * 1
 * 92
 * 输出
 * 复制
 * 15863724
 * 84136275
 */
public class Q4 {

    public static void main(String[] args) {
        NQueen q = new NQueen(8);
        q.solve();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(q.getAns(sc.nextInt()));
        }
    }

    static class NQueen {

        private int n;
        private int ans = 0;

        private Map<Integer, String> ansMap = new HashMap<>();

        public NQueen(int n) {
            this.n = n;
        }

        private boolean[] colFlags;
        private boolean[][] map;

        public void solve() {
            colFlags = new boolean[n];
            map = new boolean[n][n];
            backtrace(0);
        }

        private void backtrace(int row) {
            if (row == n) {
                show(++ans);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!colFlags[i] && check(row, i)) {
                    colFlags[i] = true;
                    map[row][i] = true;

                    backtrace(row + 1);

                    map[row][i] = false;
                    colFlags[i] = false;
                }
            }
        }

        boolean check(int row, int col) {
            int r, c;
            r = row;
            c = col;
            while (--r >= 0 && --c >= 0) {
                if (map[r][c])
                    return false;
            }
            r = row;
            c = col;
            while (--r >= 0 && ++c < n) {
                if (map[r][c])
                    return false;
            }
            return true;
        }

        private void show(int ans) {
            StringBuilder ss = new StringBuilder();
            for (boolean[] m : map) {
                for (int i = 0; i < m.length; i++) {
                    if (m[i]) {
                        ss.append(i + 1);
                    }
                }
            }
            ansMap.put(ans, ss.toString());
        }

        private String getAns(int index) {
            return ansMap.get(index);
        }
    }
}
