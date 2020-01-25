package leetcode.algorithms;

/**
 * Description: 1139. Largest 1-Bordered Square
 *
 * @author Baltan
 * @date 2020-01-25 12:59
 */
public class Largest1BorderedSquare {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(largest1BorderedSquare(grid1));

        int[][] grid2 = {{1, 1, 0, 0}};
        System.out.println(largest1BorderedSquare(grid2));

        int[][] grid3 = {{1, 1, 0}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(largest1BorderedSquare(grid3));
    }

    public static int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 可能的最大正方形的边长
         */
        int maxPossible = Math.min(rows, cols);
        /**
         * rowPrefixSum[i]表示二维网格第i行的前缀和
         */
        int[][] rowPrefixSum = new int[rows][cols + 1];
        /**
         * colPrefixSum[i]表示二维网格第i列的前缀和
         */
        int[][] colPrefixSum = new int[cols][rows + 1];

        for (int i = 0; i < rows; i++) {
            int[] prefixSum = new int[cols + 1];

            for (int j = 0; j < cols; j++) {
                prefixSum[j + 1] = prefixSum[j] + grid[i][j];
            }
            rowPrefixSum[i] = prefixSum;
        }

        for (int i = 0; i < cols; i++) {
            int[] prefixSum = new int[rows + 1];

            for (int j = 0; j < rows; j++) {
                prefixSum[j + 1] = prefixSum[j] + grid[j][i];
            }
            colPrefixSum[i] = prefixSum;
        }

        /**
         * 从最大可能的边长依次尝试查找是否有满足题目要求的正方形
         */
        for (int edgeLength = maxPossible; edgeLength >= 1; edgeLength--) {
            /**
             * 对于所有可能的左上顶点，判断边长为edgeLength的正方形是否边界全部由1组成
             */
            for (int leftTopX = 0; leftTopX <= rows - edgeLength; leftTopX++) {
                for (int leftTopY = 0; leftTopY <= cols - edgeLength; leftTopY++) {
                    /**
                     * 右下顶点的位置
                     */
                    int rightBottomX = leftTopX + edgeLength - 1;
                    int rightBottomY = leftTopY + edgeLength - 1;
                    /**
                     * 判断顶边是否全部由1组成
                     */
                    if (rowPrefixSum[leftTopX][rightBottomY + 1] - rowPrefixSum[leftTopX][leftTopY] !=
                            edgeLength) {
                        continue;
                    }
                    /**
                     * 判断底边是否全部由1组成
                     */
                    if (rowPrefixSum[rightBottomX][rightBottomY + 1] - rowPrefixSum[rightBottomX][leftTopY] !=
                            edgeLength) {
                        continue;
                    }
                    /**
                     * 判断左边是否全部由1组成
                     */
                    if (colPrefixSum[leftTopY][rightBottomX + 1] - colPrefixSum[leftTopY][leftTopX] !=
                            edgeLength) {
                        continue;
                    }
                    /**
                     * 判断右边是否全部由1组成
                     */
                    if (colPrefixSum[rightBottomY][rightBottomX + 1] - colPrefixSum[rightBottomY][leftTopX] !=
                            edgeLength) {
                        continue;
                    }
                    /**
                     * 如果顶边、底边、左边、右边全部由1组成，则已经找到了满足题目要求的最大正方形
                     */
                    return edgeLength * edgeLength;
                }
            }
        }
        return 0;
    }
}
