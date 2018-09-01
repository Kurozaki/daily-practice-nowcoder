package _20180901;

/**
 * Created by YotWei on 2018/9/1.
 */
public class FastMod {

    public static void main(String[] args) {
        FastMod fd = new FastMod();
        long a = 5, mod = 1000000007;
        long ans = fd.inv(a, mod);

        System.out.println(ans);

        System.out.println((a * ans) % mod);
    }

    /**
     * get a^-1
     *
     * @param a    a
     * @param modp must be a prime
     * @return return a^-1
     */
    public long inv(long a, long modp) {
        return (fastMod(a, modp - 2, modp) + modp) % modp;
    }

    private long fastMod(long a, long n, long m) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ((ans % m) * (a % m)) % m;
            }
            a = ((a % m) * (a % m)) % m;
            n >>= 1;
        }
        return ans;
    }
}
