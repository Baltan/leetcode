package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1718. Construct the Lexicographically Largest Valid Sequence
 *
 * @author Baltan
 * @date 2022/8/12 09:24
 */
public class ConstructDistancedSequence {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(constructDistancedSequence(3));
        OutputUtils.print1DIntegerArray(constructDistancedSequence(5));
    }

    /**
     * 是否已找到一组序列，在从左向右填充序列的过程中，总是尽可能先用较大的数字，所以一旦找到一个符合条件的序列，一定是字典顺序最
     * 大的
     */
    private static boolean flag;
    private static int[] result;

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/construct-the-lexicographically-largest-valid-sequence/solution/by-runningcarrot-5vv2/"></a>
     *
     * @param n
     * @return
     */
    public static int[] constructDistancedSequence(int n) {
        /**
         * 记录序列的中间状态
         */
        int[] arr = new int[2 * n - 1];
        /**
         * isUsed[i]表示i是否已被填入序列arr中
         */
        boolean[] isUsed = new boolean[n + 1];
        /**
         * 初始化标记还未找到符合条件的序列
         */
        flag = false;
        dfs(n, arr, isUsed, 0);
        return result;
    }

    public static void dfs(int n, int[] arr, boolean[] isUsed, int currIndex) {
        /**
         * 一旦找到一个符合条件的序列，就一定是字典顺序最大的，不再递归
         */
        if (flag) {
            return;
        }
        /**
         * 此时已把arr中所有元素都填满，说明已找到一个符合条件的序列
         */
        if (currIndex == arr.length) {
            flag = true;
            /**
             * 将当前序列的状态保存下来，否则arr最后在状态重置的过程中会变回初始时状态[0,0,0,……]
             */
            result = arr.clone();
            return;
        }
        /**
         * 序列arr当前位置已被填入数字，考虑下一个索引位置
         */
        if (arr[currIndex] != 0) {
            dfs(n, arr, isUsed, currIndex + 1);
            return;
        }
        /**
         * 从大到小遍历可以填的数字，优先填入较大的数字才能保证最终得到的序列字典顺序最大
         */
        for (int number = n; number >= 1; number--) {
            if (number != 1) {
                if (!isUsed[number] && currIndex + number < arr.length &&
                        arr[currIndex + number] == 0) {
                    arr[currIndex] = number;
                    arr[currIndex + number] = number;
                    isUsed[number] = true;
                    dfs(n, arr, isUsed, currIndex + 1);
                    /**
                     * 状态重置
                     */
                    isUsed[number] = false;
                    arr[currIndex + number] = 0;
                    arr[currIndex] = 0;
                }
            } else {
                if (!isUsed[1]) {
                    arr[currIndex] = 1;
                    isUsed[1] = true;
                    dfs(n, arr, isUsed, currIndex + 1);
                    /**
                     * 状态重置
                     */
                    isUsed[1] = false;
                    arr[currIndex] = 0;
                }
            }
        }
    }
}
