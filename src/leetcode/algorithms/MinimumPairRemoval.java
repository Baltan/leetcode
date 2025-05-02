package leetcode.algorithms;

/**
 * Description: 3507. Minimum Pair Removal to Sort Array I
 *
 * @author baltan
 * @date 2025/4/25 16:22
 */
public class MinimumPairRemoval {
    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5, 2, 3, 1}));
        System.out.println(minimumPairRemoval(new int[]{1, 2, 2}));
    }

    public static int minimumPairRemoval(int[] nums) {
        int result = 0;
        /**
         * 当前数组中最后一个元素的索引值
         */
        int endIndex = nums.length - 1;

        while (!judge(nums, endIndex)) {
            /**
             * 和最小的一对相邻元素中左边元素的索引值
             */
            int leftIndex = -1;
            /**
             * 相邻元素的最小和
             */
            int minSum = Integer.MAX_VALUE;

            for (int i = 1; i <= endIndex; i++) {
                if (nums[i - 1] + nums[i] < minSum) {
                    leftIndex = i - 1;
                    minSum = Math.min(minSum, nums[i - 1] + nums[i]);
                }
            }
            /**
             * 用nums[leftIndex]和nums[leftIndex+1]的和替代元素nums[leftIndex]
             */
            nums[leftIndex] = nums[leftIndex] + nums[leftIndex + 1];
            /**
             * 将nums[leftIndex+1]开始的每个元素都用其后一个元素替换
             */
            for (int i = leftIndex + 2; i <= endIndex; i++) {
                nums[i - 1] = nums[i];
            }
            /**
             * 更新剩余数组中最后一个元素的索引值
             */
            endIndex--;
            result++;
        }
        return result;
    }

    /**
     * 判断子数组数组nums[0……endIndex]是否是非递减的
     *
     * @param nums
     * @param endIndex
     * @return
     */
    public static boolean judge(int[] nums, int endIndex) {
        for (int i = 1; i <= endIndex; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
