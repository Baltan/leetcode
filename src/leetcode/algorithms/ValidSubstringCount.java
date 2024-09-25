package leetcode.algorithms;

/**
 * Description: 3297. Count Substrings That Can Be Rearranged to Contain a String I
 *
 * @author baltan
 * @date 2024/9/25 18:34
 */
public class ValidSubstringCount {
    public static void main(String[] args) {
        System.out.println(validSubstringCount("bcca", "abc"));
        System.out.println(validSubstringCount("abcabc", "abc"));
        System.out.println(validSubstringCount("abcabc", "aaabc"));
    }

    public static long validSubstringCount(String word1, String word2) {
        long result = 0L;
        /**
         * prefixCounts[i][0]-prefixCounts[i][25]依次表示字符串word1的前缀子串word1.substring(0,i)中字母a-z的个数
         */
        int[][] prefixCounts = new int[word1.length() + 1][26];
        /**
         * counts[0]-counts[25]依次表示字符串word2中字母a-z的个数
         */
        int[] counts = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            prefixCounts[i + 1] = prefixCounts[i].clone();
            prefixCounts[i + 1][word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            counts[word2.charAt(i) - 'a']++;
        }
        loop1:
        for (int i = 0; i < word1.length(); i++) {
            int lo = i;
            int hi = word1.length();
            /**
             * 二分计算字符串word1中，以word1[i]作为第一个字符的子串中，每个小写字母的数量都不少于word2的最短子串
             */
            loop2:
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                for (int j = 0; j < 26; j++) {
                    /**
                     * 子串word1.substring(i,mid)中当前字母的数量小于word2，必须增长子串
                     */
                    if (prefixCounts[mid][j] - prefixCounts[i][j] < counts[j]) {
                        lo = mid + 1;
                        continue loop2;
                    }
                }
                hi = mid;
            }
            /**
             * 判断子串word1.substring(i,lo)中，是否每个小写字母的数量都不少于word2
             */
            for (int j = 0; j < 26; j++) {
                if (prefixCounts[lo][j] - prefixCounts[i][j] < counts[j]) {
                    continue loop1;
                }
            }
            result += word1.length() - lo + 1;
        }
        return result;
    }
}
