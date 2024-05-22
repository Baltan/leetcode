package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3152. Special Array II
 *
 * @author Baltan
 * @date 2024/5/19 17:07
 * @see IsArraySpecial
 */
public class IsArraySpecial1 {
    public static void main(String[] args) {
        OutputUtils.print1DBooleanArray(isArraySpecial(new int[]{3, 6, 2, 1}, new int[][]{{0, 1}}));
        OutputUtils.print1DBooleanArray(isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}}));
        OutputUtils.print1DBooleanArray(isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}}));
        OutputUtils.print1DBooleanArray(isArraySpecial(new int[]{1}, new int[][]{{0, 0}}));
        OutputUtils.print1DBooleanArray(isArraySpecial(new int[]{1, 4}, new int[][]{{0, 1}}));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        /**
         * 保存所有相邻两数奇偶性相同的情况中，后一个数的索引值
         */
        List<Integer> indexes = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] & 1) == (nums[i] & 1)) {
                indexes.add(i);
            }
        }
        /**
         * 数组nums中任意两个相邻的元素奇偶性都不同
         */
        if (indexes.isEmpty()) {
            Arrays.fill(result, true);
            return result;
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * 长度为1的子数组也是特殊的
             */
            if (queries[i][0] == queries[i][1]) {
                result[i] = true;
                continue;
            }
            /**
             * 在queries[i]表示的子数组中二分查找是否存在相邻两数奇偶性相同的情况
             */
            int first = binarySearch(indexes, queries[i][0] + 1);
            /**
             * 如果存在相邻两数nums[k]和nums[k+1]，k∈[queries[i][0],queries[i][1])，k+1∈(queries[i][0],queries[i][1]]，且它
             * 们奇偶性相同，则子数组是非特殊的
             */
            result[i] = first == -1 || indexes.get(first) > queries[i][1];
        }
        return result;
    }

    /**
     * 在列表indexes中二分查找大于等于index的第一个元素，如果不存在则返回-1
     *
     * @param indexes
     * @param index
     * @return
     */
    public static int binarySearch(List<Integer> indexes, int index) {
        if (indexes.get(indexes.size() - 1) < index) {
            return -1;
        }
        int lo = 0;
        int hi = indexes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (indexes.get(mid) < index) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
