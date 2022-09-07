package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1679. Max Number of K-Sum Pairs
 *
 * @author Baltan
 * @date 2022/9/4 14:32
 * @see MaxOperations
 */
public class MaxOperations1 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        int result = 0;
        int lo = 0;
        int hi = nums.length - 1;
        Arrays.sort(nums);
        /**
         * 双指针，当两个指针指向的两数之和不等于k时，就移动其中一个指针使和更靠近k
         */
        while (lo < hi) {
            if (nums[lo] + nums[hi] < k) {
                lo++;
            } else if (nums[lo] + nums[hi] > k) {
                hi--;
            } else {
                lo++;
                hi--;
                result++;
            }
        }
        return result;
    }
}
