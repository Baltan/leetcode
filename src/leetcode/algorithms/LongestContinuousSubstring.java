package leetcode.algorithms;

/**
 * Description: 2414. Length of the Longest Alphabetical Continuous Substring
 *
 * @author Baltan
 * @date 2022/12/18 20:00
 */
public class LongestContinuousSubstring {
    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(longestContinuousSubstring("abacaba"));
        System.out.println(longestContinuousSubstring("abcde"));
    }

    public static int longestContinuousSubstring(String s) {
        int result = 1;
        int length = s.length();
        char[] charArray = s.toCharArray();
        /**
         * 当前得到的字母序连续子串的长度
         */
        int currLength = 1;

        for (int i = 1; i < length; i++) {
            if (charArray[i] - charArray[i - 1] == 1) {
                /**
                 * 将已有的字母序连续子串延长一个长度
                 */
                currLength++;
                result = Math.max(result, currLength);
            } else {
                /**
                 * 开始一个新的字母序连续子串
                 */
                currLength = 1;
            }
        }
        return result;
    }
}
