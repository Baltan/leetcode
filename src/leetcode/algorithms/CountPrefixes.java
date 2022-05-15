package leetcode.algorithms;

/**
 * Description: 2255. Count Prefixes of a Given String
 *
 * @author Baltan
 * @date 2022/5/15 12:06
 */
public class CountPrefixes {
    public static void main(String[] args) {
        System.out.println(countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc"));
        System.out.println(countPrefixes(new String[]{"a", "a"}, "aa"));
    }

    public static int countPrefixes(String[] words, String s) {
        int result = 0;

        for (String word : words) {
            if (s.startsWith(word)) {
                result++;
            }
        }
        return result;
    }
}
