package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.TreeMap;

/**
 * Description: 3567. Minimum Absolute Difference in Sliding Submatrix
 *
 * @author baltan
 * @date 2025/6/16 11:28
 */
public class MinAbsDiff {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(minAbsDiff(new int[][]{{20195, 15337, 73189, 16963, -90840}, {10664, -43796, -61984, 13235, -33619}}, 2));
        System.out.println("------------------------------------------");
        OutputUtils.print2DIntegerArray(minAbsDiff(new int[][]{{1, -2, 3}, {2, 3, 5}}, 2));
        System.out.println("------------------------------------------");
        OutputUtils.print2DIntegerArray(minAbsDiff(new int[][]{{1, 8}, {3, -2}}, 2));
        System.out.println("------------------------------------------");
        OutputUtils.print2DIntegerArray(minAbsDiff(new int[][]{{3, -1}}, 1));
    }

    public static int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows - k + 1][cols - k + 1];

        for (int i = 0; i <= rows - k; i++) {
            /**
             * 当前k阶矩阵中不同元素各自出现的次数
             */
            TreeMap<Integer, Integer> countMap = new TreeMap<>();
            /**
             * 计算以grid[i][0]作为左上角的k阶矩阵中不同元素各自出现的次数
             */
            for (int j = i; j < i + k; j++) {
                for (int l = 0; l < k; l++) {
                    countMap.merge(grid[j][l], 1, Integer::sum);
                }
            }
            result[i][0] = getMinDifference(countMap);
            /**
             * 依次计算以grid[i][1]-grid[i][cols-k]作为左上角的k阶矩阵中不同元素各自出现的次数
             */
            for (int l = k; l < cols; l++) {
                /**
                 * 当前k阶矩阵需要删除前一个k阶矩阵中的元素grid[j][l-k]，新增元素grid[j][l]
                 */
                for (int j = i; j < i + k; j++) {
                    countMap.merge(grid[j][l - k], -1, Integer::sum);
                    countMap.merge(grid[j][l], 1, Integer::sum);
                    /**
                     * 将当前k阶矩阵中不存在的数字的计数删除
                     */
                    if (countMap.get(grid[j][l - k]) == 0) {
                        countMap.remove(grid[j][l - k]);
                    }
                }
                result[i][l - k + 1] = getMinDifference(countMap);
            }
        }
        return result;
    }

    /**
     * 计算countMap中相邻两个key之差的最小值
     *
     * @param countMap
     * @return
     */
    public static int getMinDifference(TreeMap<Integer, Integer> countMap) {
        int minDifference = Integer.MAX_VALUE;
        int currKey = countMap.firstKey();
        Integer nextKey;

        while ((nextKey = countMap.higherKey(currKey)) != null) {
            minDifference = Math.min(minDifference, nextKey - currKey);
            currKey = nextKey;
        }
        return minDifference == Integer.MAX_VALUE ? 0 : minDifference;
    }
}