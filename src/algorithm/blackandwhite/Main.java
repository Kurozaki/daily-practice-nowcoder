package algorithm.blackandwhite;


/**
 * Created by YotWei on 2018/8/28.
 */
public class Main {
    public static void main(String[] args) {
        new BlackAndWhite().blackAndWhite(
                new String[]{
                        "221122",
                        "221122",
                        "112211",
                        "112211",
                        "221122",
                        "221122"
                }, new String[]{
                        "110101",
                        "110011",
                        "010111",
                        "001011",
                        "100101",
                        "101010"
                });
    }
}
