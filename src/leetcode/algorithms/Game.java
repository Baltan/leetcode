package leetcode.algorithms;

/**
 * Description: LCP 01. 猜数字
 *
 * @author Baltan
 * @date 2019-09-27 09:31
 */
public class Game {
    public static void main(String[] args) {
        System.out.println(game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(game(new int[]{2, 2, 3}, new int[]{3, 2, 1}));
    }

    public static int game(int[] guess, int[] answer) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }
        return result;
    }
}
