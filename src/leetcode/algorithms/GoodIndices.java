package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2420. Find All Good Indices
 *
 * @author Baltan
 * @date 2022/12/17 14:39
 */
public class GoodIndices {
    public static void main(String[] args) {
        System.out.println(goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2));
        System.out.println(goodIndices(new int[]{2, 1, 1, 2}, 2));
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        /**
         * nonIncreasingCounts[i]表示到nums[i]为止连续非递增元素的个数
         */
        int[] nonIncreasingCounts = new int[length];
        /**
         * nonDecreasingCounts[i]表示从nums[i]开始连续非递减元素的个数
         */
        int[] nonDecreasingCounts = new int[length];
        nonIncreasingCounts[0] = 1;
        nonDecreasingCounts[length - 1] = 1;
        /**
         * 计算到每个数为止连续非递增元素的个数
         */
        for (int i = 1; i < length; i++) {
            nonIncreasingCounts[i] = nums[i] <= nums[i - 1] ? nonIncreasingCounts[i - 1] + 1 : 1;
        }
        /**
         * 计算从每个数开始连续非递减元素的个数
         */
        for (int i = length - 2; i >= 0; i--) {
            nonDecreasingCounts[i] = nums[i] <= nums[i + 1] ? nonDecreasingCounts[i + 1] + 1 : 1;
        }

        for (int i = k; i < length - k; i++) {
            if (nonIncreasingCounts[i - 1] >= k && nonDecreasingCounts[i + 1] >= k) {
                result.add(i);
            }
        }
        return result;
    }
}
