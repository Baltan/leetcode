package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1663. Smallest String With A Given Numeric Value
 *
 * @author Baltan
 * @date 2020-11-28 15:43
 */
public class GetSmallestString {
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
        System.out.println(getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k) {
        char[] result = new char[n];
        /**
         * 先将n个字符都初始化为"a"
         */
        Arrays.fill(result, 'a');
        k -= n;
        /**
         * 从后向前将所有字母尽可能地放大，直到使得字符串的数值变为k
         */
        for (int i = n - 1; i >= 0; i--) {
            int diff = Math.min(25, k);
            result[i] = (char) ('a' + diff);
            k -= diff;

            if (k == 0) {
                break;
            }
        }
        return new String(result);
    }
}
