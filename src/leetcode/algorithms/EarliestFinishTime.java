package leetcode.algorithms;

/**
 * Description: 3633. Earliest Finish Time for Land and Water Rides I
 *
 * @author Baltan
 * @date 2025/9/3 23:38
 * @see EarliestFinishTime1
 */
public class EarliestFinishTime {
    public static void main(String[] args) {
        System.out.println(earliestFinishTime(new int[]{2, 8}, new int[]{4, 1}, new int[]{6}, new int[]{3}));
        System.out.println(earliestFinishTime(new int[]{5}, new int[]{3}, new int[]{1}, new int[]{10}));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;
        /**
         * 枚举所有两类游乐设施的组合
         */
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                /**
                 * 先玩陆地游乐设施，再玩水上游乐设施
                 */
                result = Math.min(result, Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j]);
                /**
                 * 先玩水上游乐设施，再玩陆地游乐设施
                 */
                result = Math.min(result, Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i]);
            }
        }
        return result;
    }
}
