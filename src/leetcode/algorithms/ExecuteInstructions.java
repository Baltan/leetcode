package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2120. Execution of All Suffix Instructions Staying in a Grid
 *
 * @author Baltan
 * @date 2021/12/29 22:02
 */
public class ExecuteInstructions {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(executeInstructions(3, new int[]{0, 1}, "RRDDLU"));
        OutputUtils.print1DIntegerArray(executeInstructions(2, new int[]{1, 1}, "LURD"));
        OutputUtils.print1DIntegerArray(executeInstructions(1, new int[]{0, 0}, "LRUD"));
    }

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int length = s.length();
        int[] result = new int[length];
        /**
         * rowMoves[i+1]表示从第一条指令开始第i条指令后机器人在垂直方向上走过的距离，向下为正，向上为负
         */
        int[] rowMoves = new int[length + 1];
        /**
         * colMoves[i+1]表示从第一条指令开始第i条指令后机器人在水平方向上走过的距离，向右为正，向左为负
         */
        int[] colMoves = new int[length + 1];
        /**
         * 计算从第一条指令开始，每条指令过后机器人在垂直方向和水平方向上走过的距离
         */
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'U') {
                rowMoves[i + 1] = rowMoves[i] - 1;
                colMoves[i + 1] = colMoves[i];
            } else if (c == 'D') {
                rowMoves[i + 1] = rowMoves[i] + 1;
                colMoves[i + 1] = colMoves[i];
            } else if (c == 'L') {
                rowMoves[i + 1] = rowMoves[i];
                colMoves[i + 1] = colMoves[i] - 1;
            } else if (c == 'R') {
                rowMoves[i + 1] = rowMoves[i];
                colMoves[i + 1] = colMoves[i] + 1;
            }
        }
        /**
         * 机器人从第i条指令开始执行
         */
        for (int i = 0; i < length; i++) {
            /**
             * 遍历机器人在执行完第j条指令之后的情况
             */
            for (int j = i; j < length; j++) {
                /**
                 * 机器人在执行完s[i]到s[j]这些指令后在垂直方向上走过的距离
                 */
                int rowMove = rowMoves[j + 1] - rowMoves[i];
                /**
                 * 机器人在执行完s[i]到s[j]这些指令后在水平方向上走过的距离
                 */
                int colMove = colMoves[j + 1] - colMoves[i];
                /**
                 * 机器人在执行完s[i]到s[j]这些指令后在垂直方向上的坐标
                 */
                int rowPos = startPos[0] + rowMove;
                /**
                 * 机器人在执行完s[i]到s[j]这些指令后在水平方向上的坐标
                 */
                int colPos = startPos[1] + colMove;
                /**
                 * 如果机器人仍在网格内，则符合题目要求，继续循环判断尝试后面的指令
                 */
                if (rowPos >= 0 && rowPos < n && colPos >= 0 && colPos < n) {
                    result[i] = j - i + 1;
                } else {
                    /**
                     * 机器人走出网格，结束循环判断
                     */
                    break;
                }
            }
        }
        return result;
    }
}
