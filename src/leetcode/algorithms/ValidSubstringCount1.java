package leetcode.algorithms;

/**
 * Description: 3298. Count Substrings That Can Be Rearranged to Contain a String II
 *
 * @author baltan
 * @date 2024/9/26 16:53
 * @see ValidSubstringCount
 */
public class ValidSubstringCount1 {
    public static void main(String[] args) {
        System.out.println(validSubstringCount("bcca", "abc"));
        System.out.println(validSubstringCount("abcabc", "abc"));
        System.out.println(validSubstringCount("abcabc", "aaabc"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/solutions/2925828/on-hua-dong-chuang-kou-qiu-ge-shu-python-0x7a/"></a>
     *
     * @param word1
     * @param word2
     * @return
     */
    public static long validSubstringCount(String word1, String word2) {
        long result = 0L;
        int left = 0;
        /**
         * diffs[0]-diffs[25]依次表示字符a-z在word1的子串中比word2少的个数
         */
        int[] diffs = new int[26];
        /**
         * word1的子串中比word2少的不同字符的个数
         */
        int less = 0;
        /**
         * 初始时，word1的子串为空串，子串中某个字符比word2少的个数即为word2中该字符的个数
         */
        for (char c : word2.toCharArray()) {
            diffs[c - 'a']++;
        }

        for (int diff : diffs) {
            if (diff > 0) {
                less++;
            }
        }
        /**
         * 用一个滑动窗口维护子串中的字符，外层循环移动窗口的上界，将word1中的字符逐一加入到窗口中，内层循环移动窗口的下界，将word1中的字符
         * 逐一从窗口移出
         */
        for (char c : word1.toCharArray()) {
            /**
             * 窗口中加入字符c后，word1的子串中字符c比word2中少的个数减少一个
             */
            diffs[c - 'a']--;
            /**
             * 因为此时字符c在word1的子串中和word2中的个数相等，所以word1的子串中比word2少的不同字符的个数减少一个
             */
            if (diffs[c - 'a'] == 0) {
                less--;
            }
            /**
             * 右移窗口的下界，直到存在某个字符在word2中的个数比word1的子串中多，换言之，只要当前窗口中word1的子串是合法的，就一直右移窗口
             * 的下界，将word1的子串头部的字符逐一移除
             */
            while (less == 0) {
                /**
                 * word1的子串头部的移除的字符
                 */
                char removal = word1.charAt(left);
                left++;
                /**
                 * 因为原本窗口中word1的子串中字符removal的个数和word2中的相同，现在移除removal后，就使得word1的子串中比word2少的不同
                 * 字符增加了removal
                 */
                if (diffs[removal - 'a'] == 0) {
                    less++;
                }
                /**
                 * 同时，word1的子串中字符removal比word2中少的个数增加一个
                 */
                diffs[removal - 'a']++;
            }
            /**
             * 当前窗口中word1的子串虽然不合法，但是子串头部逐一加上之前移除的字符后，都是合法的，即当窗口下界为[0,left-1]时的子串都是合法
             * 的，共计有left个合法子串
             */
            result += left;
        }
        return result;
    }
}
