package _20180819;

/**
 * Created by YotWei on 2018/8/19.
 * <p>
 * 题目描述
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * <p>
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 * <p>
 * 测试样例：
 * 3
 * 返回：2
 */
public class Q2 {

    public static void main(String[] args) {
        GoUpstairs upstairs = new GoUpstairs();
        System.out.println(upstairs.countWays(100));
    }

    static class GoUpstairs {

        private int[] a = new int[105];

        public int countWays(int n) {
            a[1] = a[2] = 1;
            for (int i = 3; i <= n; i++) {
                a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
            }

            return a[n];
        }
    }
}
