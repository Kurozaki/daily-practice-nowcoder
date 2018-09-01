package algorithm.blackandwhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YotWei on 2018/8/28.
 */
public class BlackAndWhite {

    private int width, height;

    private static void show(boolean[][] matrix) {
        for (boolean[] mm : matrix) {
            for (boolean b : mm) {
                System.out.print(b ? "1 " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private Comparator<boolean[]> rowComp = (b1, b2) -> {
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] && !b2[i])    // 1 > 0
                return -1;
            else if (!b1[i] && b2[i])
                return 1;
        }
        return 0;
    };

    public void blackAndWhite(String[] map, String[] mask) {
        // check input
        check(map, mask);

        for (String s : map) {
            for (int i = 0; i < s.toCharArray().length; i++) {
                System.out.print(s.charAt(i) == '0' ? "- " : s.charAt(i) + " ");
            }
            System.out.println();
        }
        System.out.println();

        // generate base
        boolean[][] matrix = generateEquationSetMatrix(map, mask);

        // simplify
        simplify(matrix);

        // solve
        getAnswer(matrix);
    }

    private void check(String[] map, String[] mask) {
        height = map.length;
        if (height <= 0)
            throw new IllegalArgumentException("height < 1");
        width = map[0].length();
        if (width <= 0)
            throw new IllegalArgumentException("width < 1");
        for (String s : map) {
            if (s.length() != width)
                throw new IllegalArgumentException("width mismatch");
        }

//        if (map.length != mask.length)
    }

    private boolean[][] generateEquationSetMatrix(String[] map, String[] mask) {
        int size = width * height;
        boolean[][] matrix = new boolean[size][size + 1];

        for (int i = 0; i < size; i++) {
            char c = map[i / width].charAt(i % width);
            for (Integer j : getAffectedIndexes(i, c)) {
                matrix[j][i] = true;
            }
            matrix[i][size] = mask[i / width].charAt(i % width) == '0';
        }
        return matrix;
    }

    private ArrayList<Integer> getAffectedIndexes(int ci, char c) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = ci % width, y = ci / width;

        int[] xs, ys;
        if (c == '2') {
            xs = new int[]{x - 1, x, x + 1, x - 1, x + 1, x - 1, x, x + 1};
            ys = new int[]{y - 1, y - 1, y - 1, y, y, y + 1, y + 1, y + 1};
        } else {
            xs = new int[]{x - 1, x + 1, x, x};
            ys = new int[]{y, y, y - 1, y + 1};
        }
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] >= 0 && xs[i] < width
                    && ys[i] >= 0 && ys[i] < height)
                list.add(ys[i] * width + xs[i]);
        }
        list.add(ci);
        return list;
    }

    private void simplify(boolean[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            Arrays.parallelSort(matrix, i, matrix.length, rowComp);

            boolean[] r = matrix[i];
            int h;
            for (h = 0; h < r.length; h++) {
                if (r[h])
                    break;
            }
            for (int j = i + 1; j < matrix.length; j++) {
                if (h < matrix[j].length && matrix[j][h]) {
                    XOR(matrix[j], r);
                }
            }
        }
    }

    private void XOR(boolean[] r1, boolean[] r2) {
        for (int i = 0; i < r1.length; i++)
            r1[i] = (r1[i] && !r2[i]) || (!r1[i] && r2[i]);
    }

    private boolean xor(boolean a, boolean b) {
        return (a && !b) || (!a && b);
    }

    private void getAnswer(boolean[][] m) {
        boolean[] ans = new boolean[m.length];

        for (int i = m.length - 1; i >= 0; i--) {
            ans[i] = m[i][m.length];
            for (int j = i + 1; j < m.length; j++) {
                ans[i] = xor(ans[i], ans[j] && m[i][j]);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i])
                System.out.printf("[%d, %d] ", i % width, i / width);
        }
    }
}
