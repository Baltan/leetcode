package leetcode.algorithms;

/**
 * Description: 3242. Design Neighbor Sum Service
 *
 * @author Baltan
 * @date 2024/8/11 14:40
 */
public class NeighborSum {
    int length;
    private int[][] grid;
    /**
     * xList[i]表示矩阵grid中数字i的横坐标
     */
    private int[] xList;
    /**
     * yList[i]表示矩阵grid中数字i的纵坐标
     */
    private int[] yList;

    public NeighborSum(int[][] grid) {
        this.length = grid.length;
        this.grid = grid;
        this.xList = new int[length * length];
        this.yList = new int[length * length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 数字grid[i][j]在矩阵grid中的坐标为(i,j)
                 */
                xList[grid[i][j]] = i;
                yList[grid[i][j]] = j;
            }
        }
    }

    public int adjacentSum(int value) {
        int sum = 0;
        int x = xList[value];
        int y = yList[value];
        sum += x - 1 >= 0 ? grid[x - 1][y] : 0;
        sum += x + 1 < length ? grid[x + 1][y] : 0;
        sum += y - 1 >= 0 ? grid[x][y - 1] : 0;
        sum += y + 1 < length ? grid[x][y + 1] : 0;
        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        int x = xList[value];
        int y = yList[value];
        sum += x - 1 >= 0 && y - 1 >= 0 ? grid[x - 1][y - 1] : 0;
        sum += x - 1 >= 0 && y + 1 < length ? grid[x - 1][y + 1] : 0;
        sum += x + 1 < length && y - 1 >= 0 ? grid[x + 1][y - 1] : 0;
        sum += x + 1 < length && y + 1 < length ? grid[x + 1][y + 1] : 0;
        return sum;
    }

    public static void main(String[] args) {
        NeighborSum neighborSum1 = new NeighborSum(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(neighborSum1.adjacentSum(1));
        System.out.println(neighborSum1.adjacentSum(4));
        System.out.println(neighborSum1.diagonalSum(4));
        System.out.println(neighborSum1.diagonalSum(8));

        System.out.println("-------------------------------");

        NeighborSum neighborSum2 = new NeighborSum(new int[][]{{1, 2, 0, 3}, {4, 7, 15, 6}, {8, 9, 10, 11}, {12, 13, 14, 5}});
        System.out.println(neighborSum2.adjacentSum(15));
        System.out.println(neighborSum2.diagonalSum(9));
    }
}
