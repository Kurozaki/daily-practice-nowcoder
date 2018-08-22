package _20180822;

import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/22.
 * <p>
 * 题目描述
 * 1
 * / \
 * 2   3
 * / \ / \
 * 4 5 6 7
 * /\ /\ /\ /\
 * 如上图所示，由正整数 1, 2, 3, ...组成了一棵无限大的二叉树。从某一个结点到根结点（编号是1的结点）都有一条唯一的路径，比如从5到根结点的路径是（5, 2, 1），从4到根结点的路径是（4, 2, 1），从根结点1到根结点的路径上只包含一个结点1，因此路径就是（1）。对于两个结点x和y，假设他们到根结点的路径分别是（x1, x2, ... ,1）和（y1, y2,...,1），那么必然存在两个正整数i和j，使得从xi 和yj 开始，有xi = yj，xi + 1 = yj + 1，xi + 2 = yj + 2，...
 * 现在的问题就是，给定x和y，要求他们的公共父节点，即xi（也就是 yj）。
 * 输入描述:
 * 输入包含多组数据，每组数据包含两个正整数x和y（1≤x, y≤2^31-1）。
 * 输出描述:
 * 对应每一组数据，输出一个正整数xi，即它们的首个公共父节点。
 * 示例1
 * 输入
 * 复制
 * 10 4
 * 输出
 * 复制
 * 2
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int hx = getHeight(x), hy = getHeight(y);

            if (hx > hy) {
                for (; hx > hy; ) {
                    x >>= 1;
                    hx--;
                }
            } else {
                for (; hx < hy; ) {
                    y >>= 1;
                    hy--;
                }
            }
            for (; x != y; ) {
                x >>= 1;
                y >>= 1;
            }
            System.out.println(x);
        }
        sc.close();
    }

    private static int getHeight(int n) {
        int h = 0;
        while (n > 1) {
            n = n >> 1;
            h++;
        }
        return h;
    }
}
