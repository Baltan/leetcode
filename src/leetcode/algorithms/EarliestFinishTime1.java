package leetcode.algorithms;

/**
 * Description: 3635. Earliest Finish Time for Land and Water Rides II
 *
 * @author Baltan
 * @date 2025/9/3 23:38
 * @see EarliestFinishTime
 */
public class EarliestFinishTime1 {
    public static void main(String[] args) {
        System.out.println(earliestFinishTime(new int[]{2, 8}, new int[]{4, 1}, new int[]{6}, new int[]{3}));
        System.out.println(earliestFinishTime(new int[]{5}, new int[]{3}, new int[]{1}, new int[]{10}));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(help(landStartTime, landDuration, waterStartTime, waterDuration), help(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    /**
     * 计算先玩first游乐设施，再玩second游乐设施时的最早完成时间
     *
     * @param firstStartTime
     * @param firstDuration
     * @param secondStartTime
     * @param secondDuration
     * @return
     */
    public static int help(int[] firstStartTime, int[] firstDuration, int[] secondStartTime, int[] secondDuration) {
        int result = Integer.MAX_VALUE;
        /**
         * 玩好first游乐设施的最早结束时间
         */
        int firstEndTime = Integer.MAX_VALUE;

        for (int i = 0; i < firstStartTime.length; i++) {
            firstEndTime = Math.min(firstEndTime, firstStartTime[i] + firstDuration[i]);
        }

        for (int i = 0; i < secondStartTime.length; i++) {
            result = Math.min(result, Math.max(firstEndTime, secondStartTime[i]) + secondDuration[i]);
        }
        return result;
    }
}
