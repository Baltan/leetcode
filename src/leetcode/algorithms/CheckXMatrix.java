package leetcode.algorithms;

/**
 * Description: 2319. Check if Matrix Is X-Matrix
 *
 * @author Baltan
 * @date 2023/2/16 09:29
 */
public class CheckXMatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        System.out.println(checkXMatrix(grid1));

        int[][] grid2 = {{5, 7, 0}, {0, 3, 1}, {0, 5, 0}};
        System.out.println(checkXMatrix(grid2));
    }

    public static boolean checkXMatrix(int[][] grid) {
        int length = grid.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 主对角线上的元素为0
                 */
                if (i == j && grid[i][j] == 0) {
                    return false;
                }
                /**
                 * 副对角线上的元素为0
                 */
                if (i + j + 1 == length && grid[i][j] == 0) {
                    return false;
                }
                /**
                 * 非对角线上的元素不为0
                 */
                if (i != j && i + j + 1 != length && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
