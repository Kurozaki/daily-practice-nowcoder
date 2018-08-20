package _20180820;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by YotWei on 2018/8/9.
 * <p>
 * 题目描述
 * nowcoder是个数学迷，他最喜欢研究“哥德巴赫猜想”，因此他的计算机密码也都采用素数。 但一直用同一个密码是不安全的，所以他要经常更换他的密码。但他只允许自己的密码中出现某些数字，且密码的每一位都不相同。比如1 2 4，则有6种情况124 142 214 241 412 421。其中241 和 421为素数。为了获得他的密码（他的机器上存放了第4届舜禹杯大学生程序设计竞赛的题目！），需要生成一个字典来帮助我们破解。 请你来编写一个程序帮助我们（因为众所周知的原因我们迫切需要获得这些题目）。
 * 输入描述:
 * Line 1: 密码的位数n (1 ≤ n ≤ 9)。
 * Line 2: 1->n个不重复的整数序列 (1 ≤ x[i] ≤ 9).
 * <p>
 * 输入0结束。
 * 输出描述:
 * 按从小到大顺序输出所有的结果。如果一个结果也没有，输出“NONE”。每组数据后面跟随一个空行。
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 2 4
 * 0
 * 输出
 * 复制
 * 241
 * 421
 */

public class Q4 {

    private static TreeSet<Integer> ansSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int len = sc.nextInt();
            if (len == 0) {
                break;
            }

            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();

            ansSet = new TreeSet<>();
            perm(arr, 0);

            if (ansSet.isEmpty()) {
                System.out.println("NONE");
            } else {
                for (Integer ans : ansSet) {
                    System.out.println(ans);
                }
            }
            System.out.println();
        }

        sc.close();
    }

    private static void perm(int[] list, int index) {
        if (index == list.length) {
            if (list.length == 1 && isPrime(list[0])) {
                ansSet.add(list[0]);
            } else if (list[list.length - 1] % 2 != 0) {
                int temp = 0;
                for (int t : list) {
                    temp = temp * 10 + t;
                }
                if (!ansSet.contains(temp) && isPrime(temp)) {
                    ansSet.add(temp);
                }
            }
            return;
        }
        for (int i = index; i < list.length; i++) {
            swap(list, index, i);
            perm(list, index + 1);
            swap(list, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3 || n == 5) {
            return true;
        }
        int mod = n % 6;
        if (n > 6 && mod != 1 && mod != 5)
            return false;

        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
