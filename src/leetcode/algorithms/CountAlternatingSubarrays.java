package leetcode.algorithms;

/**
 * Description: 3101. Count Alternating Subarrays
 *
 * @author Baltan
 * @date 2024/4/5 18:48
 */
public class CountAlternatingSubarrays {
    public static void main(String[] args) {
        System.out.println(countAlternatingSubarrays(new int[]{0, 1, 1, 1}));
        System.out.println(countAlternatingSubarrays(new int[]{1, 0, 1, 0}));
    }

    public static long countAlternatingSubarrays(int[] nums) {
        long result = 0L;
        /**
         * 前一个元素的值
         */
        int prev = nums[0];
        /**
         * 当前交替子数组中元素的总个数
         */
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                /**
                 * 当前元素不能和已有的长度为count的子数组构成交替子数组，需要重新开始计数。对于长度为count的交替子数组而言，其中任意一段
                 * 长度为[1,count]的子数组都是交替子数组，共可以得到count*(count+1)/2个交替子数组
                 */
                result += (long) count * (count + 1) / 2;
                count = 1;
            } else {
                count++;
            }
            prev = nums[i];
        }
        /**
         * 加上数组nums末段所有可能的交替子数组
         */
        return result + (long) count * (count + 1) / 2;
    }
}
