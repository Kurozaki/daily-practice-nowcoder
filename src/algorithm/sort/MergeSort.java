package algorithm.sort;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YotWei on 2018/8/24.
 */
public class MergeSort<T> extends Sort<T> {

    MergeSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] arr) {
        if (arr.length <= 1)
            return;
        if (arr.length == 2 &&
                comparator.compare(arr[0], arr[1]) > 0) {
            T temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
            return;
        }

        int split = arr.length / 2;

        T[] left = Arrays.copyOfRange(arr, 0, split);
        T[] right = Arrays.copyOfRange(arr, split, arr.length);
        sort(left);
        sort(right);

        int li = 0, ri = 0;
        int i = 0;
        for (; ; ) {
            if (li < left.length && ri < right.length) {
                if (comparator.compare(left[li], right[ri]) < 0) {
                    arr[i] = left[li++];
                } else {
                    arr[i] = right[ri++];
                }
                i++;
            } else {
                if (li == left.length) {
                    for (; i < arr.length; i++) {
                        arr[i] = right[ri++];
                    }
                } else if (ri == right.length) {
                    for (; i < arr.length; i++) {
                        arr[i] = left[li++];
                    }
                }
                break;
            }
        }
    }

}
