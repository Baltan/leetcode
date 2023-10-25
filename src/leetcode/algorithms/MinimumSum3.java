package leetcode.algorithms;

/**
 * Description: 2908. Minimum Sum of Mountain Triplets I
 *
 * @author Baltan
 * @date 2023/10/22 19:00
 * @see MinimumSum2
 */
public class MinimumSum3 {
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(minimumSum(new int[]{6, 5, 4, 3, 4, 5}));
    }

    public static int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        /**
         * 遍历所有可能的三元组，其中，nums[i]为三元组中中间的元素
         */
        for (int i = 1; i < nums.length - 1; i++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;
            /**
             * 数组nums中索引值小于i的元素中的最小值
             */
            for (int j = 0; j < i; j++) {
                leftMin = Math.min(leftMin, nums[j]);
            }
            /**
             * 数组nums中索引值大于i的元素中的最小值
             */
            for (int j = i + 1; j < nums.length; j++) {
                rightMin = Math.min(rightMin, nums[j]);
            }
            /**
             * 如果元素nums[i]左右都存在小于它的元素，则可以构成一个满足题意的三元组
             */
            if (leftMin < nums[i] && rightMin < nums[i]) {
                result = Math.min(result, leftMin + nums[i] + rightMin);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
