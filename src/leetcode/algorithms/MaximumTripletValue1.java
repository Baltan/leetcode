package leetcode.algorithms;

/**
 * Description: 2874. Maximum Value of an Ordered Triplet II
 *
 * @author Baltan
 * @date 2023/10/7 12:42
 */
public class MaximumTripletValue1 {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{1000000, 1, 1000000}));
        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(maximumTripletValue(new int[]{1, 2, 3}));
    }

    public static long maximumTripletValue(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * 三元组第三个数之前所有数字的最大值
         */
        int max = Math.max(nums[0], nums[1]);
        /**
         * 三元组前两个数之差的最大值
         */
        int maxDiff = nums[0] - nums[1];
        /**
         * 遍历数组nums，以nums[i]作为三元组的第三个数字
         */
        for (int i = 2; i < length; i++) {
            result = Math.max(result, (long) maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            max = Math.max(max, nums[i]);
        }
        return result;
    }
}
