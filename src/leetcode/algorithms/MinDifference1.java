package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1906. Minimum Absolute Difference Queries
 *
 * @author Baltan
 * @date 2022/3/11 22:37
 */
public class MinDifference1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {2, 3}, {0, 3}};
        OutputUtils.print1DIntegerArray(minDifference(nums1, queries1));

        int[] nums2 = {4, 5, 2, 2, 7, 10};
        int[][] queries2 = {{2, 3}, {0, 2}, {0, 5}, {3, 5}};
        OutputUtils.print1DIntegerArray(minDifference(nums2, queries2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-queries/solution/cha-xun-chai-jue-dui-zhi-de-zui-xiao-zhi-fjjq/"></a>
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int[] minDifference(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        int length = nums.length;
        /**
         * 根据题意，数组nums中的元素在[1,100]之间
         */
        int max = 100;
        /**
         * prefixCount[i][j]表示nums[0]、nums[1]、……、nums[i-1]这些元素中j出现过的次数
         */
        int[][] prefixCount = new int[length + 1][max + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        /**
         * 统计数组nums的每个前缀数组中[1,100]各自出现的次数
         */
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= max; j++) {
                prefixCount[i][j] = nums[i - 1] == j ? prefixCount[i - 1][j] + 1 : prefixCount[i - 1][j];
            }
        }

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int pre = 0;
            /**
             * 从[1,100]逐一升序判断某个数是否在数组nums的子数组nums[start]、nums[start+1]、……、nums[end]中出现过，如果
             * 某个数i出现过，则这个数和之前出现过的最大的数字pre之差的绝对值可能就是" 差绝对值的最小值"
             */
            for (int i = 1; i <= max; i++) {
                if (prefixCount[end + 1][i] - prefixCount[start][i] > 0) {
                    /**
                     * 如果i不是子数组中出现过的最小的数字，才能和更前面的数字相减计算
                     */
                    if (pre != 0) {
                        result[index] = Math.min(result[index], i - pre);
                    }
                    pre = i;
                }

            }
            /**
             * 如果某个子数组的"差绝对值的最小值"仍旧是初始化时的Integer.MAX_VALUE，说明这个子数组中所有元素都相同，记结果为
             * -1
             */
            if (result[index] == Integer.MAX_VALUE) {
                result[index] = -1;
            }
            index++;
        }
        return result;
    }
}
