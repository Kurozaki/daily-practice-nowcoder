package _20180823;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YotWei on 2018/8/23.
 * <p>
 * 计算前缀表达式
 * <p>
 * 输入描述:
 * 输入包含多组数据，每组数据包含两行。
 * <p>
 * 第一行为正整数n（3≤n≤50），紧接着第二行包含n个由数值和运算符组成的列表。
 * <p>
 * “+ - * /”分别为加减乘除四则运算，其中除法为整除，即“5/3=1”。
 * 输出描述:
 * 对应每一组数据，输出它们的运算结果。
 * 示例1
 * 输入
 * 复制
 * 3
 * + 2 3
 * 5
 * + 2 2 3
 * 5
 * 2 + 2 3
 * 输出
 * 复制
 * 5
 * 12
 * 10
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Stack<Node> nodeStack = new Stack<>();
            Node root = null;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    Node newNode = new Node(sc.next());
                    nodeStack.push(newNode);
                    root = newNode;
                } else {
                    Node pNode = nodeStack.peek();
                    Node newNode = new Node(sc.next());
                    if (pNode.lchild == null) {
                        pNode.lchild = newNode;
                    } else if (pNode.rchild == null) {
                        pNode.rchild = newNode;
                        nodeStack.pop();
                    }

                    if (!newNode.isLeaf) {
                        nodeStack.push(newNode);
                    }
                }
            }

            System.out.println(root.getValue());
        }
        sc.close();
    }

    static class Node {
        Node lchild, rchild;
        String val;
        int intVal;
        boolean isLeaf = true;

        public Node(String val) {
            this.val = val;
            try {
                this.intVal = Integer.parseInt(this.val);
            } catch (Exception e) {
                isLeaf = false;
            }
        }

        int getValue() {
            if (isLeaf) {
                return intVal;
            }
            switch (val) {
                case "+":
                    return lchild.getValue() + rchild.getValue();
                case "-":
                    return lchild.getValue() - rchild.getValue();
                case "*":
                    return lchild.getValue() * rchild.getValue();
                default:
                    return lchild.getValue() / rchild.getValue();
            }
        }
    }
}
