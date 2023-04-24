package leetcode.algorithms;

/**
 * Description: 2651. Calculate Delayed Arrival Time
 *
 * @author Baltan
 * @date 2023/4/24 15:53
 */
public class FindDelayedArrivalTime {
    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(15, 5));
        System.out.println(findDelayedArrivalTime(13, 11));
    }

    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
