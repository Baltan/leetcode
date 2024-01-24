package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3016. Minimum Number of Pushes to Type Word II
 *
 * @author baltan
 * @date 2024/1/23 10:51
 * @see MinimumPushes
 */
public class MinimumPushes1 {
    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public static int minimumPushes(String word) {
        int result = 0;
        /**
         * 8个按键上已有字母的总个数
         */
        int totalCount = 0;
        /**
         * counts[i]表示字符串word中字符(char)(i+'a')出现的次数
         */
        int[] counts = new int[26];

        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        Arrays.sort(counts);
        /**
         * 对于每个字母来说，在字符串word中出现的次数越多，在键盘上输入它按键的次数就应该越少
         */
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 0) {
                break;
            }
            /**
             * 8个按键中字母最少的一个按键上字母的个数，将当前字母counts[i]设置在这个按键上
             */
            int minCount = totalCount / 8;
            result += (minCount + 1) * counts[i];
            totalCount++;
        }
        return result;
    }
}
