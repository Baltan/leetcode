package leetcode.algorithms;

/**
 * Description: 495. Teemo Attacking
 *
 * @author Baltan
 * @date 2017/11/28 09:20
 */
public class FindPoisonedDuration {
    public static void main(String[] args) {
        int[] timeSeries1 = {1, 4};
        int[] timeSeries2 = {1, 2};
        int duration1 = 2;
        int duration2 = 2;
        System.out.println(findPoisonedDuration(timeSeries1, duration1));
        System.out.println(findPoisonedDuration(timeSeries2, duration2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int totalTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int effectTime = timeSeries[i] + duration < timeSeries[i + 1] ? duration : timeSeries[i + 1] - timeSeries[i];
            totalTime += effectTime;
        }
        return totalTime + duration;
    }
}
