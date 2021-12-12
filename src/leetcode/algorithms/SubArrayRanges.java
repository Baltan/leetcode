package leetcode.algorithms;

/**
 * Description: 2104. Sum of Subarray Ranges
 *
 * @author Baltan
 * @date 2021/12/12 23:28
 */
public class SubArrayRanges {
    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    public static long subArrayRanges(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * 逐一计算每个子数组中的最大值和最小值之差，nums[i]为子数组的第一个元素，nums[j]为子数组的最后一个元素
         */
        for (int i = 0; i < length; i++) {
            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (max - min);
            }
        }
        return result;
    }
}
