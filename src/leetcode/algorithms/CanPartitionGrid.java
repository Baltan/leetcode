package leetcode.algorithms;

/**
 * Description: 3546. Equal Sum Grid Partition I
 *
 * @author Baltan
 * @date 2025/5/31 22:32
 */
public class CanPartitionGrid {
    public static void main(String[] args) {
        System.out.println(canPartitionGrid(new int[][]{{1, 4}, {2, 3}}));
        System.out.println(canPartitionGrid(new int[][]{{1, 3}, {2, 4}}));
    }

    public static boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 矩阵grid中所有元素的和
         */
        long sum = 0L;
        /**
         * rowSums[i]表示矩阵grid中第i行所有元素的和
         */
        long[] rowSums = new long[rows];
        /**
         * colSums[i]表示矩阵grid中第i列所有元素的和
         */
        long[] colSums = new long[cols];
        /**
         * 矩阵grid分割后其中第一部分中所有元素的和
         */
        long sectionSum = 0L;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
        }
        /**
         * 逐行增加矩阵grid分割后第一部分中所有元素的和
         */
        for (long rowSum : rowSums) {
            sectionSum += rowSum;

            if (sectionSum << 1 == sum) {
                return true;
            } else if (sectionSum << 1 > sum) {
                break;
            }
        }
        sectionSum = 0L;
        /**
         * 逐列增加矩阵grid分割后第一部分中所有元素的和
         */
        for (long colSum : colSums) {
            sectionSum += colSum;

            if (sectionSum << 1 == sum) {
                return true;
            } else if (sectionSum << 1 > sum) {
                break;
            }
        }
        return false;
    }
}
