package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 539. Minimum Time Difference
 *
 * @author Baltan
 * @date 2019-07-17 12:45
 */
public class FindMinDifference {
    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59", "00:00")));
    }

    public static int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        int length = timePoints.size();
        int[] minutes = new int[length];
        /**
         * 将每个字符串形式的时间表示计算为该时间点距离00：00的分钟数，在数组中保存
         */
        for (int i = 0; i < length; i++) {
            String timePoint = timePoints.get(i);
            int hour = Integer.valueOf(timePoint.substring(0, 2));
            int minute = Integer.valueOf(timePoint.substring(3));
            minutes[i] = hour * 60 + minute;
        }

        Arrays.sort(minutes);
        /**
         * 计算相邻两个时间点相差的分钟数
         */
        for (int i = 1; i < length; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }
        /**
         * 最后哟啊计算最早的时间和最晚的时间相差的分钟数，例如：
         * 00：03和23：58相差的时间为5分钟
         */
        result = Math.min(result, 24 * 60 - minutes[length - 1] + minutes[0]);
        return result;
    }
}
