package _20180816;

import java.util.*;

/**
 * Created by YotWei on 2018/8/16.
 * <p>
 * 题目描述
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 * 输入描述:
 * 输入一个初始位置x_0,范围在1到1,000,000,006
 * 输出描述:
 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 * 示例1
 * 输入
 * 复制
 * 125000000
 * 输出
 * 复制
 * 1
 */
public class Q1 {

    public static void main(String[] args) {

        Map<Integer, Integer> steps = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);

        int initPos = sc.nextInt();
        int ans = -1, mod = 1000000007;

        queue.add(initPos);
        steps.put(initPos, 0);

        int count = 100000;
        while (!queue.isEmpty()) {

            int curPos = queue.poll();

            if (curPos % mod == 0) {
                ans = steps.get(curPos);
                break;
            }

            if (steps.get(curPos) >= count) {
                continue;
            }

            for (long nextL : new long[]{4L * curPos + 3, 8L * curPos + 7}) {
                int next = (int) (nextL % mod);
                if (steps.containsKey(next))
                    continue;

                steps.put(next, steps.get(curPos) + 1);
                queue.add(next);
            }
        }

//        System.out.println(steps);

        System.out.println(ans);
    }
}
