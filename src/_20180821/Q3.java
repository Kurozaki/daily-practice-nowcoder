package _20180821;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/21.
 * <p>
 * 复制
 * 4 20
 * 4 10
 * 5 22
 * 10 3
 * 1 2
 * 0 0
 * 输出
 * 复制
 * 37.00
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (; ; ) {
            int count = sc.nextInt(), remain = sc.nextInt();
            if (remain == 0 && count == 0)
                break;

            P[] p = new P[count];

            for (int i = 0; i < count; i++) {
                p[i] = new P(sc.nextInt(), sc.nextInt());
            }

            Arrays.sort(p, (o1, o2) -> (o2.value * o1.cost - o1.value * o2.cost));
            double ans = 0;

            System.out.println(Arrays.toString(p));

            for (int i = 0; i < p.length; i++) {
                if (p[i].cost <= remain) {
                    remain -= p[i].cost;
                    ans += p[i].value;
                } else {
                    ans += p[i].value * remain * 1.0 / p[i].cost;
                    break;
                }
            }
            System.out.println(String.format("%.2f", ans));
        }
    }

    static class P {
        int cost, value;

        P(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }

        @Override
        public String toString() {
            return "P{" +
                    "cost=" + cost +
                    ", value=" + value +
                    '}';
        }
    }
}
