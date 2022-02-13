package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2161. Partition Array According to Given Pivot
 *
 * @author Baltan
 * @date 2022/2/13 13:05
 */
public class PivotArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10));
        OutputUtils.print1DIntegerArray(pivotArray(new int[]{-3, 4, 3, 2}, 2));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        int[] result = new int[length];
        int lo = 0;
        int hi = length - 1;
        int leftIndex = 0;
        int rightIndex = length - 1;
        /**
         * 从左向右遍历nums，将所有小于pivot按照出现的顺序放在result的最左边
         */
        while (lo < length) {
            if (nums[lo] < pivot) {
                result[leftIndex++] = nums[lo];
            }
            lo++;
        }
        /**
         * 从右向左遍历nums，将所有大于pivot按照出现的顺序放在result的最右边
         */
        while (hi >= 0) {
            if (nums[hi] > pivot) {
                result[rightIndex--] = nums[hi];
            }
            hi--;
        }
        /**
         * result剩余中间的空位用pivot填充
         */
        for (int i = leftIndex; i <= rightIndex; i++) {
            result[i] = pivot;
        }
        return result;
    }
}
