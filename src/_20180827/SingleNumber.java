package _20180827;

/**
 * Created by YotWei on 2018/8/27.
 */
public class SingleNumber {

    public int singleNumber(int[] arr) {
        int one = 0, two = 0;
        for (int i : arr) {
            one = i ^ one ^ two;
            two = i & one;
        }
        return one ^ two;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[]{1, 2, 3, 2, 3, 2, 3, 4, 1, 1}));
    }
}
