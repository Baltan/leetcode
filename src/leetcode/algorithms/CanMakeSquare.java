package leetcode.algorithms;

/**
 * Description: 3127. Make a Square with the Same Color
 *
 * @author Baltan
 * @date 2024/4/29 22:38
 */
public class CanMakeSquare {
    public static void main(String[] args) {
        System.out.println(canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'B'}}));
        System.out.println(canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'B'}}));
        System.out.println(canMakeSquare(new char[][]{{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'W'}}));
    }

    public static boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                /**
                 * 左上角单元格为grid[i][j]的2×2矩阵中黑色单元格的个数
                 */
                int countB = 0;
                countB += grid[i][j] == 'B' ? 1 : 0;
                countB += grid[i][j + 1] == 'B' ? 1 : 0;
                countB += grid[i + 1][j] == 'B' ? 1 : 0;
                countB += grid[i + 1][j + 1] == 'B' ? 1 : 0;
                /**
                 * 只要2×2矩阵中的单元格不是2黑2白，都可以通过0或1次变换使得四个单元格颜色相同
                 */
                if (countB != 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
