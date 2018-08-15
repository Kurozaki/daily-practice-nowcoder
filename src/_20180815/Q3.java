package _20180815;


import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/15.
 * <p>
 * 题目描述
 * 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
 * 输入描述:
 * 第一行包含两个整数n,m.
 * <p>
 * 第二行给出n个整数A1，A2，...，An。
 * <p>
 * 数据范围
 * <p>
 * 对于30%的数据，1 <= n, m <= 1000
 * <p>
 * 对于100%的数据，1 <= n, m, Ai <= 10^5
 * 输出描述:
 * 输出仅包括一行，即所求的答案
 * 示例1
 * 输入
 * 复制
 * 3 10
 * 6 5 10
 * 输出
 * 复制
 * 2
 */
public class Q3 {

    /*
     * 暴力计算会超时，这里用到了搜索树
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int m = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Tree tree = buildTree(arr);
        long result = 0;

        for (int a : arr)
            result += query(tree, a, m, 31);

        result /= 2;

        System.out.println(result);
        sc.close();
    }

    static Tree buildTree(int[] arr) {
        Tree root = new Tree();
        for (int num : arr) {
            Tree cur = root;
            for (int i = 31; i >= 0; i--) {
                int ii = (num >> i) & 1;
                if (cur.nexts[ii] == null) {
                    cur.nexts[ii] = new Tree();
                } else {
                    cur.nexts[ii].count++;
                }
                cur = cur.nexts[ii];
            }
        }
        return root;
    }

    static long query(Tree root, int a, int m, int bitIndex) {
        if (bitIndex < 0)
            return 0;

        int aBit = (a >> bitIndex) & 1;
        int mBit = (m >> bitIndex) & 1;

        if (aBit == 1 && mBit == 1) {
            return root.nexts[0] != null ? query(root.nexts[0], a, m, bitIndex - 1) : 0;
        } else if (aBit == 0 && mBit == 1) {
            return root.nexts[1] != null ? query(root.nexts[1], a, m, bitIndex - 1) : 0;
        } else if (aBit == 1 && mBit == 0) {
            long p = root.nexts[0] == null ? 0 : root.nexts[0].count;
            long q = root.nexts[1] == null ? 0 : query(root.nexts[1], a, m, bitIndex - 1);
            return p + q;
        } else if (aBit == 0 && mBit == 0) {
            long p = root.nexts[1] == null ? 0 : root.nexts[1].count;
            long q = root.nexts[0] == null ? 0 : query(root.nexts[0], a, m, bitIndex - 1);
            return p + q;
        }
        return 0;
    }


    static class Tree {

        Tree[] nexts = new Tree[2];
        int count = 1;
    }
}
