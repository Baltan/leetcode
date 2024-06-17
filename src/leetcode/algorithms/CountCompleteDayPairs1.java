package leetcode.algorithms;

/**
 * Description: 3185. Count Pairs That Form a Complete Day II
 *
 * @author baltan
 * @date 2024/6/17 14:11
 * @see CountCompleteDayPairs
 */
public class CountCompleteDayPairs1 {
    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

    public static long countCompleteDayPairs(int[] hours) {
        long result = 0L;
        /**
         * counts[i]表示数组hours中除以24余数为i的数字的个数
         */
        int[] counts = new int[24];

        for (int hour : hours) {
            int remainder = hour % 24;
            result += counts[remainder == 0 ? 0 : 24 - remainder];
            counts[remainder]++;
        }
        return result;
    }
}
