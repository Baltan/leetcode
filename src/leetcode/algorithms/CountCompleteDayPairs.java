package leetcode.algorithms;

/**
 * Description: 3184. Count Pairs That Form a Complete Day I
 *
 * @author baltan
 * @date 2024/6/17 13:59
 * @see CountCompleteDayPairs1
 */
public class CountCompleteDayPairs {
    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

    public static long countCompleteDayPairs(int[] hours) {
        int result = 0;
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
