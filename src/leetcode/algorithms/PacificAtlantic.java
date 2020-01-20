package leetcode.algorithms;

import java.awt.Point;
import java.util.*;
import java.util.List;

/**
 * Description: 417. Pacific Atlantic Water Flow
 *
 * @author Baltan
 * @date 2020-01-19 12:29
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] matrix1 =
                {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(matrix1));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 如果matrix只有一行，则所有坐标都是既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标
         */
        if (rows == 1) {
            for (int i = 0; i < cols; i++) {
                result.add(Arrays.asList(0, i));
            }
            return result;
        }
        /**
         * 如果matrix只有一列，则所有坐标都是既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标
         */
        if (cols == 1) {
            for (int i = 0; i < rows; i++) {
                result.add(Arrays.asList(i, 0));
            }
            return result;
        }
        /**
         * 流进太平洋的水流可能经过的坐标
         */
        Set<Point> pacificOceanSet = new HashSet<>();
        /**
         * 流进大西洋的水流可能经过的坐标
         */
        Set<Point> atlanticOceanSet = new HashSet<>();
        /**
         * 和太平洋相连的坐标，即matrix的第一行和第一列的所有坐标
         */
        List<Point> pacificOceanList = new LinkedList<>();
        /**
         * 和大西洋相连的坐标，即matrix的第一行和第一列的所有坐标
         */
        List<Point> atlanticOceanList = new LinkedList<>();

        for (int i = 0; i < cols; i++) {
            Point p1 = new Point(0, i);
            Point p2 = new Point(rows - 1, i);
            pacificOceanSet.add(p1);
            atlanticOceanSet.add(p2);
            pacificOceanList.add(p1);
            atlanticOceanList.add(p2);
        }

        for (int i = 0; i < rows; i++) {
            Point p1 = new Point(i, 0);
            Point p2 = new Point(i, cols - 1);
            pacificOceanSet.add(p1);
            atlanticOceanSet.add(p2);
            pacificOceanList.add(p1);
            atlanticOceanList.add(p2);
        }

        for (Point point : pacificOceanList) {
            dfs(pacificOceanSet, matrix, point.x, point.y);
        }

        for (Point point : atlanticOceanList) {
            dfs(atlanticOceanSet, matrix, point.x, point.y);
        }
        /**
         * 对于matrix的每个坐标，如果既会被流进太平洋的水流经过，也会被流进太平洋的水流经过，则这个坐
         * 标就是水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Point p = new Point(i, j);

                if (pacificOceanSet.contains(p) && atlanticOceanSet.contains(p)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    /**
     * 深度优先搜索流进某一个大洋的水流可能经过的坐标，将坐标加入oceanSet中。以坐标[row,col]为中心进
     * 行判断，如果[row-1,col]、[row+1,col]、[row,col-1]、[row,col+1]的高度高于[row,col]的高度，
     * 就将这四个坐标加入oceanSet中
     *
     * @param oceanSet
     * @param matrix
     * @param row
     * @param col
     */
    public static void dfs(Set<Point> oceanSet, int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row - 1 >= 0 && matrix[row - 1][col] >= matrix[row][col] &&
                !oceanSet.contains(new Point(row - 1, col))) {
            oceanSet.add(new Point(row - 1, col));
            dfs(oceanSet, matrix, row - 1, col);
        }

        if (row + 1 < rows && matrix[row + 1][col] >= matrix[row][col] &&
                !oceanSet.contains(new Point(row + 1, col))) {
            oceanSet.add(new Point(row + 1, col));
            dfs(oceanSet, matrix, row + 1, col);
        }

        if (col - 1 >= 0 && matrix[row][col - 1] >= matrix[row][col] &&
                !oceanSet.contains(new Point(row, col - 1))) {
            oceanSet.add(new Point(row, col - 1));
            dfs(oceanSet, matrix, row, col - 1);
        }

        if (col + 1 < cols && matrix[row][col + 1] >= matrix[row][col] &&
                !oceanSet.contains(new Point(row, col + 1))) {
            oceanSet.add(new Point(row, col + 1));
            dfs(oceanSet, matrix, row, col + 1);
        }
    }
}
