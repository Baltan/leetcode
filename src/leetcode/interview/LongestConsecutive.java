package leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 剑指 Offer II 119. 最长连续序列
 *
 * @author Baltan
 * @date 2022/2/24 11:15
 * @see leetcode.algorithms.LongestConsecutive
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{}));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{}));
        System.out.println(longestConsecutive(new int[]{1}));
        System.out.println(longestConsecutive(new int[]{1, 2}));
        System.out.println(longestConsecutive(
                new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645}));
    }

    public static int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Long> set = new HashSet<>();
        /**
         * 记录已经在连续序列中计算过的数字
         */
        Set<Long> isVisited = new HashSet<>();

        for (int num : nums) {
            set.add((long) num);
        }

        for (long num : set) {
            /**
             * 已经计算过的数字不再重复计算
             */
            if (!isVisited.contains(num)) {
                /**
                 * 当前包含num的连续序列的长度
                 */
                int count = 1;
                isVisited.add(num);
                long i = num + 1;
                long j = num - 1;
                /**
                 * 从num开始向后计算连续序列的长度
                 */
                while (set.contains(i) && !isVisited.contains(i)) {
                    count++;
                    isVisited.add(i);
                    i++;
                }
                /**
                 * 从num开始向前计算连续序列的长度
                 */
                while (set.contains(j) && !isVisited.contains(j)) {
                    count++;
                    isVisited.add(j);
                    j--;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
