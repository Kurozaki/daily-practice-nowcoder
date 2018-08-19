package _20180819;


import java.util.Arrays;

/**
 * Created by YotWei on 2018/8/19.
 * <p>
 * 生成 n 位格雷码
 */
public class Q1 {

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        String[] nGrayCodes = grayCode.getGray(4);

        System.out.println(Arrays.toString(nGrayCodes));
    }

    static class GrayCode {

        public String[] getGray(int n) {
            String[] ans = new String[1 << n];
            char[] code = new char[n];
            for (int i = 0; i < code.length; i++)
                code[i] = '0';

            ans[0] = new String(code);
            for (int i = 1; i < ans.length; i++) {

                int chIndex = n - 1;
                if (i % 2 == 0) {
                    while (code[chIndex--] == '0') ;
                }
                code[chIndex] = code[chIndex] == '0' ? '1' : '0';

                ans[i] = new String(code);
            }
            return ans;
        }
    }
}
