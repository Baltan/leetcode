package leetcode.algorithms;

/**
 * Description: 2018. Check if Word Can Be Placed In Crossword
 *
 * @author Baltan
 * @date 2021/11/25 09:24
 */
public class PlaceWordInCrossword {
    public static void main(String[] args) {
        char[][] board1 = {{'#', ' ', '#'}, {' ', ' ', '#'}, {'#', 'c', ' '}};
        String word1 = "abc";
        System.out.println(placeWordInCrossword(board1, word1));

        char[][] board2 = {{' ', '#', 'a'}, {' ', '#', 'c'}, {' ', '#', 'a'}};
        String word2 = "ac";
        System.out.println(placeWordInCrossword(board2, word2));

        char[][] board3 = {{'#', ' ', '#'}, {' ', ' ', '#'}, {'#', ' ', 'c'}};
        String word3 = "ca";
        System.out.println(placeWordInCrossword(board3, word3));
    }

    public static boolean placeWordInCrossword(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        /**
         * rowVisited[i][j]表示包含字符board[i][j]的格子是否在水平方向上被尝试填充过word
         */
        boolean[][] rowVisited = new boolean[rows][cols];
        /**
         * rowVisited[i][j]表示包含字符board[i][j]的格子是否在垂直方向上被尝试填充过word
         */
        boolean[][] colVisited = new boolean[rows][cols];
        /**
         * word翻转得到的字符串
         */
        String reversedWord = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    continue;
                }

                if (!rowVisited[i][j]) {
                    StringBuilder builder = new StringBuilder();
                    int k = j;
                    /**
                     * 得到board[i][j]开始水平方向的待填充单元格串
                     */
                    while (k < cols && board[i][k] != '#') {
                        builder.append(board[i][k]);
                        rowVisited[i][k] = true;
                        k++;
                    }

                    String wholeWord = builder.toString();

                    if (judge(word, wholeWord)) {
                        return true;
                    }

                    if (judge(reversedWord, wholeWord)) {
                        return true;
                    }
                }

                if (!colVisited[i][j]) {
                    StringBuilder builder = new StringBuilder();
                    int k = i;
                    /**
                     * 得到board[i][j]开始垂直方向的待填充单元格串
                     */
                    while (k < rows && board[k][j] != '#') {
                        builder.append(board[k][j]);
                        colVisited[k][j] = true;
                        k++;
                    }

                    String wholeWord = builder.toString();

                    if (judge(word, wholeWord)) {
                        return true;
                    }

                    if (judge(reversedWord, wholeWord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断word能否填充wholeWord
     *
     * @param word
     * @param wholeWord
     * @return
     */
    public static boolean judge(String word, String wholeWord) {
        /**
         * 如果word和wholeWord长度不相等，word不能正好填充wholeWord
         */
        if (word.length() != wholeWord.length()) {
            return false;
        }

        int length = word.length();

        for (int i = 0; i < length; i++) {
            /**
             * 如果word某个索引上的字符和wholeWord同样索引上已存在的字符不相等，word不能填充wholeWord
             */
            if (wholeWord.charAt(i) != ' ' && wholeWord.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
