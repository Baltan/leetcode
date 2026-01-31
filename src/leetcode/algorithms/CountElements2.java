package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3759. Count Elements With at Least K Greater Values
 *
 * @author baltan
 * @date 2026/1/27 15:29
 */
public class CountElements2 {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{621202893}, 0));
        System.out.println(countElements(new int[]{3, 1, 2}, 1));
        System.out.println(countElements(new int[]{5, 5, 5}, 2));
    }

    public static int countElements(int[] nums, int k) {
        if (k == 0) {
            return nums.length;
        }
        int result = 0;
        /**
         * 当前元素num的前一个元素是否是合格元素。对于数组nums中的最大元素，当k不为0时，其肯定不是合格元素
         */
        boolean prevQualified = false;
        Arrays.sort(nums);

        for (int i = nums.length - 2; i >= 0; i--) {
            /**
             * 当前元素nums[i]和前一个元素相同，不需要重复计算
             */
            if (nums[i] == nums[i + 1]) {
                if (prevQualified) {
                    result++;
                }
            } else {
                /**
                 * 子数组nums[i+1……length-1]中的所有元素都大于nums[i]，如果这部分元素的个数不少于k个，则nums[i]是合格元素，否则不是
                 */
                if (nums.length - (i + 1) >= k) {
                    prevQualified = true;
                    result++;
                } else {
                    prevQualified = false;
                }
            }
        }
        return result;
    }
}
