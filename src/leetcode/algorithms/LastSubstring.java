package leetcode.algorithms;

/**
 * Description: 1163. Last Substring in Lexicographical Order
 *
 * @author Baltan
 * @date 2019-10-22 09:19
 */
public class LastSubstring {
    public static void main(String[] args) {
        System.out.println(lastSubstring("abab"));
        System.out.println(lastSubstring("leetcode"));
    }

    public static String lastSubstring(String s) {
        String max = "";
        int length = s.length();

        for (int i = 0; i < length; i++) {
            String substring = s.substring(i);
            max = substring.compareTo(max) > 0 ? substring : max;
        }
        return max;
    }
}
