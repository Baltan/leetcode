package leetcode.algorithms;

/**
 * Description: 1583. Count Unhappy Friends
 *
 * @author Baltan
 * @date 2022/10/16 13:42
 * @see UnhappyFriends1
 */
public class UnhappyFriends {
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

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0;
        /**
         * isUnhappy[i]为true表示第i个朋友不开心
         */
        boolean[] isUnhappy = new boolean[n];
        /**
         * preferenceMatrix[i][j]表示i对j的偏好值
         */
        int[][] preferenceMatrix = new int[n][n];

        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                /**
                 * 因为preferences[i]为[a,b,c……]时表示i对a的亲近程度最高，i对b的亲近程度次之，以此类推。不妨就假设i对a的亲
                 * 近程度为n，i对b的亲近程度为n-1，以此类推
                 */
                preferenceMatrix[i][preferences[i][j]] = n - j;
            }
        }
        /**
         * 枚举所有x与y，u与v配对的情况
         */
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                isUnhappy(pairs[i][0], pairs[i][1], pairs[j][0], pairs[j][1], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[i][0], pairs[i][1], pairs[j][1], pairs[j][0], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[i][1], pairs[i][0], pairs[j][0], pairs[j][1], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[i][1], pairs[i][0], pairs[j][1], pairs[j][0], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[j][0], pairs[j][1], pairs[i][0], pairs[i][1], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[j][0], pairs[j][1], pairs[i][1], pairs[i][0], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[j][1], pairs[j][0], pairs[i][0], pairs[i][1], preferenceMatrix, isUnhappy);
                isUnhappy(pairs[j][1], pairs[j][0], pairs[i][1], pairs[i][0], preferenceMatrix, isUnhappy);
            }
        }
        /**
         * 统计不开心的朋友的数量
         */
        for (boolean bool : isUnhappy) {
            if (bool) {
                result++;
            }
        }
        return result;
    }

    /**
     * 判断x朋友是否不开心
     *
     * @param x
     * @param y
     * @param u
     * @param v
     * @param preferenceMatrix
     * @param isHappy
     */
    public static void isUnhappy(int x, int y, int u, int v, int[][] preferenceMatrix, boolean[] isHappy) {
        if (preferenceMatrix[x][u] > preferenceMatrix[x][y] &&
                preferenceMatrix[u][x] > preferenceMatrix[u][v]) {
            isHappy[x] = true;
        }
    }
}
