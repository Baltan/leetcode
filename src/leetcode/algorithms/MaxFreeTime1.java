package leetcode.algorithms;

/**
 * Description: 3440. Reschedule Meetings for Maximum Free Time II
 *
 * @author Baltan
 * @date 2025/2/4 14:40
 * @see MaxFreeTime
 */
public class MaxFreeTime1 {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5}));
        System.out.println(maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10}));
        System.out.println(maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10}));
        System.out.println(maxFreeTime(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5}));
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int result = 0;
        int length = startTime.length;
        /**
         * 初始时，最长一段空闲时间的时长，为了方便计算，先取第一场会议之前和最后一场会议之后的两段空闲时间中的较大值
         */
        int first = Math.max(startTime[0], eventTime - endTime[length - 1]);
        /**
         * 初始时，第二长的一段空闲时间的时长，为了方便计算，先取第一场会议之前和最后一场会议之后的两段空闲时间中的较小值
         */
        int second = Math.min(startTime[0], eventTime - endTime[length - 1]);
        /**
         * 初始时，第三长的一段空闲时间的时长
         */
        int third = 0;
        /**
         * 计算获得初始时，最长的、第二长的、第三长的三段空闲时间各自的时长
         */
        for (int i = 1; i < length; i++) {
            int interval = startTime[i] - endTime[i - 1];

            if (interval >= first) {
                third = second;
                second = first;
                first = interval;
            } else if (interval >= second) {
                third = second;
                second = interval;
            } else if (interval >= third) {
                third = interval;
            }
        }
        /**
         * 排除第一场会议前后的两段空闲时间外，在剩余的空闲时间中可以获得的最长一段空闲时间的时长
         */
        int maxInterval = getMaxInterval(first, second, third, startTime[0], startTime[1] - endTime[0]);
        /**
         * 如果空闲时间段maxInterval内可以安排下第一场会议，则可以得到一段长度为startTime[1]的空闲时间段，否则，只能将第一场会议尽可能地
         * 向时刻0或第二场会议的开始时间靠拢，从而获得一段长度为startTime[1]-(endTime[0]-startTime[0])的空闲时间段
         */
        if (maxInterval >= endTime[0] - startTime[0]) {
            result = Math.max(result, startTime[1]);
        } else {
            result = Math.max(result, startTime[1] - (endTime[0] - startTime[0]));
        }

        for (int i = 1; i < length - 1; i++) {
            /**
             * 排除第i+1场会议前后的两段空闲时间外，在剩余的空闲时间中可以获得的最长一段空闲时间的时长
             */
            maxInterval = getMaxInterval(first, second, third, startTime[i] - endTime[i - 1], startTime[i + 1] - endTime[i]);
            /**
             * 如果空闲时间段maxInterval内可以安排下第i+1场会议，则可以得到一段长度为startTime[i+1]-endTime[i-1]的空闲时间段，否则，
             * 只能将第i+1场会议尽可能地向第i场会议的结束时间或第i+2场会议的开始时间靠拢，从而获得一段长度为
             * startTime[i+1]-endTime[i-1]-(endTime[i]-startTime[i])的空闲时间段
             */
            if (maxInterval >= endTime[i] - startTime[i]) {
                result = Math.max(result, startTime[i + 1] - endTime[i - 1]);
            } else {
                result = Math.max(result, startTime[i + 1] - endTime[i - 1] - (endTime[i] - startTime[i]));
            }
        }
        /**
         * 排除最后一场会议前后的两段空闲时间外，在剩余的空闲时间中可以获得的最长一段空闲时间的时长
         */
        maxInterval = getMaxInterval(first, second, third, startTime[length - 1] - endTime[length - 2], eventTime - endTime[length - 1]);
        /**
         * 如果空闲时间段maxInterval内可以安排下最后一场会议，则可以得到一段长度为eventTime-endTime[length-2]的空闲时间段，否则，只能
         * 将最后一场会议尽可能地向倒数第二场会议的结束时间或时刻eventTime靠拢，从而获得一段长度为
         * eventTime-endTime[length-2]-(endTime[length-1]-startTime[length-1])的空闲时间段
         */
        if (maxInterval >= endTime[length - 1] - startTime[length - 1]) {
            result = Math.max(result, eventTime - endTime[length - 2]);
        } else {
            result = Math.max(result, eventTime - endTime[length - 2] - (endTime[length - 1] - startTime[length - 1]));
        }
        return result;
    }

    /**
     * 排除初始时时长为interval1和interval2两段空闲时间，在剩余的空闲时间中可以获得的最长一段空闲时间的时长
     *
     * @param first
     * @param second
     * @param third
     * @param interval1
     * @param interval2
     * @return
     */
    public static int getMaxInterval(int first, int second, int third, int interval1, int interval2) {
        int max = Math.max(interval1, interval2);
        int min = Math.min(interval1, interval2);

        if (max == first) {
            /**
             * 如果最长的、第二长的两段空闲时间都已被排除，则只能利用第三长的一段空闲时间，否则如果只有最长的一段空闲时间被排除，则可以利用第
             * 二长的一段空闲时间
             */
            return min == second ? third : second;
        }
        return first;
    }
}
