package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: 3489. Zero Array Transformation IV
 *
 * @author baltan
 * @date 2025/4/6 11:35
 */
public class MinZeroArray11 {
    public static void main(String[] args) {
        System.out.println(minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));
        System.out.println(minZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3, 2}, {0, 2, 1}}));
        System.out.println(minZeroArray(new int[]{1, 2, 3, 2, 1}, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 4, 1}}));
        System.out.println(minZeroArray(new int[]{1, 2, 3, 2, 6}, new int[][]{{0, 1, 1}, {0, 2, 1}, {1, 4, 2}, {4, 4, 4}, {3, 4, 1}, {4, 4, 5}}));
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int length = nums.length;
        /**
         * leftCount表示数组nums中剩余还未变成0的元素的个数
         */
        int leftCount = length;
        /**
         * isZero[i]表示元素nums[i]是否已变成0
         */
        boolean[] isZero = new boolean[length];
        /**
         * sumSets[i]表示经过若干次查询后，元素nums[i]可能被减去的值的集合
         */
        Set<Integer>[] sumSets = new HashSet[length];

        for (int i = 0; i < length; i++) {
            /**
             * 如果nums[i]的初始值就是0，则不需要进行操作，直接跳过
             */
            if (nums[i] == 0) {
                isZero[i] = true;
                leftCount--;
            } else {
                sumSets[i] = new HashSet<>();
                /**
                 * 当元素nums[i]不进行任何操作时，相当于可以被减去0
                 */
                sumSets[i].add(0);
            }
        }
        /**
         * 初始状态下，数组nums本身就是个零数组，不需要进行任何操作，直接返回
         */
        if (leftCount == 0) {
            return 0;
        }

        for (int i = 0; i < queries.length; i++) {
            loop:
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (isZero[j]) {
                    continue;
                }
                /**
                 * 保存当前查询执行结束后，元素nums[j]可能被减去的值的集合
                 */
                List<Integer> sums = new ArrayList<>();

                for (int sum : sumSets[j]) {
                    /**
                     * 元素nums[j]此前可以被减去sum，在此基础上再被减去queries[i][2]
                     */
                    int newSum = sum + queries[i][2];

                    if (newSum == nums[j]) {
                        isZero[j] = true;
                        leftCount--;
                        /**
                         * 数组nums此时已是零数组，此时已经执行了前i+1次操作，返回结果
                         */
                        if (leftCount == 0) {
                            return i + 1;
                        }
                        continue loop;
                        /**
                         * 根据题意，nums[j]∈[1,1000]，所以当被减去的值超过1000时，就不需要再考虑
                         */
                    } else if (newSum <= 1000) {
                        sums.add(newSum);
                    }
                }
                sumSets[j].addAll(sums);
            }
        }
        return -1;
    }
}
