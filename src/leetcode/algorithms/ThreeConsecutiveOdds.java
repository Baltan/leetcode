package leetcode.algorithms;

/**
 * Description: 1550. Three Consecutive Odds
 *
 * @author Baltan
 * @date 2020-08-23 23:40
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        /**
         * 连续奇数的个数
         */
        int count = 0;

        for (int value : arr) {
            if (value % 2 == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
