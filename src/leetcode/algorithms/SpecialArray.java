package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1608. Special Array With X Elements Greater Than or Equal X
 *
 * @author Baltan
 * @date 2022/10/5 12:18
 */
public class SpecialArray {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3, 5}));
        System.out.println(specialArray(new int[]{0, 0}));
        System.out.println(specialArray(new int[]{0, 4, 3, 0, 4}));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        /**
         * 特征值x可能的最小值
         */
        int minX = 1;
        /**
         * 特征值x可能的最大值
         */
        int maxX = nums[length - 1];
        /**
         * 二分查找特征值x
         */
        while (minX <= maxX) {
            int x = (minX + maxX) / 2;
            int lo = 0;
            int hi = length - 1;
            /**
             * 二分查找数组nums中第一个大于等于x的数字的索引位置
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (nums[mid] < x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            /**
             * 数组nums中大于等于x的数字的个数
             */
            int count = length - lo;

            if (count < x) {
                maxX = x - 1;
            } else if (count > x) {
                minX = x + 1;
            } else {
                return x;
            }
        }
        return -1;
    }
}
