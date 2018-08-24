package algorithm.sort;

import java.util.Arrays;

/**
 * Created by YotWei on 2018/8/24.
 */
public class Client {

    public static void main(String[] args) {
        Integer[] arr = {7, 345, 3, 23, 1, 7, 2, 321354, -34545, 434, 2};

        Sort<Integer> sort = new MergeSort<>(Integer::compareTo);
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
