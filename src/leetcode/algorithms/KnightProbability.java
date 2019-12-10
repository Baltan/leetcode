package leetcode.algorithms;

/**
 * Description: 688. Knight Probability in Chessboard
 *
 * @author Baltan
 * @date 2019-12-10 08:59
 */
public class KnightProbability {
    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
        System.out.println(knightProbability(25, 100, 0, 0));
        System.out.println(knightProbability(25, 100, 12, 13));
        System.out.println(knightProbability(25, 100, 20, 24));
        System.out.println(knightProbability(2, 3, 0, 0));
    }

    public static double knightProbability(int N, int K, int r, int c) {
        double result = 0;
        /**
         * dp[i][j][k]表示第k步走到(i,j)的概率
         */
        double[][][] dp = new double[N][N][K + 1];
        /**
         * 第0步位于初始位置的概率为1
         */
        dp[r][c][0] = 1;
        /**
         * 每一步可以有8种位置变换
         */
        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        /**
         * 对于当前位置的概率dp[i][j][k]，如果移动一步所到的位置(x,y)还在棋盘内，则
         * dp[x][y][k+1]+=dp[i][j][k]/8
         */
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    for (int[] move : moves) {
                        /**
                         * 移动一步所到的行索引
                         */
                        int nextX = j + move[0];
                        /**
                         * 移动一步所到的列索引
                         */
                        int nextY = k + move[1];

                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                            dp[nextX][nextY][i] += 1.0 * dp[j][k][i - 1] / 8;
                        }
                    }
                }
            }
        }
        /**
         * 统计第K步所到位置的概率和
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += dp[i][j][K];
            }
        }
        return result;
    }
}
