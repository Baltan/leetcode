package leetcode.algorithms;

/**
 * Description: 2909. Minimum Sum of Mountain Triplets II
 *
 * @author Baltan
 * @date 2023/10/22 16:39
 * @see MinimumSum3
 */
public class MinimumSum2 {
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(minimumSum(new int[]{6, 5, 4, 3, 4, 5}));
    }

    public static int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * help[i]表示数组nums索引值大于i的元素中，小于nums[i]的最小值。根据题意，nums[x]∈[1,100000000]，当不存在小于nums[i]的元素时，
         * 保持help[i]为默认值0
         */
        int[] help = new int[length];
        /**
         * 数组nums索引值大于i的元素中的最小值
         */
        int min = Integer.MAX_VALUE;

        for (int i = length - 2; i > 0; i--) {
            /**
             * 计算索引值大于i的元素中的最小值
             */
            min = Math.min(min, nums[i + 1]);

            if (min < nums[i]) {
                help[i] = min;
            }
        }
        /**
         * 数组nums索引值小于i的元素中的最小值
         */
        min = Integer.MAX_VALUE;

        for (int i = 1; i < length; i++) {
            /**
             * 计算索引值小于i的元素中的最小值
             */
            min = Math.min(min, nums[i - 1]);
            /**
             * 如果nums[i]的左右两侧都存在小于nums[i]的元素，则可以得到一个满足题意的三元组
             */
            if (min < nums[i] && help[i] != 0) {
                result = Math.min(result, min + nums[i] + help[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
