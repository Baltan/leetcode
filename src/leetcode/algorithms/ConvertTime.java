package leetcode.algorithms;

/**
 * Description: 2224. Minimum Number of Operations to Convert Time
 *
 * @author Baltan
 * @date 2022/4/8 22:46
 */
public class ConvertTime {
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
        System.out.println(convertTime("11:00", "11:01"));
    }

    public static int convertTime(String current, String correct) {
        int result = 0;
        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");
        /**
         * 当前时间与正确时间相差的分钟数
         */
        int diffMinutes =
                (Integer.valueOf(correctTime[0]) - Integer.valueOf(currentTime[0])) * 60 +
                        (Integer.valueOf(correctTime[1]) - Integer.valueOf(currentTime[1]));
        int[] operationMinutes = {60, 15, 5, 1};
        /**
         * 根据贪心的原则，优先增加较大的时间，依次减小，知道最后尝试增加最小的时间
         */
        for (int operationMinute : operationMinutes) {
            if (diffMinutes >= operationMinute) {
                int times = diffMinutes / operationMinute;
                result += times;
                diffMinutes -= times * operationMinute;
            }
        }
        return result;
    }
}
