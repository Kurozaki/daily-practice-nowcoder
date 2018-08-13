package _20180813;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YotWei on 2018/8/10.
 * <p>
 * 题目描述
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 * <p>
 * 输入描述:
 * 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 * <p>
 * 输出描述:
 * 输出一个整数,表示最大的总预计消费金额
 * 示例1
 * <p>
 * 输入
 * 3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
 * <p>
 * 输出
 * 20
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Table[] tables = new Table[s.nextInt()];
        Customers[] customers = new Customers[s.nextInt()];

        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(s.nextInt());
        }

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customers(s.nextInt(), s.nextInt());
        }

        Arrays.sort(tables);
        Arrays.sort(customers);

        long ans = 0, accept = 0;
        for (Customers customer : customers) {
            if (accept >= tables.length) {
                break;
            }

            int left = 0, right = tables.length - 1, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (customer.count == tables[mid].size) {
                    left = mid;
                    break;
                } else {
                    if (customer.count < tables[mid].size) {
                        right = mid - 1;
                    } else if (customer.count > tables[mid].size) {
                        left = mid + 1;
                    }
                }
            }
            while (0 < left && left < tables.length && tables[left].size >= customer.count) {
                left--;
            }

            while (left < tables.length && (customer.count > tables[left].size || tables[left].used)) {
                left++;
            }
            if (left < tables.length) {
                ans += customer.value;
                tables[left].used = true;
                accept++;
            }
        }

        System.out.println(ans);
    }

    static class Customers implements Comparable<Customers> {

        int count, value;

        Customers(int count, int value) {
            this.count = count;
            this.value = value;
        }

        @Override
        public int compareTo(Customers o) {
            return o.value - this.value;
        }

    }

    static class Table implements Comparable<Table> {

        Table(int size) {
            this.size = size;
        }

        boolean used = false;
        int size;

        @Override
        public int compareTo(Table o) {
            return this.size - o.size;
        }

    }
}
