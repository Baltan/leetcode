package leetcode.algorithms;

/**
 * Description: 3238. Find the Number of Winning Players
 *
 * @author baltan
 * @date 2024/8/8 16:36
 */
public class WinningPlayerCount {
    public static void main(String[] args) {
        System.out.println(winningPlayerCount(4, new int[][]{{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}}));
        System.out.println(winningPlayerCount(5, new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}}));
        System.out.println(winningPlayerCount(5, new int[][]{{1, 1}, {2, 4}, {2, 4}, {2, 4}}));
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        int result = 0;
        /**
         * counts[i][j]表示玩家i得到颜色为j的球的个数
         */
        int[][] counts = new int[n][11];

        for (int i = 0; i < pick.length; i++) {
            counts[pick[i][0]][pick[i][1]]++;
        }

        for (int i = 0; i < n; i++) {
            /**
             * 判断玩家i是否得到某种颜色的小球多余i个
             */
            for (int count : counts[i]) {
                if (count > i) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
