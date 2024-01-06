package leetcode.algorithms;

/**
 * Description: 1349. Maximum Students Taking Exam
 *
 * @author Baltan
 * @date 2023/12/29 23:59
 */
public class MaxStudents {
    public static void main(String[] args) {
        System.out.println(maxStudents(new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}}));
        System.out.println(maxStudents(new char[][]{{'.', '#'}, {'#', '#'}, {'#', '.'}, {'#', '#'}, {'.', '#'}}));
        System.out.println(maxStudents(new char[][]{{'#', '.', '.', '.', '#'}, {'.', '#', '.', '#', '.'}, {'.', '.', '#', '.', '.'}, {'.', '#', '.', '#', '.'}, {'#', '.', '.', '.', '#'}}));
    }

    private static int result;

    public static int maxStudents(char[][] seats) {
        result = 0;
        int rows = seats.length;
        int cols = seats[0].length;
        int maxStatus = 0;

        for (int i = cols - 1; i >= 0; i -= 2) {
            maxStatus += 1 << i;
        }
        boolean[][] impossible = new boolean[rows][maxStatus + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k <= maxStatus; k++) {
                    if (seats[i][j] == '#' && (1 << (cols - 1 - j) & k) != 0) {
                        impossible[i][k] = true;
                    }
                }
            }
        }
        dfs(impossible, rows, cols, maxStatus, 0, 0, 0);
        return result;
    }

    public static void dfs(boolean[][] impossible, int rows, int cols, int maxStatus, int rowIndex, int prevStatus, int count) {
        if (rowIndex == rows) {
            result = Math.max(result, count);
            return;
        }

        for (int currStatus = 0; currStatus <= maxStatus; currStatus++) {
            if (judge(impossible, cols, rowIndex, prevStatus, currStatus)) {
                count += Integer.bitCount(currStatus);
                dfs(impossible, rows, cols, maxStatus, rowIndex + 1, currStatus, count);
                count -= Integer.bitCount(currStatus);
            }
        }
    }

    public static boolean judge(boolean[][] impossible, int cols, int rowIndex, int prevStatus, int currStatus) {
        if (impossible[rowIndex][currStatus]) {
            return false;
        }

        for (int colIndex = 0; colIndex < cols; colIndex++) {
            int offset = cols - colIndex - 1;

            if ((1 << offset & currStatus) == 0) {
                continue;
            }

            if (colIndex - 1 >= 0 && (1 << (offset + 1) & currStatus) != 0) {
                return false;
            }

            if (colIndex + 1 < cols && (1 << (offset - 1) & currStatus) != 0) {
                return false;
            }

            if (rowIndex - 1 >= 0 && colIndex - 1 >= 0 && (1 << (offset + 1) & prevStatus) != 0) {
                return false;
            }

            if (rowIndex - 1 >= 0 && colIndex + 1 < cols && (1 << (offset - 1) & prevStatus) != 0) {
                return false;
            }
        }
        return true;
    }
}
