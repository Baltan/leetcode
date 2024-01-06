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
        System.out.println(maxStudents(new char[][]{{'.', '.', '.', '.', '#', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '#', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '#', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '#', '.', '.', '#', '.'}}));
    }

    public static int maxStudents(char[][] seats) {
        int result = 0;
        int rows = seats.length;
        int cols = seats[0].length;
        /**
         * 每一行排座的最大可能状态，即0b10101……（1表示对应座位坐人，0表示不坐人）
         */
        int maxStatus = 0;

        for (int i = cols - 1; i >= 0; i -= 2) {
            maxStatus += 1 << i;
        }
        /**
         * counts[i]表示当某一行排座状态为i时，这一行安排的人数
         */
        int[] counts = new int[maxStatus + 1];
        /**
         * dp[i][j]表示seats[i-1]行排座状态为j时，前面所有i行座位最大可安排的人数
         */
        int[][] dp = new int[rows + 1][maxStatus + 1];

        for (int i = 0; i <= maxStatus; i++) {
            counts[i] = Integer.bitCount(i);
        }

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int currStatus = 0; currStatus <= maxStatus; currStatus++) {
                for (int prevStatus = 0; prevStatus <= maxStatus; prevStatus++) {
                    if (judge(seats, cols, rowIndex, prevStatus, currStatus)) {
                        dp[rowIndex + 1][currStatus] = Math.max(dp[rowIndex + 1][currStatus], dp[rowIndex][prevStatus] + counts[currStatus]);
                    }
                }
            }
        }

        for (int count : dp[rows]) {
            result = Math.max(result, count);
        }
        return result;
    }

    /**
     * 判断当seats[rowIndex-1]行排座状态为prevStatus的情况下，seats[rowIndex]行能否按照状态currStatus排座
     *
     * @param seats
     * @param cols
     * @param rowIndex
     * @param prevStatus
     * @param currStatus
     * @return
     */
    public static boolean judge(char[][] seats, int cols, int rowIndex, int prevStatus, int currStatus) {
        for (int colIndex = 0; colIndex < cols; colIndex++) {
            int offset = cols - colIndex - 1;
            /**
             * currStatus状态下，座位seats[rowIndex][colIndex]上不安排人，直接跳过判断下一列
             */
            if ((1 << offset & currStatus) == 0) {
                continue;
            }
            /**
             * 座位seats[rowIndex][colIndex]是坏的，不能坐人
             */
            if (seats[rowIndex][colIndex] == '#') {
                return false;
            }
            /**
             * 座位seats[rowIndex][colIndex]的左边座位已有人
             */
            if (colIndex - 1 >= 0 && (1 << (offset + 1) & currStatus) != 0) {
                return false;
            }
            /**
             * 座位seats[rowIndex][colIndex]的左上角座位已有人
             */
            if (rowIndex - 1 >= 0 && colIndex - 1 >= 0 && (1 << (offset + 1) & prevStatus) != 0) {
                return false;
            }
            /**
             * 座位seats[rowIndex][colIndex]的右上角座位已有人
             */
            if (rowIndex - 1 >= 0 && colIndex + 1 < cols && (1 << (offset - 1) & prevStatus) != 0) {
                return false;
            }
        }
        return true;
    }
}
