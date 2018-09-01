package _20180831;

import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by YotWei on 2018/8/31.
 * <p>
 * 题目描述
 * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到， 马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。 团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，并且很快找到叠最高罗汉塔的人员序列。 现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。
 * 输入描述:
 * 首先一个正整数N，表示人员个数。
 * 之后N行，每行三个数，分别对应马戏团员编号，体重和身高。
 * 输出描述:
 * 正整数m，表示罗汉塔的高度。
 * 示例1
 * 输入
 * 复制
 * 6
 * 1 65 100
 * 2 75 80
 * 3 80 100
 * 4 60 95
 * 5 82 101
 * 6 81 70
 * 输出
 * 复制
 * 4
 */

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Man[] mans = new Man[sc.nextInt()];
            for (int i = 0; i < mans.length; i++) {
                sc.nextInt();
                mans[i] = new Man(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(mans);
            int[] dp = new int[mans.length];
            int maxHeight = dp[0];
            for (int i = 0; i < mans.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if ((mans[j].height <= mans[i].height && mans[j].weight < mans[i].weight
                            || mans[j].height == mans[i].height && mans[j].weight == mans[i].weight)
                            && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                if (dp[i] > maxHeight)
                    maxHeight = dp[i];
            }
            System.out.println(Arrays.toString(mans));
            System.out.println(Arrays.toString(dp));
            System.out.println(maxHeight);
        }
    }

    static class Man implements Comparable<Man> {
        Man(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        int height, weight;

        @Override
        public int compareTo(Man o) {
            return this.height == o.height ? this.weight - o.weight : this.height - o.height;
        }

        @Override
        public String toString() {
            return "{" + weight +
                    ", " + height +
                    '}';
        }
    }
}