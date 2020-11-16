package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1647. Minimum Deletions to Make Character Frequencies Unique
 *
 * @author Baltan
 * @date 2020-11-16 20:28
 */
public class MinDeletions {
    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }

    public static int minDeletions(String s) {
        int result = 0;
        /**
         * 对每个字母出现的次数进行计数
         */
        int[] count = new int[26];
        char[] charArray = s.toCharArray();
        /**
         * 保存已经出现过的频数
         */
        Set<Integer> set = new HashSet<>();

        for (char c : charArray) {
            count[c - 'a']++;
        }

        for (int value : count) {
            /**
             * 如果当前频数value已经出现过，就将value逐一递减直到value减为0或者为一个没有出现过的频
             * 数为止
             */
            while (value != 0 && set.contains(value)) {
                value--;
                result++;
            }
            /**
             * 保存变更后的频数
             */
            if (value != 0) {
                set.add(value);
            }
        }
        return result;
    }
}
