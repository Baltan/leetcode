package leetcode.algorithms;

/**
 * Description: 2428. Maximum Sum of an Hourglass
 *
 * @author Baltan
 * @date 2022/12/13 09:13
 */
public class MaxSum {
    public static void main(String[] args) {
        int[][] grid1 = {{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}};
        System.out.println(maxSum(grid1));

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(maxSum(grid2));
    }

    public static int maxSum(int[][] grid) {
        int result = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * rowPrefixSums表示grid水平方向上的前缀和
         */
        int[][] rowPrefixSums = new int[rows][cols + 1];
        /**
         * colPrefixSums表示grid垂直方向上的前缀和
         */
        int[][] colPrefixSums = new int[rows + 1][cols];
        /**
         * 计算grid水平方向和垂直方向上的前缀和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowPrefixSums[i][j + 1] = rowPrefixSums[i][j] + grid[i][j];
                colPrefixSums[i + 1][j] = colPrefixSums[i][j] + grid[i][j];
            }
        }
        /**
         * 遍历"沙漏"图形的左上角网格的坐标，计算每个沙漏中所有元素的最大值
         */
        for (int i = rows - 3; i >= 0; i--) {
            for (int j = cols - 3; j >= 0; j--) {
                /**
                 * 沙漏中所有元素之和为顶边所有网格元素之和+底边所有网格元素之和+垂直边所有网格元素之和-顶边和底边中间两个网格元素之和
                 */
                int sum = (rowPrefixSums[i][j + 3] - rowPrefixSums[i][j]) + (rowPrefixSums[i + 2][j + 3] - rowPrefixSums[i + 2][j]) + (colPrefixSums[i + 3][j + 1] - colPrefixSums[i][j + 1]) - (grid[i][j + 1] + grid[i + 2][j + 1]);
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
