package leetcode.algorithms;

/**
 * Description: 1701. Average Waiting Time
 *
 * @author Baltan
 * @date 2022/8/20 14:52
 */
public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers1));

        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(averageWaitingTime(customers2));
    }

    public static double averageWaitingTime(int[][] customers) {
        long total = 0L;
        /**
         * 厨师开始完成每张订单的时间
         */
        int startTime = 0;

        for (int[] customer : customers) {
            int arrive = customer[0];
            int time = customer[1];
            /**
             * 如果厨师之前的订单已经全部完成，则可以从arrive时刻就开始完成当前订单，否则只能等到startTime时刻开始完成当前订单
             */
            if (arrive >= startTime) {
                startTime = arrive;
            }
            /**
             * 当前顾客等待的总时间
             */
            total += startTime + time - arrive;
            /**
             * 厨师完成当前订单的时刻
             */
            startTime += time;
        }
        return total * 1.0 / customers.length;
    }
}
