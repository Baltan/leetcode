package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1109. Corporate Flight Bookings
 *
 * @author Baltan
 * @date 2019-07-08 16:59
 */
public class CorpFlightBookings {
    public static void main(String[] args) {
        int[][] bookings1 = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        OutputUtils.print1DIntegerArray(corpFlightBookings(bookings1, 5));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i <= booking[1] - 1; i++) {
                result[i] += booking[2];
            }
        }
        return result;
    }
}
