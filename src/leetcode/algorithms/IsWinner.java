package leetcode.algorithms;

/**
 * Description: 2660. Determine the Winner of a Bowling Game
 *
 * @author Baltan
 * @date 2023/5/1 14:56
 */
public class IsWinner {
    public static void main(String[] args) {
        System.out.println(isWinner(new int[]{5, 6, 1, 10}, new int[]{5, 1, 10, 5}));
        System.out.println(isWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3}));
        System.out.println(isWinner(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2}));
        System.out.println(isWinner(new int[]{2, 3}, new int[]{4, 1}));
    }

    public static int isWinner(int[] player1, int[] player2) {
        int length = player1.length;
        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < length; i++) {
            score1 += isDouble(player1, i) ? player1[i] << 1 : player1[i];
            score2 += isDouble(player2, i) ? player2[i] << 1 : player2[i];
        }
        return score1 == score2 ? 0 : (score1 < score2 ? 2 : 1);
    }

    /**
     * 本轮得分是否需要翻倍
     *
     * @param player
     * @param index
     * @return
     */
    public static boolean isDouble(int[] player, int index) {
        return (index - 1 >= 0 && player[index - 1] == 10) || (index - 2 >= 0 && player[index - 2] == 10);
    }
}
