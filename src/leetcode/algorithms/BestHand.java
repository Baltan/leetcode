package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2347. Best Poker Hand
 *
 * @author Baltan
 * @date 2023/2/14 11:39
 */
public class BestHand {
    public static void main(String[] args) {
        System.out.println(bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        System.out.println(bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
        System.out.println(bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'}));
    }

    public static String bestHand(int[] ranks, char[] suits) {
        /**
         * 同花
         */
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) {
            return "Flush";
        }
        Arrays.sort(ranks);
        /**
         * 三条
         */
        if (ranks[0] == ranks[2] || ranks[1] == ranks[3] || ranks[2] == ranks[4]) {
            return "Three of a Kind";
        }
        /**
         * 对子
         */
        if (ranks[0] == ranks[1] || ranks[1] == ranks[2] || ranks[2] == ranks[3] || ranks[3] == ranks[4]) {
            return "Pair";
        }
        /**
         * 高牌
         */
        return "High Card";
    }
}
