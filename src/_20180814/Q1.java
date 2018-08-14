package _20180814;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/14.
 * <p>
 * 混合颜料问题
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] m = new int[s.nextInt()];
        for (int i = 0; i < m.length; i++) {
            m[i] = s.nextInt();
        }


        for (int i = m.length - 1; i > 0; i--) {
            Arrays.sort(m, 0, i + 1);
            for (int j = 0; j < i; j++)
                if ((m[j] ^ m[i]) < m[j])
                    m[j] ^= m[i];
        }

        int ans = m.length;
        for (int aM : m) {
            if (aM == 0)
                ans--;
        }
        System.out.println(ans);

    }

    public static void bin(int n) {
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) > 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }
}
