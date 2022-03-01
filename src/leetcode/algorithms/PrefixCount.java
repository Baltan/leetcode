package leetcode.algorithms;

/**
 * Description: 2185. Counting Words With a Given Prefix
 *
 * @author Baltan
 * @date 2022/3/1 10:10
 */
public class PrefixCount {
    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend" }, "at"));
        System.out.println(prefixCount(new String[]{"leetcode", "win", "loops", "success" }, "code"));
    }

    public static int prefixCount(String[] words, String pref) {
        int result = 0;

        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                result++;
            }
        }
        return result;
    }
}
