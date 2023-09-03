package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2840. Check if Strings Can be Made Equal With Operations II
 *
 * @author Baltan
 * @date 2023/9/3 13:12
 */
public class CheckStrings {
    public static void main(String[] args) {
        System.out.println(checkStrings("abcdba", "cabdab"));
        System.out.println(checkStrings("abe", "bea"));
    }

    public static boolean checkStrings(String s1, String s2) {
        int length = s1.length();
        /**
         * evenCounts1[0]-evenCounts1[25]依次代表字符串s1的偶数索引上a-z的个数
         */
        int[] evenCounts1 = new int[26];
        /**
         * oddCounts1[0]-oddCounts1[25]依次代表字符串s1的奇数索引上a-z的个数
         */
        int[] oddCounts1 = new int[26];
        /**
         * evenCounts2[0]-evenCounts2[25]依次代表字符串s2的偶数索引上a-z的个数
         */
        int[] evenCounts2 = new int[26];
        /**
         * oddCounts2[0]-oddCounts2[25]依次代表字符串s2的奇数索引上a-z的个数
         */
        int[] oddCounts2 = new int[26];
        /**
         * 统计字符串s1和s2偶数索引和奇数索引上a-z分别出现的次数
         */
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenCounts1[s1.charAt(i) - 'a']++;
                evenCounts2[s2.charAt(i) - 'a']++;
            } else {
                oddCounts1[s1.charAt(i) - 'a']++;
                oddCounts2[s2.charAt(i) - 'a']++;
            }
        }
        /**
         * 因为偶数索引上的字符只能和偶数索引上的交换，奇数索引上的字符只能和奇数索引上的交换，所以如果最终s1能变得和s2相同，则偶数索引和奇数
         * 索引上a-z分别出现的次数应该是完全一致的
         */
        return Arrays.equals(evenCounts1, evenCounts2) && Arrays.equals(oddCounts1, oddCounts2);
    }
}
