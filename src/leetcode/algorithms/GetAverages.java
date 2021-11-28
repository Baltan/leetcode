package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2090. K Radius Subarray Averages
 *
 * @author Baltan
 * @date 2021/11/28 13:51
 */
public class GetAverages {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
        OutputUtils.print1DIntegerArray(getAverages(new int[]{100000}, 0));
        OutputUtils.print1DIntegerArray(getAverages(new int[]{8}, 100000));
    }

    public static int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * 半径为k的子数组的元素个数
         */
        int diameter = k * 2 + 1;
        /**
         * 如果nums中的元素个数不足diameter个，则nums中不存在半径为k的子数组
         */
        if (length < diameter) {
            Arrays.fill(result, -1);
            return result;
        }
        /**
         * 半径为k的子数组的中心的最小索引位置
         */
        int min = k;
        /**
         * 半径为k的子数组的中心的最大索引位置
         */
        int max = length - k - 1;
        long sum = 0L;
        /**
         * 先计算从左至右的第一个半径为k的子数组的所有元素的和（不包括最后一个元素，即索引位置为nums[diameter-1]的元素）
         */
        for (int i = 0; i < diameter - 1; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < length; i++) {
            /**
             * 如果中心的索引位置在[min,max]之外，则无法构成半径为k的子数组
             */
            if (i < min || i > max) {
                result[i] = -1;
            } else {
                /**
                 * 加上当前半径为k的子数组的最后一个元素
                 */
                sum += nums[i + k];
                /**
                 * 减去前一个半径为k的子数组的第一个元素
                 */
                if (i - k > 0) {
                    sum -= nums[i - k - 1];
                }
                result[i] = (int) (sum / diameter);
            }
        }
        return result;
    }
}
