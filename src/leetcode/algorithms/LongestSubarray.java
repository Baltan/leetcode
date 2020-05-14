package leetcode.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * @author Baltan
 * @date 2020-05-13 23:02
 */
public class LongestSubarray {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/hua-dong-chuang-kou-shi-jian-0n-kong-jian-0n-by-ja/"></a>
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);
        int max = nums[0];
        int min = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; ) {
            if (Math.abs(max - nums[i]) <= limit && Math.abs(min - nums[i]) <= limit) {
                queue.offer(nums[i]);
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                result = Math.max(result, queue.size());
                i++;
            } else {
                queue.poll();

                if (queue.isEmpty()) {
                    queue.offer(nums[i]);
                    max = nums[i];
                    min = nums[i];
                    i++;
                } else {
                    max = Collections.max(queue);
                    min = Collections.min(queue);
                }
            }
        }
        return result;
    }
}
