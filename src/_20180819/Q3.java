package _20180819;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YotWei on 2018/8/19.
 * <p>
 * 计算后缀表达式，保证表达是合法
 * <p>
 * 输入
 * <p>
 * 3
 * 2 3 +
 * <p>
 * 5
 * 2 3 3 + *
 * <p>
 * 输出
 * 5
 * 12
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            Stack<Integer> ss = new Stack<>();

            int count = sc.nextInt();

            for (int i = 0; i < count; i++) {
                String input = sc.next();

                try {
                    int value = Integer.parseInt(input);
                    ss.push(value);
                } catch (Exception e) {

                    Integer b = ss.pop();
                    Integer a = ss.pop();

                    int cal = 0;

                    switch (input) {
                        case "+":
                            cal = a + b;
                            break;

                        case "-":
                            cal = a - b;
                            break;

                        case "*":
                            cal = a * b;
                            break;

                        case "/":
                            cal = a / b;
                            break;
                    }

                    ss.push(cal);
                }
            }

            System.out.println(ss.pop());
        }
    }
}
