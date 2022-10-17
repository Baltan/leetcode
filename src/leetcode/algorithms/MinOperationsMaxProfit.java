package leetcode.algorithms;

/**
 * Description: 1599. Maximum Profit of Operating a Centennial Wheel
 *
 * @author Baltan
 * @date 2022/10/11 14:32
 */
public class MinOperationsMaxProfit {
    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
        System.out.println(minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
        System.out.println(minOperationsMaxProfit(new int[]{10, 9, 6}, 6, 4));
        System.out.println(minOperationsMaxProfit(new int[]{3, 4, 0, 5, 1}, 1, 92));
    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int result = -1;
        /**
         * 当天摩天轮的轮转总次数
         */
        int rotations = 0;
        /**
         * 当前等候的总游客数
         */
        int leftCustomers = 0;
        /**
         * 当前在摩天轮上的总游客数
         */
        int totalBoardCustomers = 0;
        /**
         * 当前已经获得过的最大利润
         */
        int maxProfit = 0;
        int index = 0;

        while (leftCustomers > 0 || index < customers.length) {
            /**
             * 累加新到达的游客
             */
            if (index < customers.length) {
                leftCustomers += customers[index];
                index++;
            }
            /**
             * 尽可能使得最多的游客登上摩天轮
             */
            int currentBoardCustomers = Math.min(4, leftCustomers);
            totalBoardCustomers += currentBoardCustomers;
            leftCustomers -= currentBoardCustomers;
            rotations++;
            /**
             * 当前利润
             */
            int profit = boardingCost * totalBoardCustomers - runningCost * rotations;

            if (profit > maxProfit) {
                result = rotations;
                maxProfit = profit;
            }
        }
        return result;
    }
}
