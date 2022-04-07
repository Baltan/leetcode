package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2225. Find Players With Zero or One Losses
 *
 * @author Baltan
 * @date 2022/4/6 17:40
 */
public class FindWinners {
    public static void main(String[] args) {
        int[][] matches1 = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches1));

        int[][] matches2 = {{2, 3}, {1, 3}, {5, 4}, {6, 4}};
        System.out.println(findWinners(matches2));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>(2);
        /**
         * 保存全胜的选手
         */
        List<Integer> allWin = new ArrayList<>();
        /**
         * 保存只输一场的选手
         */
        List<Integer> loseOne = new ArrayList<>();
        /**
         * 根据题意，至多有100000位选手
         */
        int maxPlayer = 100000;
        /**
         * matchResult[i][0]表示第i个选手获胜的次数，matchResult[i][1]表示第i个选手失败的次数
         */
        int[][] matchResult = new int[maxPlayer + 1][2];
        result.add(allWin);
        result.add(loseOne);
        /**
         * 统计每位选手获胜和失败的次数
         */
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            matchResult[winner][0]++;
            matchResult[loser][1]++;
        }

        for (int i = 1; i <= maxPlayer; i++) {
            if (matchResult[i][0] != 0 && matchResult[i][1] == 0) {
                allWin.add(i);
            } else if (matchResult[i][1] == 1) {
                loseOne.add(i);
            }
        }
        return result;
    }
}
