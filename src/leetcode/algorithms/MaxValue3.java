package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3660. Jump Game IX
 *
 * @author baltan
 * @date 2025/9/23 17:43
 */
public class MaxValue3 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maxValue(new int[]{2, 1, 3}));
        OutputUtils.print1DIntegerArray(maxValue(new int[]{2, 3, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/jump-game-ix/solutions/3762167/jie-lun-ti-pythonjavacgo-by-endlesscheng-x2qu/"></a>
     *
     * @param nums
     * @return
     */
    public static int[] maxValue(int[] nums) {
        int[] result = new int[nums.length];
        int length = nums.length;
        /**
         * 数组nums某个元素之后的后缀子数组中的最小元素
         */
        int min = Integer.MAX_VALUE;
        /**
         * maxArray[i]表示数组nums的前缀子数组nums[0……i]中的最大元素
         */
        int[] maxArray = new int[length];
        maxArray[0] = nums[0];

        for (int i = 1; i < length; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], nums[i]);
        }
        /**
         * 对于元素nums[i]，如果nums[0……i]中的最大值小于等于nums[i+1……length-1]中的最小值，说明nums[i]小于等于nums[i+1……length-1]
         * 中的所有元素，则不可能从nums[i]向右跳到更小的数字，只能不动或直接向左跳到nums[0……i]中的最大值maxArray[i]。否则总能从nums[i]
         * 先到达maxArray[i]，再从maxArray[i]向右跳到nums[i+1]，此时result[i]就等于result[i+1]。
         */
        for (int i = length - 1; i >= 0; i--) {
            result[i] = maxArray[i] <= min ? maxArray[i] : result[i + 1];
            min = Math.min(min, nums[i]);
        }
        return result;
    }
}
