package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 128. Longest Consecutive Sequence
 *
 * @author Baltan
 * @date 2019-05-28 08:52
 */
public class LongestConsecutive {
    public static void main(String[] args) {
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
        Set<Long> isVisited = new HashSet<>();

        for (int num : nums) {
            set.add((long) num);
        }

        for (long num : set) {
            if (!isVisited.contains(num)) {
                int count = 1;
                isVisited.add(num);
                long i = num + 1;
                long j = num - 1;

                while (set.contains(i) && !isVisited.contains(i)) {
                    count++;
                    isVisited.add(i);
                    i++;
                }

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
