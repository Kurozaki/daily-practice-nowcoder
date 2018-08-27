package _20180827;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YotWei on 2018/8/27.
 * <p>
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreak {
    /*
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();

        boolean[][] rec = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                rec[i][j] = dict.contains(s.substring(i, j));
            }
        }
        dfs(s.length(), "", s, rec, list);
        return list;
    }

    private void dfs(int pos, String ans, String s, boolean[][] rec, ArrayList<String> result) {
        if (pos == 0) {
            result.add(ans.substring(1));
            return;
        }
        for (int i = 0; i < rec.length; i++) {
            if (rec[i][pos]) {
                dfs(i, " " + s.substring(i, pos) + ans, s, rec, result);
            }
        }
    }
    */

    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        ArrayList<String> result = new ArrayList<>();
        dfs(s, dict, "", result);
        return result;
    }

    private void dfs(String s, Set<String> dict, String ans, ArrayList<String> result) {
        if (s.equals("")) {
            result.add(ans.substring(1));
            return;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                dfs(s.substring(word.length()), dict, ans + " " + word, result);
            }
        }
    }


    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
//        ArrayList<String> ans = wb.wordBreak("catsanddog", new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog")));
        ArrayList<String> ans = wb.wordBreak("abababababababab", new HashSet<>(Arrays.asList("a", "b", "ab", "ba")));

        ans.sort(String::compareTo);
        System.out.println(ans);
    }
}
