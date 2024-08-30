package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3264. Final Array State After K Multiplication Operations I
 *
 * @author baltan
 * @date 2024/8/30 09:29
 */
public class GetFinalState {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2));
        OutputUtils.print1DIntegerArray(getFinalState(new int[]{1, 2}, 3, 4));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        /**
         * 保存数组nums中所有元素的索引值，所有索引值优先按照对应数组nums中的数字大小升序排列，否则再按照索引值大小升序排列
         */
        Queue<Integer> indexes = new PriorityQueue<>((x, y) -> nums[x] == nums[y] ? x - y : nums[x] - nums[y]);

        for (int i = 0; i < nums.length; i++) {
            indexes.offer(i);
        }

        for (int i = 0; i < k; i++) {
            int index = indexes.poll();
            nums[index] *= multiplier;
            indexes.offer(index);
        }
        return nums;
    }
}
