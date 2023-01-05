package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2410. Maximum Matching of Players With Trainers
 *
 * @author Baltan
 * @date 2022/12/21 09:10
 */
public class MatchPlayersAndTrainers {
    public static void main(String[] args) {
        int[] players1 = {4, 7, 9};
        int[] trainers1 = {8, 2, 5, 8};
        System.out.println(matchPlayersAndTrainers(players1, trainers1));

        int[] players2 = {1, 1, 1};
        int[] trainers2 = {10};
        System.out.println(matchPlayersAndTrainers(players2, trainers2));
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int result = 0;
        /**
         * 指向训练师的索引
         */
        int index = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        for (int playerAbility : players) {
            /**
             * 查找第一个能力值大于playerAbility的训练师
             */
            while (index < trainers.length && trainers[index] < playerAbility) {
                index++;
            }
            /**
             * 不存在能力值大于playerAbility的训练师
             */
            if (index >= trainers.length) {
                break;
            }
            result++;
            index++;
        }
        return result;
    }
}
