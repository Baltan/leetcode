package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1053. Previous Permutation With One Swap
 *
 * @author Baltan
 * @date 2020-03-02 12:37
 */
public class PrevPermOpt1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(prevPermOpt1(new int[]{3, 2, 1}));
        OutputUtils.print1DIntegerArray(prevPermOpt1(new int[]{1, 1, 5}));
        OutputUtils.print1DIntegerArray(prevPermOpt1(new int[]{1, 9, 4, 6, 7}));
        OutputUtils.print1DIntegerArray(prevPermOpt1(new int[]{3, 1, 1, 3}));
    }

    public static int[] prevPermOpt1(int[] A) {
        int length = A.length;
        /**
         * min为数组A中某个数之后的所有数中的最小值
         */
        int min = A[length - 1];
        /**
         * map保存数组A中某个数之后的所有数字的索引位置
         */
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        map.putIfAbsent(min, new Stack<>());
        map.get(min).push(length - 1);

        for (int i = length - 2; i >= 0; i--) {
            /**
             * 如果在A[i+1]、A[i+2]……A[length-1]中存在比A[i]小的数，在这些数找到小于A[i]的
             * 最大值，将最早出现的最大值和A[i]交换即可
             */
            if (A[i] > min) {
                /**
                 * A[i+1]、A[i+2]……A[length-1]中小于A[i]的最大值
                 */
                int maxLessThanCurrentNum = Integer.MIN_VALUE;

                for (int num : map.keySet()) {
                    if (num < A[i]) {
                        maxLessThanCurrentNum = Math.max(maxLessThanCurrentNum, num);
                    }
                }
                /**
                 * A[i]之后最早出现的maxLessThanCurrentNum值的索引位置
                 */
                int index = map.get(maxLessThanCurrentNum).pop();
                /**
                 * 将A[i]和A[index]交换即可
                 */
                int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
                return A;
            } else {
                min = Math.min(min, A[i]);
                map.putIfAbsent(min, new Stack<>());
                map.get(min).push(i);
            }
        }
        return A;
    }
}
