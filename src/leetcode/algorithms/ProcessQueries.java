package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1409. Queries on a Permutation With Key
 *
 * @author Baltan
 * @date 2020-04-14 18:34
 */
public class ProcessQueries {
    public static void main(String[] args) {
        int[] queries1 = {3, 1, 2, 1};
        OutputUtils.print1DIntegerArray(processQueries(queries1, 5));

        int[] queries2 = {4, 1, 2, 2};
        OutputUtils.print1DIntegerArray(processQueries(queries2, 4));

        int[] queries3 = {7, 5, 5, 8, 3};
        OutputUtils.print1DIntegerArray(processQueries(queries3, 8));
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] permutation = new int[m];

        for (int i = 0; i < m; i++) {
            permutation[i] = i + 1;
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * 当前待查数字
             */
            int value = queries[i];

            for (int j = 0; j < m; j++) {
                /**
                 * 找到当前待查数字value在permutation中的索引位置j
                 */
                if (permutation[j] == value) {
                    /**
                     * 将索引位置在j之前的数字都向后移动一个位置
                     */
                    for (int k = j - 1; k >= 0; k--) {
                        permutation[k + 1] = permutation[k];
                    }
                    /**
                     * 将待查数字放到列表的第0个位置
                     */
                    permutation[0] = value;
                    /**
                     * 保存待查数字value的查询结果
                     */
                    queries[i] = j;
                }
            }
        }
        return queries;
    }
}
