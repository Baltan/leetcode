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
        System.out.println(lastSubstring(
                "xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"
        ));
    }

    public static String lastSubstring(String s) {
        int maxHead = s.charAt(0);
        int maxHeadIndex = 0;
        int length = s.length();

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);

            if (c > maxHead) {
                maxHead = c;
                maxHeadIndex = i;
            } else if (c == maxHead && isGreater(s, maxHeadIndex, i)) {
                maxHead = c;
                maxHeadIndex = i;
            }
        }
        return s.substring(maxHeadIndex);
    }

    public static boolean isGreater(String s, int i, int j) {
        int length = s.length();

        while (i < length && j < length) {
            if (s.charAt(j) > s.charAt(i)) {
                return true;
            } else if (s.charAt(j) < s.charAt(i)) {
                return false;
            }
            i++;
            j++;
        }
        return false;
    }
}
