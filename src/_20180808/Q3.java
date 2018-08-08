package _20180808;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/8.
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] str = s.nextLine().toCharArray();
        char[] tar = s.nextLine().toCharArray();

        boolean flag = false;

        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (tar[j] == str[i]) {
                ++j;
                if (j == tar.length) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag ? "Yes" : "No");
    }
}
