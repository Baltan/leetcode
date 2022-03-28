package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2217. Find Palindrome With Fixed Length
 *
 * @author Baltan
 * @date 2022/3/27 21:24
 */
public class KthPalindrome {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(kthPalindrome(new int[]{2, 201429812, 8, 520498110, 492711727, 339882032,
                462074369, 9, 7, 6}, 1));
        OutputUtils.print1DLongArray(kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3));
        OutputUtils.print1DLongArray(kthPalindrome(new int[]{2, 4, 6}, 4));
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        /**
         * 回文数字前半部分的长度（如果回文数字总长度为奇数，则取中间这个数字之前这部分的长度）
         */
        int halfLength = intLength / 2;
        /**
         * 满足长度为intLength的回文数字的总个数
         */
        int total;

        if (intLength == 1) {
            /**
             * 如果回文数字总长度为1，则范围可以为[1,9]，共9个
             */
            total = 9;
        } else if (intLength % 2 == 0) {
            /**
             * 如果回文数字总长度为偶数，例如4，则前半部分数字的长度为2，范围可以为[10,99]，共9*10^1个，所以回文数字总个数为
             * 9*10^1个
             */
            total = (int) (9 * Math.pow(10, halfLength - 1));
        } else {
            /**
             * 如果回文数字总长度为奇数，例如5，则前半部分数字的长度为2，范围可以为[10,99]，共9*10^1个，最中间的数字可以为
             * [0,9]，所以回文数字总个数为90*10^1个
             */
            total = (int) (90 * Math.pow(10, halfLength - 1));
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > total) {
                result[i] = -1;
            } else if (intLength == 1) {
                /**
                 * 对于总长度为1的回文数字，第几个回文数字就是几
                 */
                result[i] = queries[i];
            } else {
                /**
                 * 对于总长度为偶数的回文数字，例如4，则前半部分数字的长度为2，范围可以为[10,99]，可以求得，第i个数字为
                 * 10^1+i-1，后半部分拼上这个2位数的倒序数即可
                 */
                if (intLength % 2 == 0) {
                    String head = String.valueOf((int) Math.pow(10, halfLength - 1) + queries[i] - 1);
                    result[i] = Long.valueOf(head + reverseString(head));
                } else {
                    /**
                     * 对于同样的前半部分数字，最中间的数字可以为[0,9]，所以将每十个回文数看成一组
                     */
                    int group = (queries[i] + 9) / 10;
                    /**
                     * 同一组回文数的第i个数字中间数字为i-1，即第1-10个回文数中间数字依次为0-9
                     */
                    int mid = (queries[i] + 9) % 10;
                    /**
                     * 对于总长度为奇数的回文数字，例如5，则前半部分数字的长度为2，范围可以为[10,99]，可以求得，第i组数字为
                     * 10^1+group-1，后面依次拼上最中间的数字和这个2位数的倒序数即可
                     */
                    String head = String.valueOf((int) Math.pow(10, halfLength - 1) + (group - 1));
                    result[i] = Long.parseLong(head + mid + reverseString(head));
                }
            }
        }
        return result;
    }

    /**
     * 获得字符串str的倒序字符串
     *
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
