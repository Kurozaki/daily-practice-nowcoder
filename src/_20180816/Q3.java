package _20180816;

import java.util.*;

/**
 * Created by YotWei on 2018/8/16.
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] ss = new String[sc.nextInt()];

            for (int i = 0; i < ss.length; i++) {
                ss[i] = sc.next();
            }
            Arrays.sort(ss, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
            for (int i = ss.length - 1; i >= 0; i--) {
                System.out.print(ss[i]);
            }
            System.out.println();
        }
    }
}
