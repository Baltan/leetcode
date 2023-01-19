package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 2332. The Latest Time to Catch a Bus
 *
 * @author Baltan
 * @date 2023/1/18 13:54
 */
public class LatestTimeCatchTheBus {
    public static void main(String[] args) {
        System.out.println(latestTimeCatchTheBus(new int[]{6, 8, 18, 17}, new int[]{6, 8, 17}, 1));
        System.out.println(latestTimeCatchTheBus(new int[]{10, 20}, new int[]{2, 17, 18, 19}, 2));
        System.out.println(latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2));
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int result = 0;
        int busIndex = 0;
        int passengerIndex = 0;
        /**
         * 所有乘客到达车站的时刻集合
         */
        Set<Integer> passengerTimes = Arrays.stream(passengers).boxed().collect(Collectors.toSet());
        Arrays.sort(buses);
        Arrays.sort(passengers);
        /**
         * 按序模拟每辆公交车到达车站的情况
         */
        while (busIndex < buses.length) {
            int busTime = buses[busIndex];
            int count = capacity;
            /**
             * 让busTime时刻前到达的乘客尽可能都上车
             */
            while (count > 0 && passengerIndex < passengers.length && passengers[passengerIndex] <= busTime) {
                passengerIndex++;
                count--;
            }

            if (count > 0) {
                /**
                 * 公交车还有空余座位，可以在busTime时刻前查找一个时刻到达车站
                 */
                result = Math.max(result, getMaxTime(busTime, passengerTimes));
            } else {
                /**
                 * 公交车没有空余座位，可以在这辆车最后一个上车的乘客的到站时刻之前查找一个时刻到达车站
                 */
                result = Math.max(result, getMaxTime(passengers[passengerIndex - 1], passengerTimes));
            }
            busIndex++;
        }
        return result;
    }

    /**
     * busTime时刻前找到没有乘客到达的最大时刻
     *
     * @param busTime
     * @param passengerTimes
     * @return
     */
    public static int getMaxTime(int busTime, Set<Integer> passengerTimes) {
        for (int i = busTime; i >= 0; i--) {
            if (!passengerTimes.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
