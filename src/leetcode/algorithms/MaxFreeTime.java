package leetcode.algorithms;

/**
 * Description: 3439. Reschedule Meetings for Maximum Free Time I
 *
 * @author Baltan
 * @date 2025/2/4 14:40
 * @see MaxFreeTime1
 */
public class MaxFreeTime {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5}));
        System.out.println(maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
        System.out.println(maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5}));
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int length = startTime.length;
        /**
         * 重新安排会议后，至多可以将连续mergeCount+1段相邻的空闲时间合并
         */
        int mergeCount = Math.min(k, length + 1);
        /**
         * 合并连续mergeCount+1段相邻的空闲时间得到的总时间
         */
        int totalTime = 0;
        /**
         * intervals[0]为第一场会议开始前的空闲时间，intervals[length]为最后一场会议结束后的空闲时间，其余intervals[i]依次表示相邻两场
         * 会议之间的空闲时间
         */
        int[] intervals = new int[length + 1];
        intervals[0] = startTime[0];
        intervals[length] = eventTime - endTime[length - 1];

        for (int i = 1; i < length; i++) {
            intervals[i] = startTime[i] - endTime[i - 1];
        }
        /**
         * 先计算开始时的mergeCount+1段空闲时间合并后的总时间
         */
        for (int i = 0; i <= mergeCount; i++) {
            totalTime += intervals[i];
        }
        int result = totalTime;
        /**
         * 依次计算后续mergeCount+1段空闲时间合并后的总时间，并更新最优解
         */
        for (int i = mergeCount + 1; i <= length; i++) {
            totalTime -= intervals[i - mergeCount - 1];
            totalTime += intervals[i];
            result = Math.max(result, totalTime);
        }
        return result;
    }
}
