//package _20180808;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by YotWei on 2018/8/8.
// */
//public class Q4 {
//
//    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        long start = System.currentTimeMillis();
//        f(arr, 0);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//    }
//
//    public static void f(List<Integer> arr, int deep) {
//        if (deep == arr.size()) {
////            System.out.println(arr);
//            return;
//        }
//        for (int i = deep; i < arr.size(); i++) {
//            Collections.swap(arr, i, deep);
//            f(arr, deep + 1);
//        }
//    }
//}
