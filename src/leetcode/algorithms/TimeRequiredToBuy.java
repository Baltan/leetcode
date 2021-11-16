package leetcode.algorithms;

/**
 * Description: 2073. Time Needed to Buy Tickets
 *
 * @author Baltan
 * @date 2021/11/16 13:55
 */
public class TimeRequiredToBuy {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;

        for (int i = 0; i < tickets.length; i++) {
            /**
             * 到位置k的人买完票为止，排在位置k前的人，买的票数最多为tickets[k]张，最少为实际需要的票数；
             * 排在位置k后的人，买的票最多为tickets[k]-1张，最少为实际需要的票数
             */
            if (i < k) {
                result += Math.min(tickets[i], tickets[k]);
            } else if (i > k) {
                result += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        /**
         * 位置k的人自身买票需要耗时tickets[k]
         */
        return result + tickets[k];
    }
}
