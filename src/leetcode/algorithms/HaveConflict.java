package leetcode.algorithms;

/**
 * Description: 2446. Determine if Two Events Have Conflict
 *
 * @author Baltan
 * @date 2023/2/9 09:20
 */
public class HaveConflict {
    public static void main(String[] args) {
        System.out.println(haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        System.out.println(haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        System.out.println(haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        int[] times1 = {toMinute(event1[0]), toMinute(event1[1])};
        int[] times2 = {toMinute(event2[0]), toMinute(event2[1])};
        /**
         * 当某一事件的开始时间介于另一事件的起始时间之间时，这两个事件时间上存在交集，存在冲突
         */
        return (times1[0] >= times2[0] && times1[0] <= times2[1]) || (times2[0] >= times1[0] && times2[0] <= times1[1]);
    }

    /**
     * 将"HH:MM"的时间格式转换为相对"00:00"经过的分钟数
     *
     * @param time
     * @return
     */
    public static int toMinute(String time) {
        char[] charArray = time.toCharArray();
        return ((charArray[0] - '0') * 10 + (charArray[1] - '0')) * 60 + ((charArray[3] - '0') * 10 + (charArray[4] - '0'));
    }
}
