package leetcode.algorithms;

/**
 * Description: 2409. Count Days Spent Together
 *
 * @author Baltan
 * @date 2023/2/10 17:00
 */
public class CountDaysTogether {
    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31"));
        System.out.println(countDaysTogether("10-01", "10-11", "11-01", "12-31"));
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arriveMonthAlice = getValue(arriveAlice.charAt(0), arriveAlice.charAt(1));
        int arriveDayAlice = getValue(arriveAlice.charAt(3), arriveAlice.charAt(4));
        int arriveMonthBob = getValue(arriveBob.charAt(0), arriveBob.charAt(1));
        int arriveDayBob = getValue(arriveBob.charAt(3), arriveBob.charAt(4));
        int leaveMonthAlice = getValue(leaveAlice.charAt(0), leaveAlice.charAt(1));
        int leaveDayAlice = getValue(leaveAlice.charAt(3), leaveAlice.charAt(4));
        int leaveMonthBob = getValue(leaveBob.charAt(0), leaveBob.charAt(1));
        int leaveDayBob = getValue(leaveBob.charAt(3), leaveBob.charAt(4));
        int arriveDayOffsetAlice = getDayOffset(arriveMonthAlice, arriveDayAlice, days);
        int arriveDayOffsetBob = getDayOffset(arriveMonthBob, arriveDayBob, days);
        int leaveDayOffsetAlice = getDayOffset(leaveMonthAlice, leaveDayAlice, days);
        int leaveDayOffsetBob = getDayOffset(leaveMonthBob, leaveDayBob, days);
        /**
         * 两人中后到罗马的日子和先离开罗马的日子之间的日子两人同时在罗马
         */
        int day = Math.min(leaveDayOffsetAlice, leaveDayOffsetBob) - Math.max(arriveDayOffsetAlice, arriveDayOffsetBob) + 1;
        /**
         * 如果day小于等于0，说明其中一人在另一人到罗马前已经离开了
         */
        return day <= 0 ? 0 : day;
    }

    /**
     * 得到两位数字符串的数值
     *
     * @param tenBit
     * @param unitBit
     * @return
     */
    public static int getValue(char tenBit, char unitBit) {
        return (tenBit - '0') * 10 + (unitBit - '0');
    }

    /**
     * 计算month月day日是当年的第几天
     *
     * @param month
     * @param day
     * @param days
     * @return
     */
    public static int getDayOffset(int month, int day, int[] days) {
        int dayOffset = day;

        for (int i = month - 2; i >= 0; i--) {
            dayOffset += days[i];
        }
        return dayOffset;
    }
}
