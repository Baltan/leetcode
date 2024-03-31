package leetcode.algorithms;

/**
 * Description: 3096. Minimum Levels to Gain More Points
 *
 * @author Baltan
 * @date 2024/3/31 13:51
 */
public class MinimumLevels {
    public static void main(String[] args) {
        System.out.println(minimumLevels(new int[]{1, 1}));
        System.out.println(minimumLevels(new int[]{1, 0, 1, 0}));
        System.out.println(minimumLevels(new int[]{1, 1, 1, 1, 1}));
        System.out.println(minimumLevels(new int[]{0, 0}));
    }

    public static int minimumLevels(int[] possible) {
        /**
         * 所有关卡的总得分
         */
        int sum = 0;
        /**
         * Danielchandg的总得分
         */
        int daniel = 0;

        for (int i = 0; i < possible.length; i++) {
            sum += possible[i] == 0 ? -1 : 1;
        }
        /**
         * 因为每位玩家至少要玩一轮游戏，所以Danielchandg至多玩到倒数第二关
         */
        for (int i = 0; i < possible.length - 1; i++) {
            daniel += possible[i] == 0 ? -1 : 1;

            if (daniel > sum - daniel) {
                return i + 1;
            }
        }
        return -1;
    }
}
