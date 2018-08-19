package _20180819;

/**
 * Created by YotWei on 2018/8/19.
 * <p>
 * 计算斐波那契数列第n项，对1000000007取余数
 * 要求时间复杂度为 O(log n)
 */
public class Q4 {

    /*
     * 矩阵快速幂变换
     *
     * | Fn   | =>  | Fn-1  Fn-2 | => | 1 1 |
     * | Fn-1 |     | Fn-1  0    |    | 1 0 |
     */

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.getNthNumber(3));
    }

    public static class Fibonacci {
        public int getNthNumber(int n) {
            long[][] p = mPow(new long[][]{{1, 1}, {1, 0}}, n);
            return (int) p[0][0];
        }

        private long[][] mPow(long[][] m, int e) {
            if (e == 0) {
                return new long[][]{
                        {1, 0},
                        {0, 1}
                };
            }
            if (e == 1) {
                return m;
            }
            long[][] temp = mPow(m, e / 2);
            temp = mMulti(temp, temp);

            if (e % 2 == 1) {
                temp = mMulti(temp, m);
            }
            return temp;
        }

        private long[][] mMulti(long[][] m1, long[][] m2) {
            long[][] res = new long[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    long r = 0;
                    for (int k = 0; k < 2; k++) {
                        r += ((m1[i][k] % 1000000007) * (m2[k][j]) % 1000000007) % 1000000007;
                    }
                    res[i][j] = r % 1000000007;
                }
            }
            return res;
        }
    }
}
