package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2509. Cycle Length Queries in a Tree
 *
 * @author Baltan
 * @date 2024/5/5 00:02
 */
public class CycleLengthQueries {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(cycleLengthQueries(3, new int[][]{{5, 3}, {4, 7}, {2, 3}}));
        OutputUtils.print1DIntegerArray(cycleLengthQueries(2, new int[][]{{1, 2}}));
    }

    public static int[] cycleLengthQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            /**
             * 先记录节点x和节点y之间连接的边
             */
            result[i] = 1;
            int x = queries[i][0];
            int y = queries[i][1];
            /**
             * 将节点x和节点y逐层向上查找，直到找到它们公共的祖先节点
             */
            while (x != y) {
                /**
                 * 当前哪一个节点深度更大，就将哪个节点向上一步；如果两个节点深度相等，就同时向上一步
                 */
                if (getLevel(y) < getLevel(x)) {
                    x >>= 1;
                    result[i]++;
                } else if (getLevel(y) > getLevel(x)) {
                    y >>= 1;
                    result[i]++;
                } else {
                    x >>= 1;
                    y >>= 1;
                    result[i] += 2;
                }
            }
        }
        return result;
    }

    /**
     * 计算节点在完全二叉树中的深度
     *
     * @param value
     * @return
     */
    public static int getLevel(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
    }
}
