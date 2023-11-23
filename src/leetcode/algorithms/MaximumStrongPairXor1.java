package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2935. Maximum Strong Pair XOR II
 *
 * @author baltan
 * @date 2023/11/23 09:53
 * @see MaximumStrongPairXor
 */
public class MaximumStrongPairXor1 {
    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maximumStrongPairXor(new int[]{10, 100}));
        System.out.println(maximumStrongPairXor(new int[]{500, 520, 2500, 3000}));
    }

    public static int maximumStrongPairXor(int[] nums) {
        int result = 0;
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int max = nums[i] * 2;
            int j = i + 1;

            while (j < length && nums[j] <= max) {
                result = Math.max(result, nums[i] ^ nums[j]);
                j++;
            }
        }
        return result;
    }
}
