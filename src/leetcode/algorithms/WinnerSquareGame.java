package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1510. Stone Game IV
 *
 * @author Baltan
 * @date 2023/4/11 17:53
 */
public class WinnerSquareGame {
    public static void main(String[] args) {
        System.out.println(winnerSquareGame(1));
        System.out.println(winnerSquareGame(2));
        System.out.println(winnerSquareGame(4));
        System.out.println(winnerSquareGame(7));
        System.out.println(winnerSquareGame(17));
        System.out.println(winnerSquareGame(100000));
    }

    public static boolean winnerSquareGame(int n) {
        List<Integer> squaredNums = getSquaredNums(n);
        /**
         * dp[i]表示当石子总个数为i时，先手是否能获胜
         */
        boolean[] dp = new boolean[n + 1];
        /**
         * 如果只有一个石子，则先手直接拿完唯一的石子获胜
         */
        dp[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int squaredNum : squaredNums) {
                /**
                 * 先手拿走的石头个数范围为[1,i]中的完全平方数
                 */
                if (squaredNum > i) {
                    break;
                }
                /**
                 * 如果先手先拿squaredNum个石子，相对后手来说，就在石子个数为i-squaredNum时，成为了先手，如果此时后手无法取胜，则先手只要
                 * 先拿squaredNum个石子一定可以取胜
                 */
                if (!dp[i - squaredNum]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 计算[1,n]范围内的所有完全平方数
     *
     * @param n
     * @return
     */
    public static List<Integer> getSquaredNums(int n) {
        List<Integer> squaredNums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int squaredNum = i * i;

            if (squaredNum > n) {
                break;
            }
            squaredNums.add(squaredNum);
        }
        return squaredNums;
    }
}
