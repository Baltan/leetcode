package leetcode.algorithms;

/**
 * Description: 2207. Maximize Number of Subsequences in a String
 *
 * @author Baltan
 * @date 2022/3/25 18:04
 */
public class MaximumSubsequenceCount {
    public static void main(String[] args) {
        System.out.println(maximumSubsequenceCount("abdcdbc", "ac"));
        System.out.println(maximumSubsequenceCount("aabb", "ab"));
        System.out.println(maximumSubsequenceCount("aabbaa", "aa"));
    }

    public static long maximumSubsequenceCount(String text, String pattern) {
        char char1 = pattern.charAt(0);
        char char2 = pattern.charAt(1);
        /**
         * 将pattern的第一个字符加到text的最前面或者将pattern的第二个字符加到text的最后面,才有可能在text中得到尽可能多的子串
         * pattern
         */
        return Math.max(subsequenceCount(char1 + text, char1, char2),
                subsequenceCount(text + char2, char1, char2));
    }

    /**
     * 查找字符串text中有多少子串pattern，pattern的第一个字符为char1，第二个字符为char2
     *
     * @param text
     * @param char1
     * @param char2
     * @return
     */
    public static long subsequenceCount(String text, char char1, char char2) {
        long result = 0L;
        /**
         * 已出现过的char1的个数
         */
        int count1 = 0;

        for (char c : text.toCharArray()) {
            /**
             * 当前char2可以和它前面的所有char1构成子串pattern
             */
            if (c == char2) {
                result += count1;
            }

            if (c == char1) {
                count1++;
            }
        }
        return result;
    }
}
