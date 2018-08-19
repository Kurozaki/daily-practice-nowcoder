package test;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/9.
 */

public class Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            int[] arr = new int[n + 1];
            arr[1] = arr[2] = 1;
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 1] % 1000000007 + arr[i - 2] % 1000000007) % 1000000007;
            }

            System.out.println(arr[n]);
        }
    }
}
