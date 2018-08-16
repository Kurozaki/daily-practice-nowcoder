package test;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/9.
 */

/*
 * 4 4
 * 10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1
 */
public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            StringBuilder yy = new StringBuilder();
            yy.append(sc.next());
            int cnt = sc.nextInt();
            int count = 0;
            while (count < cnt) {
                int len = yy.length() - 1;
                int s = 0;
                while (s < len && yy.codePointAt(s) >= yy.codePointAt(s + 1))
                    s++;
                yy.deleteCharAt(s);
                count++; //记录删除个数  
            }
            System.out.println(yy);
        }
    }

}
