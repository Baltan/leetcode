package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2260. Minimum Consecutive Cards to Pick Up
 *
 * @author Baltan
 * @date 2022/5/5 14:39
 */
public class MinimumCardPickup {
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(minimumCardPickup(new int[]{1, 0, 5, 3}));
    }

    public static int minimumCardPickup(int[] cards) {
        int result = Integer.MAX_VALUE;
        /**
         * 卡牌x -> 正序遍历过程中，卡牌x在cards中最近一次出现的索引位置
         */
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];

            if (indexMap.containsKey(card)) {
                /**
                 * 以当前卡牌所在索引位置为结尾，该卡牌上一次出现的索引位置为开头，构成的子数组中至少有一对匹配的卡牌
                 */
                result = Math.min(result, i - indexMap.get(card) + 1);
            }
            indexMap.put(card, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
