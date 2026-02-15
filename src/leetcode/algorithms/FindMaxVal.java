package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3796. Find Maximum Value in a Constrained Sequence
 *
 * @author baltan
 * @date 2026/2/12 14:10
 */
public class FindMaxVal {
    public static void main(String[] args) {
        System.out.println(findMaxVal(10, new int[][]{{3, 1}, {8, 1}}, new int[]{2, 2, 3, 1, 4, 5, 1, 1, 2}));
        System.out.println(findMaxVal(8, new int[][]{{3, 2}}, new int[]{3, 5, 2, 4, 2, 3, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-maximum-value-in-a-constrained-sequence/solutions/3872153/liang-ci-sao-miao-fa-pythonjavacgo-by-en-p7qc/"></a>
     *
     * @param n
     * @param restrictions
     * @param diff
     * @return
     */
    public static int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int result = 0;
        /**
         * upperLimits[i]表示序列中元素a[i]可能的最大值
         */
        int[] upperLimits = new int[n];
        /**
         * restrictionNums[i]表示序列中a[i]的上限约束
         */
        int[] restrictionNums = new int[n];
        Arrays.fill(restrictionNums, Integer.MAX_VALUE);

        for (int[] restriction : restrictions) {
            restrictionNums[restriction[0]] = restriction[1];
        }
        /**
         * 从左向右计算a[i]可能的最大值
         */
        for (int i = 1; i < n; i++) {
            /**
             * upperLimits[i]-upperLimits[i-1]<=diff[i-1]，并且upperLimits[i]<=restrictionNums[i]
             */
            upperLimits[i] = Math.min(upperLimits[i - 1] + diff[i - 1], restrictionNums[i]);
        }
        /**
         * 从左向右遍历计算的过程中，如果某个upperLimits[i]突然被restrictionNums[i]限制得很小，可能导致此时的upperLimits[i-1]和
         * upperLimits[i]之差不再满足diff约束，需要从右向左再次遍历，修正这一约束
         */
        for (int i = n - 2; i > 0; i--) {
            /**
             * upperLimits[i]-upperLimits[i+1]<=diff[i]
             */
            upperLimits[i] = Math.min(upperLimits[i], upperLimits[i + 1] + diff[i]);
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, upperLimits[i]);
        }
        return result;
    }
}
