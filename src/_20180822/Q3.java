package _20180822;

import java.util.*;

/**
 * Created by YotWei on 2018/8/22.
 * <p>
 * 题目描述
 * 英语中，有些单词可以出现在其他单词后面。例如“Love”可以出现在“I”之后，“You”可以出现在“Love”之后，因此它们能构成“I Love You”这句话。
 * 现在给你一些单词间的关系，你能计算出最多能有几个单词组合在一起构成一句话吗？
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据的第一行包含一个正整数n (1≤n≤10000)。
 * <p>
 * 紧接着n行单词关系，每行包含两个单词A和B，表示单词B能出现在A后面。单词长度不超过32个字符，并且只有字母组成。
 * <p>
 * 不存在循环的依赖关系。
 * 输出描述:
 * 对应每组数据，输出最多有几个单词能构成一个句子。
 * 示例1
 * 输入
 * 复制
 * 1
 * hello world
 * 3
 * I love
 * love you
 * love me
 * 输出
 * 复制
 * 2
 * 3
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            Map<String, List<String>> mapper = new HashMap<>();
            int k = sc.nextInt();

            for (int i = 0; i < k; i++) {
                String from = sc.next();
                String to = sc.next();

                if (!mapper.containsKey(from)) {
                    mapper.put(from, new ArrayList<>());
                }
                if (!mapper.containsKey(to)) {
                    mapper.put(to, new ArrayList<>());
                }
                mapper.get(from).add(to);
            }

            int max = -1;
            Map<String, Integer> save = new HashMap<>();
            for (String s : mapper.keySet()) {
                int temp = dp(save, mapper, s);
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.println(max);
        }
    }

    private static int dp(Map<String, Integer> save, Map<String, List<String>> mapper, String s) {
        if (mapper.get(s).isEmpty()) {
            return 1;
        }

        if (!save.containsKey(s)) {
            int max = -1;
            for (String ss : mapper.get(s)) {
                int temp = dp(save, mapper, ss) + 1;
                if (temp > max)
                    max = temp;
            }
            save.put(s, max);
        }
        return save.get(s);
    }
}
