package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2653. Sliding Subarray Beauty
 *
 * @author Baltan
 * @date 2023/4/24 16:26
 */
public class GetSubarrayBeauty {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2));
        OutputUtils.print1DIntegerArray(getSubarrayBeauty(new int[]{-1, -2, -3, -4, -5}, 2, 2));
        OutputUtils.print1DIntegerArray(getSubarrayBeauty(new int[]{-3, 1, 2, -3, 0, -3}, 2, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/sliding-subarray-beauty/solutions/2241294/hua-dong-chuang-kou-bao-li-mei-ju-by-end-9mvl/"></a>
     *
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        /**
         * counts[0]-counts[100]依次代表子数组中数字-50-50的个数（重点：数组nums中的数字∈[-50,50]，范围很小）
         */
        int[] counts = new int[101];
        /**
         * 先对第一个子数组中的前k-1个数字计数
         */
        for (int i = 0; i < k - 1; i++) {
            counts[nums[i] + 50]++;
        }
        /**
         * 通过移动大小为k的窗口计算每个子数组中的美丽值
         */
        for (int i = 0; i < result.length; i++) {
            /**
             * 窗口中增加最后一个数字
             */
            counts[nums[i + k - 1] + 50]++;
            result[i] = findOrderX(counts, x);
            /**
             * 窗口中移除第一个数字
             */
            counts[nums[i] + 50]--;
        }
        return result;
    }

    /**
     * 找到子数组中第x小的数字
     *
     * @param counts
     * @param x
     * @return
     */
    public static int findOrderX(int[] counts, int x) {
        /**
         * 子数组中第x小的数字
         */
        int result = 0;
        int total = 0;
        /**
         * 从小到大累加子数组中数字的个数
         */
        for (int i = 0; i < counts.length; i++) {
            total += counts[i];

            if (total >= x) {
                result = i - 50;
                break;
            }
        }
        /**
         * 如果子数组中第x小的数字不为负数，则返回0
         */
        return Math.min(result, 0);
    }
}
