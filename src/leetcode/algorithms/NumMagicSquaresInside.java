package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: Magic Squares In Grid
 *
 * @author Baltan
 * @date 2018/8/10 09:39
 */
public class NumMagicSquaresInside {
    public static void main(String[] args) {
        int[][] grid1 = {{4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}};
        System.out.println(numMagicSquaresInside(grid1));

        int[][] grid2 = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        System.out.println(numMagicSquaresInside(grid2));

        int[][] grid3 = {{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
        System.out.println(numMagicSquaresInside(grid3));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int num = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(i, j, grid)) {
                    num++;
                }
            }
        }
        return num;
    }

    public static boolean isMagicSquare(int rowIndex, int colIndex, int[][] grid) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> sumSet = new HashSet<>();
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            int rowSum = 0;
            for (int j = colIndex; j < colIndex + 3; j++) {
                if (!list.contains(grid[i][j])) {
                    return false;
                }
                rowSum += grid[i][j];
            }
            sumSet.add(rowSum);
        }
        for (int i = colIndex; i < colIndex + 3; i++) {
            int colSum = 0;
            for (int j = rowIndex; j < rowIndex + 3; j++) {
                colSum += grid[j][i];
            }
            sumSet.add(colSum);
        }
        sumSet.add(grid[rowIndex][colIndex] + grid[rowIndex + 1][colIndex + 1] + grid[rowIndex +
                2][colIndex + 2]);
        sumSet.add(grid[rowIndex][colIndex + 2] + grid[rowIndex + 1][colIndex + 1] +
                grid[rowIndex + 2][colIndex]);
        return sumSet.size() == 1;
    }
}
