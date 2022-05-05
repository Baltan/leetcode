package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Description: 1878. Get Biggest Three Rhombus Sums in a Grid
 *
 * @author Baltan
 * @date 2022/5/4 15:46
 */
public class GetBiggestThree {
    public static void main(String[] args) {
        int[][] grid1 =
                {{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}};
        OutputUtils.print1DIntegerArray(getBiggestThree(grid1));

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print1DIntegerArray(getBiggestThree(grid2));

        int[][] grid3 = {{7, 7, 7}};
        OutputUtils.print1DIntegerArray(getBiggestThree(grid3));
    }

    public static int[] getBiggestThree(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 去重倒序保存所有可能的菱形和
         */
        Set<Integer> sums = new TreeSet<>((x, y) -> y - x);
        /**
         * leftBottomPrefixSums[i][j][k+1]表示以grid[i][j]为起点向左下方移动k格的前缀和
         */
        int[][][] leftBottomPrefixSums = new int[rows][cols][];
        /**
         * rightBottomPrefixSums[i][j][k+1]表示以grid[i][j]为起点向右下方移动k格的前缀和
         */
        int[][][] rightBottomPrefixSums = new int[rows][cols][];
        /**
         * 计算左下方向和右下方向的前缀和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 以grid[i][j]为起点，可以向左下方移动的最大步数（向下的方向可以移动到行索引为rows-1的最后一行，向左的方向可
                 * 以移动到列索引为0的第一列），两者取较小值
                 */
                int leftBottomMaxStep = Math.min(rows - i - 1, j);
                /**
                 * 至少移动0步，至多移动leftBottomMaxStep步，共leftBottomMaxStep+1种可能
                 */
                int[] leftBottomPrefixSum = new int[leftBottomMaxStep + 2];
                leftBottomPrefixSums[i][j] = leftBottomPrefixSum;

                for (int k = 0; k <= leftBottomMaxStep; k++) {
                    /**
                     * 向左下方移动k步后，到达grid[i+k][j-k]
                     */
                    leftBottomPrefixSum[k + 1] = leftBottomPrefixSum[k] + grid[i + k][j - k];
                }
                /**
                 * 以grid[i][j]为起点，可以向右下方移动的最大步数（向下的方向可以移动到行索引为rows-1的最后一行，向右的方向可
                 * 以移动到列索引为cols-1的最后一列），两者取较小值
                 */
                int rightBottomMaxStep = Math.min(rows - i - 1, cols - j - 1);
                /**
                 * 至少移动0步，至多移动rightBottomMaxStep步，共rightBottomMaxStep+1种可能
                 */
                int[] rightBottomPrefixSum = new int[rightBottomMaxStep + 2];
                rightBottomPrefixSums[i][j] = rightBottomPrefixSum;

                for (int k = 0; k <= rightBottomMaxStep; k++) {
                    /**
                     * 向右下方移动k步后，到达grid[i+k][j+k]
                     */
                    rightBottomPrefixSum[k + 1] = rightBottomPrefixSum[k] + grid[i + k][j + k];
                }
            }
        }
        /**
         * 以grid[i][j]为上顶点，计算所有可能的菱形和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 最大移动步数（向左的方向可以移动到列索引为0的第一列，向右的方向可以移动到列索引为cols-1的最后一列，向下的方
                 * 向可以移动到行索引为rows-1的最后一行但是要折半），三者取较小值
                 */
                int maxStep = Math.min(Math.min(j, cols - j - 1), (rows - i - 1) / 2);

                for (int k = 0; k <= maxStep; k++) {
                    if (k == 0) {
                        sums.add(grid[i][j]);
                    } else {
                        int sum = 0;
                        /**
                         * 以grid[i][j]为上顶点向左下方元素的和，到达grid[i+k][j-k]
                         */
                        sum += leftBottomPrefixSums[i][j][k + 1];
                        /**
                         * 以grid[i][j]为上顶点向右下方元素的和，到达grid[i+k][j+k]
                         */
                        sum += rightBottomPrefixSums[i][j][k + 1];
                        /**
                         * 以grid[i+k][j-k]为左顶点向右下方元素的和，到达grid[i+2k][j]
                         */
                        sum += rightBottomPrefixSums[i + k][j - k][k + 1];
                        /**
                         * 以grid[i+k][j+k]为右顶点向左下方元素的和，到达grid[i+2k][j]
                         */
                        sum += leftBottomPrefixSums[i + k][j + k][k + 1];
                        /**
                         * 四个顶点的元素各被算了两次，减去重复值
                         */
                        sum -= (grid[i][j] + grid[i + k][j - k] + grid[i + k][j + k] + grid[i + 2 * k][j]);
                        sums.add(sum);
                    }
                }
            }
        }

        if (sums.size() <= 3) {
            return sums.stream().mapToInt(x -> x).toArray();
        } else {
            return sums.stream().limit(3).mapToInt(x -> x).toArray();
        }
    }
}
