package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3036. Number of Subarrays That Match a Pattern II
 *
 * @author baltan
 * @date 2024/2/20 09:02
 * @see CountMatchingSubarrays
 */
public class CountMatchingSubarrays1 {
    public static void main(String[] args) {
        System.out.println(countMatchingSubarrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1}));
        System.out.println(countMatchingSubarrays(new int[]{1, 4, 4, 1, 3, 5, 5, 3}, new int[]{1, 0, -1}));
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int result = 0;
        int[] trend = new int[nums.length - 1];
        int[] next = new int[pattern.length + 1];
        int now = 0;

        for (int i = 1; i < nums.length; i++) {
            trend[i - 1] = Integer.compare(nums[i], nums[i - 1]);
        }

        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[now]) {
                now++;
                next[i] = now;
                i++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                i++;
                next[i] = now;
            }
        }

        System.out.println(Arrays.toString(trend));
        System.out.println(Arrays.toString(next));
        System.out.println("----");
        return result;
    }
}
