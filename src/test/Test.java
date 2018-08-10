package test;

/**
 * Created by YotWei on 2018/8/9.
 */

/*
 * 4 4
 * 10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1
 */
public class Test {

    static int x, y;

    public static void main(String args[]) {
        x--;
        myMethod();
        System.out.println(x + y + ++x);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }

}
