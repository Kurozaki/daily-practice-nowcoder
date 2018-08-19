package _20180818;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/18.
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int p = sc.nextInt();
            int n = sc.nextInt();

            boolean[] pFlag = new boolean[p];
            int ans = -1;
            int pi;

            for (int i = 0; i < n; i++) {
                pi = sc.nextInt() % p;
                if (pFlag[pi] && ans == -1) {
                    ans = i + 1;
                }
                pFlag[pi] = true;
            }

            System.out.println(ans);
        }
    }
}
