package leetcode.algorithms;

/**
 * Description: 1732. Find the Highest Altitude
 *
 * @author Baltan
 * @date 2022/8/5 11:08
 */
public class LargestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int result = 0;
        /**
         * 初始海拔高度
         */
        int altitude = 0;

        for (int diff : gain) {
            altitude += diff;
            result = Math.max(result, altitude);
        }
        return result;
    }
}
