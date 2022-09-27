package leetcode.algorithms;

/**
 * Description: 1638. Count Substrings That Differ by One Character
 *
 * @author Baltan
 * @date 2022/9/20 09:53
 */
public class CountSubstrings1 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aba", "baba"));
        System.out.println(countSubstrings("ab", "bb"));
    }

    public static int countSubstrings(String s, String t) {
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int sStart = 0; sStart < sLength; sStart++) {
            for (int tStart = 0; tStart < tLength; tStart++) {
                /**
                 * s的子串和t的子串中不同字符的个数
                 */
                int diffCount = 0;
                /**
                 * 以s[sStart]打头的子串的最大长度
                 */
                int maxLength = sLength - sStart;

                for (int length = 1; length <= maxLength; length++) {
                    /**
                     * 以t[tStart]打头的长度为length的子串超出了字符串t的范围
                     */
                    if (tStart + length - 1 == tLength) {
                        break;
                    }

                    if (sChars[sStart + length - 1] != tChars[tStart + length - 1]) {
                        diffCount++;
                    }

                    if (diffCount == 1) {
                        result++;
                    } else if (diffCount > 1) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
