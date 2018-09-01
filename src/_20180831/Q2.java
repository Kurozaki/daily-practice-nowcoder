package _20180831;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/31.
 * <p>
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * <p>
 * 说明：
 * <p>
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 整数N
 * <p>
 * 输出描述:
 * 最少需要几位同学出列
 * <p>
 * 示例1
 * 输入
 * 复制
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 复制
 * 4
 */
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] leftInc = new int[arr.length], rightInc = new int[arr.length];
            leftInc[0] = 1;
            rightInc[rightInc.length - 1] = 1;

            for (int i = 0; i < arr.length; i++) {
                int lmax = 1;
                for (int l = 0; l < i; l++) {
                    if (arr[l] < arr[i] && leftInc[l] + 1 > lmax) {
                        lmax = leftInc[l] + 1;
                    }
                }
                leftInc[i] = lmax;
            }

            int ans = -1;

            for (int i = arr.length - 1; i >= 0; i--) {
                int rmax = 1;
                for (int r = i + 1; r < arr.length; r++) {
                    if (arr[r] < arr[i] && rightInc[r] + 1 > rmax) {
                        rmax = rightInc[r] + 1;
                    }
                }
                rightInc[i] = rmax;
                if (leftInc[i] + rightInc[i] > ans)
                    ans = leftInc[i] + rightInc[i];
            }
            System.out.println(ans - 1);
        }
    }
}
