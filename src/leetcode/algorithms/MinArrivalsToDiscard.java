package leetcode.algorithms;

/**
 * Description: 3679. Minimum Discards to Balance Inventory
 *
 * @author Baltan
 * @date 2025/11/1 22:15
 */
public class MinArrivalsToDiscard {
    public static void main(String[] args) {
        System.out.println(minArrivalsToDiscard(new int[]{1, 2, 1, 3, 1}, 4, 2));
        System.out.println(minArrivalsToDiscard(new int[]{1, 2, 3, 3, 3, 4}, 3, 2));
    }

    public static int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int result = 0;
        /**
         * counts[i]表示最近w天的时间窗口中物品i的数量
         */
        int[] counts = new int[100001];
        /**
         * isDiscarded[i]表示第i+1天的物品是否被丢弃
         */
        boolean[] isDiscarded = new boolean[arrivals.length];

        for (int i = 0; i < arrivals.length; i++) {
            /**
             * 第i-w+1天已在最近w天的时间窗口之外，并且该物品未被丢弃，需要从时间窗口中减去该物品的数量
             */
            if (i - w >= 0 && !isDiscarded[i - w]) {
                counts[arrivals[i - w]]--;
            }
            /**
             * 如果不算第i+1天的物品arrivals[i]，时间窗口中该类物品数量已经达到了m，则需要丢弃第i+1天的物品arrivals[i]；否则在时间窗口
             * 中加上该物品的数量
             */
            if (counts[arrivals[i]] == m) {
                isDiscarded[i] = true;
                result++;
            } else {
                counts[arrivals[i]]++;
            }
        }
        return result;
    }
}
