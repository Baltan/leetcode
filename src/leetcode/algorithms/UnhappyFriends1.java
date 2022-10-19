package leetcode.algorithms;

/**
 * Description: 1583. Count Unhappy Friends
 *
 * @author Baltan
 * @date 2022/10/16 13:42
 * @see UnhappyFriends
 */
public class UnhappyFriends1 {
    public static void main(String[] args) {
        int[][] preferences1 = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] pairs1 = {{0, 1}, {2, 3}};
        System.out.println(unhappyFriends(4, preferences1, pairs1));

        int[][] preferences2 = {{1}, {0}};
        int[][] pairs2 = {{1, 0}};
        System.out.println(unhappyFriends(2, preferences2, pairs2));

        int[][] preferences3 = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs3 = {{1, 3}, {0, 2}};
        System.out.println(unhappyFriends(4, preferences3, pairs3));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/count-unhappy-friends/solutions/441181/tong-ji-bu-kai-xin-de-peng-you-by-leetcode-solutio/"></a>
     *
     * @param n
     * @param preferences
     * @param pairs
     * @return
     */
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0;
        /**
         * preferenceMatrix[i][j]表示j在i的朋友中亲近程度由高到低排列时的位次（0-based）
         */
        int[][] preferenceMatrix = new int[n][n];
        /**
         * isMatched[i]=j表示i与j配对
         */
        int[] isMatched = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                preferenceMatrix[i][preferences[i][j]] = j;
            }
        }

        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            isMatched[x] = y;
            isMatched[y] = x;
        }

        for (int x = 0; x < n; x++) {
            int y = isMatched[x];
            /**
             * y在x的朋友中亲近程度由高到低排列时的位次（0-based）
             */
            int order = preferenceMatrix[x][y];
            /**
             * 枚举所有对x而言，比y更亲近的朋友
             */
            for (int i = 0; i < order; i++) {
                /**
                 * x和u比x和y亲近程度更高
                 */
                int u = preferences[x][i];
                int v = isMatched[u];

                if (preferenceMatrix[u][x] < preferenceMatrix[u][v]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
