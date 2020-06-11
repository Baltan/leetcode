package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 15. 3Sum
 *
 * @author Baltan
 * @date 2018/8/29 10:03
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, 0, 0, 0, 0, 1, 1, 2, 2, -1, 3, 5, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        int length = nums.length;
        Arrays.sort(nums);
        /**
         * 如果数组排序后最小的三个数之和大于0或者最大的三个数之和小于0，则数组中一定不存在三个数的和为0
         */
        if (nums[0] + nums[1] + nums[2] > 0 || nums[length - 1] + nums[length - 2] + nums[length - 3] < 0) {
            return result;
        }

        for (int i = 0; i < length && nums[i] <= 0; i++) {
            /**
             * 先确定数组中的第一个数，并且第一个数不可重复
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            /**
             * 剩下两数之和
             */
            int sum = -nums[i];
            int lo = i + 1;
            int hi = length - 1;
            /**
             * 双指针确定剩下两个数
             */
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    result.add(list);
                    /**
                     * 第二个数不可重复
                     */
                    do {
                        lo++;
                    } while (nums[lo] == nums[lo - 1] && lo < hi);
                    /**
                     * 第三个数不可重复
                     */
                    do {
                        hi--;
                    } while (nums[hi] == nums[hi + 1] && lo < hi);
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}
