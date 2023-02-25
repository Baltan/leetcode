package leetcode.algorithms;

/**
 * Description: 1450. Number of Students Doing Homework at a Given Time
 *
 * @author Baltan
 * @date 2023/2/18 20:59
 */
public class BusyStudent {
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
        System.out.println(busyStudent(new int[]{4}, new int[]{4}, 4));
        System.out.println(busyStudent(new int[]{4}, new int[]{4}, 5));
        System.out.println(busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        System.out.println(busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        int length = startTime.length;

        for (int i = 0; i < length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                result++;
            }
        }
        return result;
    }
}
