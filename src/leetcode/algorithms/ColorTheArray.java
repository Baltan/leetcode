package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2672. Number of Adjacent Elements With the Same Color
 *
 * @author Baltan
 * @date 2023/5/7 18:43
 */
public class ColorTheArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(colorTheArray(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}}));
        OutputUtils.print1DIntegerArray(colorTheArray(1, new int[][]{{0, 100000}}));
    }

    public static int[] colorTheArray(int n, int[][] queries) {
        int[] result = new int[queries.length];
        /**
         * 数组nums记录所有元素的颜色状态
         */
        int[] nums = new int[n];
        /**
         * isAdjacent[i]表示元素nums[i]和nums[i+1]是否为同色相邻元素
         */
        boolean[] isAdjacent = new boolean[n - 1];
        /**
         * 第一次上色后，数组nums中只有这一个元素被上色，肯定不存在同色相邻元素
         */
        nums[queries[0][0]] = queries[0][1];

        for (int i = 1; i < queries.length; i++) {
            /**
             * 当前上色元素的索引
             */
            int index = queries[i][0];
            /**
             * 当前上色元素上色后的颜色
             */
            int color = queries[i][1];
            /**
             * 当前上色元素左边元素的索引
             */
            int left = index - 1;
            /**
             * 当前上色元素右边元素的索引
             */
            int right = index + 1;
            result[i] = result[i - 1];

            if (left >= 0) {
                if (!isAdjacent[left] && nums[left] == color) {
                    /**
                     * 元素nums[left]和nums[index]原本不为同色相邻元素，上色后成为了同色相邻元素
                     */
                    result[i]++;
                    isAdjacent[left] = true;
                } else if (isAdjacent[left] && nums[left] != color) {
                    /**
                     * 元素nums[left]和nums[index]原本是同色相邻元素，上色后不是同色相邻元素
                     */
                    result[i]--;
                    isAdjacent[left] = false;
                }
            }

            if (right < n) {
                if (!isAdjacent[index] && nums[right] == color) {
                    /**
                     * 元素nums[index]和nums[right]原本不为同色相邻元素，上色后成为了同色相邻元素
                     */
                    result[i]++;
                    isAdjacent[index] = true;
                } else if (isAdjacent[index] && nums[index] != color) {
                    /**
                     * 元素nums[index]和nums[right]原本是同色相邻元素，上色后不是同色相邻元素
                     */
                    result[i]--;
                    isAdjacent[index] = false;
                }
            }
            /**
             * 修改元素nums[index]上色后的颜色状态
             */
            nums[index] = color;
        }
        return result;
    }
}
