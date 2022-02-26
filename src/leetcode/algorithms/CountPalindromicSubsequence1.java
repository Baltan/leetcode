package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1930. Unique Length-3 Palindromic Subsequences
 *
 * @author Baltan
 * @date 2022/2/25 21:43
 * @see CountPalindromicSubsequence
 */
public class CountPalindromicSubsequence1 {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/unique-length-3-palindromic-subsequences/solution/chang-du-wei-3-de-bu-tong-hui-wen-zi-xu-21trj/"></a>
     *
     * @param s
     * @return
     */
    public static int countPalindromicSubsequence(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 对于s的第0个到第i个这些字符，如果这些字符中存在'a'，则heads[i+1]的二进制表示的最低位为1，否则为0；……；如果这些字符
         * 中存在'z'，在heads[i+1]的二进制表示的从低到高的第25位为1，否则为0
         */
        int[] heads = new int[length + 1];
        /**
         * 对于s的第i个到最后一个字符，如果这些字符中存在'a'，则tails[i]的二进制表示的最低位为1，否则为0；……；如果这些字符中存
         * 在'z'，在tails[i]的二进制表示的从低到高的第25位为1，否则为0
         */
        int[] tails = new int[length + 1];
        /**
         * 如果字符串s中的任何一个字符'a'，其左右两边的子串中都有字符'a'，则merges[0]的二进制表示的最低位为1，否则为0；……；其
         * 左右两边的子串中都有字符'z'，则merges[0]的二进制表示的从低到高的第25位为1，否则为0
         * ……
         * 如果字符串s中的任何一个字符'z'，其左右两边的子串中都有字符'a'，则merges[25]的二进制表示的最低位为1，否则为0；……；
         * 其左右两边的子串中都有字符'z'，则merges[25]的二进制表示的从低到高的第25位为1，否则为0
         */
        int[] merges = new int[26];
        /**
         * 计算到字符s[i]为止的左边子串中，包含哪几个字符
         */
        for (int i = 0; i < length; i++) {
            heads[i + 1] = heads[i] | (1 << (charArray[i] - 'a'));
        }
        /**
         * 计算从字符s[i]开始的右边子串中，包含哪几个字符
         */
        for (int i = length - 1; i >= 0; i--) {
            tails[i] = tails[i + 1] | (1 << (charArray[i] - 'a'));
        }
        /**
         * 判断字符串s的第二个字符到倒数第二个字符分别作为回文字符串的中间字符时，两边可以是哪些字符
         */
        for (int i = length - 2; i > 0; i--) {
            /**
             * 字符s[i]的左边子串到s[i-1]为止，右边子串从s[i+1]开始。如果heads[i]和tails[i+1]的二进制表示的最低位都为1，则
             * 说明字符s[i]的两边都有字符'a'；……；如果heads[i]和tails[i+1]的二进制表示的从低到高的第25位都为1，则说明字符
             * s[i]的两边都有字符'z'
             */
            int num = heads[i] & tails[i + 1];
            /**
             * 汇总字符串s中出现过的所有的字符s[i]两边共同存在的字符
             */
            merges[charArray[i] - 'a'] |= num;
        }
        return Arrays.stream(merges)
                .map(num -> oneBitCount(num))
                .sum();
    }

    /**
     * 数字num的二进制表示中1的个数
     *
     * @param num
     * @return
     */
    public static int oneBitCount(int num) {
        int count = 0;

        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
