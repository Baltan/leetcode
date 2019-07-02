package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Random;

/**
 * Description: 384. Shuffle an Array
 *
 * @author Baltan
 * @date 2019-07-02 09:14
 */
public class Solution2 {
    private int[] initNums;
    private int[] nums;
    private Random rand;

    public Solution2(int[] nums) {
        this.initNums = nums;
        this.nums = initNums.clone();
        this.rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        nums = initNums.clone();
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int j = rand.nextInt(i + 1);
            /**
             * 交换nums[i]和nums[j]
             */
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2(nums);
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.reset());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.reset());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
        OutputUtils.print1DIntegerArray(solution.shuffle());
    }
}
