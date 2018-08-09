package test;

/**
 * Created by YotWei on 2018/8/9.
 */

import java.io.*;
import java.util.*;

public class CodeTest {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1 = null;
        while ((line1 = in.readLine()) != null) {
            String[] s1 = line1.trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            String line2 = in.readLine();
            String[] s2 = line2.trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s2[i]);
            }
            int x1 = 0;
            int x2 = 0;
            int x3 = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                    for (int j = i + 1; j < n; j++) {
                        if (arr[j] != 0) {
                            if (arr[i] < arr[j]) {
                                x1++;
                            }
                        }
                    }
                }
            }
            k -= x1;
            List<Integer> indexs = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    temp.add(arr[i]);
                } else {
                    indexs.add(i);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!temp.contains(i)) {
                    values.add(i);
                }
            }
            int res = count(arr, indexs, values, k);
            System.out.println(res);
        }
    }

    public static int count(int[] array, List<Integer> indexs, List<Integer> values, int k) {
        int count = 0;
        if (indexs.size() == 0) {
            if (k == 0)
                return 1;
            else
                return 0;
        }
        int index = indexs.remove(0);
        for (int i = 0; i < values.size(); i++) {
            int value = values.get(i);
            array[index] = value;
            int pairs = getPairs(array, index);
            if (pairs <= k) {
                values.remove(i);
                count += count(array, indexs, values, k - pairs);
                values.add(i, value);
            }
        }
        array[index] = 0;
        indexs.add(0, index);
        return count;
    }

    public static int getPairs(int[] array, int index) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i < index && array[i] < array[index]) || (i > index && array[i] > array[index])) {
                count++;
            }
        }
        return count;
    }
}