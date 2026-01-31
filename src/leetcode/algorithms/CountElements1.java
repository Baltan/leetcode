package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3759. Count Elements With at Least K Greater Values
 *
 * @author baltan
 * @date 2026/1/27 15:29
 */
public class CountElements1 {
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
         * 遍历数组nums过程中当前元素num的前一个元素
         */
        int prev = -1;
        /**
         * 当前元素num的前一个元素是否是合格元素
         */
        boolean prevQualified = false;
        Arrays.sort(nums);

        for (int num : nums) {
            /**
             * 当前元素num和前一个元素相同，不需要重复计算
             */
            if (num == prev) {
                if (prevQualified) {
                    result++;
                }
            } else {
                int lo = 0;
                int hi = nums.length - 1;
                /**
                 * 二分查找数组nums中的第一个严格大于num的元素的索引值
                 */
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (nums[mid] <= num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                if (nums[lo] > num && nums.length - lo >= k) {
                    prevQualified = true;
                    result++;
                } else {
                    prevQualified = false;
                }
                prev = num;
            }
        }
        return result;
    }
}
