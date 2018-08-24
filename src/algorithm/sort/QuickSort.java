package algorithm.sort;

import java.util.Comparator;

/**
 * Created by YotWei on 2018/8/24.
 */
public class QuickSort<T> extends Sort<T> {

    QuickSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        T temp = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (comparator.compare(arr[j], temp) > 0 && i < j)
                j--;
            while (comparator.compare(arr[i], temp) <= 0 && i < j)
                i++;

            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
