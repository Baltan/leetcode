package leetcode.algorithms;

/**
 * Description: 959. Regions Cut By Slashes
 *
 * @author Baltan
 * @date 2020-02-29 12:57
 */
public class RegionsBySlashes {
    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(regionsBySlashes(new String[]{"//", "/ "}));
    }

    public static int regionsBySlashes(String[] grid) {
        int result = 0;
        int length = grid.length;
        int boardLength = length * 3;
        int[][] board = new int[boardLength][boardLength];
        /**
         * 将"/"看做：001
         *           010
         *           100
         *
         * 将"\"看做：100
         *           010
         *           001
         *
         * 将" "看做：000
         *           000
         *           000
         *
         * 得到新的矩阵后，计算连通分量的数量即可
         *
         * 参考：
         * <a href="https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/mei-ge-xiao-ge-fen-jie-wei-3-3-fang-ge-qiu-lian-to/"></a>
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char c = grid[i].charAt(j);

                if (c == '/') {
                    board[i * 3][j * 3 + 2] = 1;
                    board[i * 3 + 1][j * 3 + 1] = 1;
                    board[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    board[i * 3][j * 3] = 1;
                    board[i * 3 + 1][j * 3 + 1] = 1;
                    board[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] == 0) {
                    dfs(board, i, j, boardLength);
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 将当前的连通分量重新染色
     *
     * @param board
     * @param i
     * @param j
     * @param boardLength
     */
    public static void dfs(int[][] board, int i, int j, int boardLength) {
        if (i < 0 || i >= boardLength || j < 0 || j >= boardLength || board[i][j] != 0) {
            return;
        }

        board[i][j] = 2;
        dfs(board, i - 1, j, boardLength);
        dfs(board, i + 1, j, boardLength);
        dfs(board, i, j - 1, boardLength);
        dfs(board, i, j + 1, boardLength);
    }
}