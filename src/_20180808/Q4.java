package _20180808;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）
 * 看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这
 * 个要求的合法排列的数目。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
 * 接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 * <p>
 * 输出描述:
 * 输出一行表示合法的排列数目。
 * <p>
 * <p>
 * 输入
 * 100 2405
 * 4 62 10 33 86 58 9 49 68 84 30 88 90 67 59 0 19 25 12 72 44 85 51 5 13 98 94 91 24 47 27 95 100 77 15 92 0 70 55 31 28 81 75 39 34 74 2 89 45 63 36 64 43 93 29 50 7 54 0 82 71 66 97 53 23 38 69 52 48 21 26 17 20 57 37 61 11 73 60 78 18 79 0 80 16 83 56 35 0 32 6 96 1 99 46 76 22 87 3 41
 * <p>
 * <p>
 * 输出
 * 1
 */

public class Q4 {

    private static int[] array;
    private static int k, ans;

    private static int basePairCount;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, unknownCount = 0;
        int[] unknownSet;
        boolean[] flags;

        n = s.nextInt();
        k = s.nextInt();

        array = new int[n];
        flags = new boolean[n + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
            if (array[i] != 0) {
                flags[array[i]] = true;
            } else {
                unknownCount++;
            }
        }

        unknownSet = new int[unknownCount];
        int p = 0;
        for (int i = 1; i < flags.length; i++) {
            if (!flags[i]) {
                unknownSet[p++] = i;
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == 0 || array[j] == 0) {
                    continue;
                }
                if (array[i] < array[j])
                    basePairCount++;
            }
        }

        f(unknownSet, 0);

        System.out.println(ans);

        s.close();
    }

    private static void f(int[] arr, int deep) {
        if (arr.length == deep) {

            int[] fillIndexArr = new int[arr.length];
            int p = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    fillIndexArr[p++] = i;
                }
            }

            int canPairCount = getPair(arr), total;
            total = basePairCount + canPairCount;
            for (int i = 0; i < arr.length; i++) {
                total += insertPairCount(arr[i], fillIndexArr[i]);
            }
            if (total == k) {
                ans++;
            }

            return;
        }
        for (int i = deep; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[deep];
            arr[deep] = temp;

            f(arr, deep + 1);

            temp = arr[i];
            arr[i] = arr[deep];
            arr[deep] = temp;
        }
    }

    private static int[][] save = new int[101][101];

    private static int insertPairCount(int number, int index) {
        if (save[number][index] == 0) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (i == index || array[i] == 0)
                    continue;
                if ((i < index && array[i] < number)
                        || (i > index && array[i] > number)) {
                    count++;
                }
            }
            save[number][index] = count;
        }
        return save[number][index];
    }

    private static int getPair(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}