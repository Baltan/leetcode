package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3306. Count of Substrings Containing Every Vowel and K Consonants II
 *
 * @author Baltan
 * @date 2024/10/2 18:30
 * @see CountOfSubstrings
 */
public class CountOfSubstrings1 {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("iqeaouqi", 2));
        System.out.println(countOfSubstrings("aeioqq", 1));
        System.out.println(countOfSubstrings("aeiou", 0));
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public static long countOfSubstrings(String word, int k) {
        long result = 0L;
        int length = word.length();
        /**
         * vowelCounts[i][0]-vowelCounts[i][4]依次表示word的前缀子串word.substring(0,i)中元音字母a、e、i、o、u的个数
         */
        int[][] vowelCounts = new int[length + 1][5];
        /**
         * 按顺序保存word中所有辅音字母的索引值
         */
        List<Integer> consonantIndexes = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            System.arraycopy(vowelCounts[i], 0, vowelCounts[i + 1], 0, 5);

            if (c == 'a') {
                vowelCounts[i + 1][0]++;
            } else if (c == 'e') {
                vowelCounts[i + 1][1]++;
            } else if (c == 'i') {
                vowelCounts[i + 1][2]++;
            } else if (c == 'o') {
                vowelCounts[i + 1][3]++;
            } else if (c == 'u') {
                vowelCounts[i + 1][4]++;
            } else {
                consonantIndexes.add(i);
            }
            /**
             * 当前已得到的辅音字母的个数
             */
            int consonantCount = consonantIndexes.size();

            if (consonantCount >= k) {
                /**
                 * 如果当前得到的辅音字母个数大于k个，则符合条件的子串至多从倒数第k+1个辅音字母的后一个字母开始，否则子串可以从word[0]开始
                 */
                int lo = consonantCount > k ? consonantIndexes.get(consonantIndexes.size() - k - 1) + 1 : 0;
                /**
                 * 如果子串中至少要有一个辅音字母，则符合条件的子串至多在倒数第k个辅音字母开始，否则子串可以从word[i]开始
                 */
                int hi = k == 0 ? i : consonantIndexes.get(consonantIndexes.size() - k);
                int maxLo = getMaxLo(vowelCounts, i, lo, hi);

                if (maxLo != -1) {
                    result += maxLo - lo + 1;
                }
            }
        }
        return result;
    }

    /**
     * 当字符串的最后一个字母为word[right]时，二分计算符合条件的子串中，第一个字母可能的最大索引值
     *
     * @param vowelCounts
     * @param right       子串最后一个字母的索引值
     * @param lo          子串第一个字母的索引值的下限
     * @param hi          子串第一个字母的索引值的上限
     * @return
     */
    public static int getMaxLo(int[][] vowelCounts, int right, int lo, int hi) {
        if (!containsEveryVowel(vowelCounts, lo, right)) {
            return -1;
        }

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (!containsEveryVowel(vowelCounts, mid, right)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    /**
     * 判断子串words.subtring(start,end+1)中是否包含所有元音字母
     *
     * @param vowelCounts
     * @param start
     * @param end
     * @return
     */
    public static boolean containsEveryVowel(int[][] vowelCounts, int start, int end) {
        for (int i = 0; i < 5; i++) {
            if (vowelCounts[end + 1][i] - vowelCounts[start][i] == 0) {
                return false;
            }
        }
        return true;
    }
}
