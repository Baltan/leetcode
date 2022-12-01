package leetcode.algorithms;

/**
 * Description: 2483. Minimum Penalty for a Shop
 *
 * @author Baltan
 * @date 2022/11/29 17:46
 */
public class BestClosingTime {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("NNNNN"));
        System.out.println(bestClosingTime("YYYY"));
    }

    public static int bestClosingTime(String customers) {
        int result = Integer.MAX_VALUE;
        int minCost = Integer.MAX_VALUE;
        char[] charArray = customers.toCharArray();
        int length = charArray.length;
        /**
         * freeCount[i]表示前i个小时中没有顾客到达的小时数
         */
        int[] freeCount = new int[length + 1];

        for (int i = 0; i < length; i++) {
            freeCount[i + 1] = freeCount[i] + (charArray[i] == 'N' ? 1 : 0);
        }

        for (int i = 0; i <= length; i++) {
            /**
             * 1、第i（0-based）小时之前的i个小时，共有freeCount[i]个小时没有顾客到达
             * 2、从第i（0-based）小时开始，还剩length-i个小时，其中freeCount[length]-freeCount[i]个小时没有顾客到达，有顾客到达的小
             * 时数为(length-i-(freeCount[length]-freeCount[i]))
             * 3、总代价为freeCount[i]+(length-i-(freeCount[length]-freeCount[i]))
             */
            int cost = freeCount[i] + (length - i - (freeCount[length] - freeCount[i]));

            if (cost < minCost) {
                minCost = cost;
                result = i;
            }
        }
        return result;
    }
}
