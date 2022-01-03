package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2122. Recover the Original Array
 *
 * @author Baltan
 * @date 2021/12/31 09:40
 */
public class RecoverArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(recoverArray(new int[]{2, 10, 6, 4, 8, 12}));
        OutputUtils.print1DIntegerArray(recoverArray(new int[]{1, 1, 3, 3}));
        OutputUtils.print1DIntegerArray(recoverArray(new int[]{5, 435}));
    }

    public static int[] recoverArray(int[] nums) {
        int length = nums.length / 2;
        int[] result = new int[length];
        Arrays.sort(nums);
        /**
         * 因为k大于0，将数组lower和higher都按照升序排列后nums中的最小值nums[0]必然是lower[0]，遍历nums中剩下的数一次作为
         * higher[0]由lower[0]和higher[0]可以计算得到k，再继续判断nums中剩下的数是否符合要求
         */
        for (int i = 1; i < nums.length; i++) {
            /**
             * 因为k大于0，所以lower[0]和higher[0]不相等，且由题意lower[0]和higher[0]有相同的奇偶性
             */
            if (nums[i] == nums[0] || (nums[i] + nums[0]) % 2 != 0) {
                continue;
            }
            /**
             * 当前lower中的数在nums中的索引位置
             */
            int loIndex = 0;
            /**
             * 当前higher中的数在nums中的索引位置
             */
            int hiIndex = i;
            int resultIndex = 0;
            /**
             * isVisited[i]表示nums[i]是否已被使用过
             */
            boolean[] isVisited = new boolean[nums.length];
            int k = (nums[i] - nums[0]) / 2;
            isVisited[loIndex++] = true;
            isVisited[hiIndex++] = true;
            result[resultIndex++] = nums[0] + k;
            /**
             * 尝试查找result中剩下的数
             */
            while (resultIndex < length) {
                /**
                 * lower中下一个数在nums中的索引位置
                 */
                loIndex = findLoIndex(nums, isVisited, loIndex);

                if (loIndex == -1) {
                    break;
                }
                /**
                 * 确定lower中下一个数后，可以得到higher中下一个对应的数
                 */
                int hi = nums[loIndex] + 2 * k;
                /**
                 * higher中下一个数hi在nums中的索引位置
                 */
                hiIndex = findHiIndex(nums, isVisited, hiIndex, hi);

                if (hiIndex == -1) {
                    break;
                }

                result[resultIndex++] = nums[loIndex] + k;
                isVisited[loIndex++] = true;
                isVisited[hiIndex++] = true;
            }
            /**
             * 如果已找到一组满足条件的result，直接返回
             */
            if (resultIndex == length) {
                return result;
            }
        }
        return result;
    }

    /**
     * 查找数组higher下一个数的索引位置，如果没有满足条件的数，则返回-1
     *
     * @param nums
     * @param isVisited
     * @param hiIndex
     * @param hi
     * @return
     */
    public static int findHiIndex(int[] nums, boolean[] isVisited, int hiIndex, int hi) {
        while (hiIndex < nums.length) {
            if (!isVisited[hiIndex] && nums[hiIndex] == hi) {
                return hiIndex;
            } else {
                hiIndex++;
            }
        }
        return -1;
    }

    /**
     * 查找数组lower下一个数的索引位置，如果没有满足条件的数，则返回-1
     *
     * @param nums
     * @param isVisited
     * @param loIndex
     * @return
     */
    public static int findLoIndex(int[] nums, boolean[] isVisited, int loIndex) {
        while (loIndex < nums.length) {
            if (!isVisited[loIndex]) {
                return loIndex;
            } else {
                loIndex++;
            }
        }
        return -1;
    }
}
