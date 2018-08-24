package algorithm.sort;

import java.util.Comparator;

/**
 * Created by YotWei on 2018/8/24.
 */
public class IntegerQuickSort extends QuickSort<Integer> {

    public IntegerQuickSort() {
        super(Comparator.comparingInt(o -> o));
    }
}
