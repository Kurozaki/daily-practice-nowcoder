package algorithm.sort;

import java.util.Comparator;

/**
 * Created by YotWei on 2018/8/24.
 */
public abstract class Sort<T> {

    protected Comparator<T> comparator;

    Sort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public abstract void sort(T[] arr);
}
