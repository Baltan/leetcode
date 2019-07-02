package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: 384. Shuffle an Array
 *
 * @author Baltan
 * @date 2019-07-02 09:14
 */
public class Solution1 {
    private int[] initNums;
    private int[] nums;
    private Random rand;

    public Solution1(int[] nums) {
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
        List<Integer> list = IntStream.range(0, length).boxed().collect(Collectors.toList());

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(length - i);
            nums[i] = initNums[list.get(index)];
            list.remove(index);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution1 solution = new Solution1(nums);
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
