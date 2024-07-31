package leetcode.algorithms;

/**
 * Description: 3232. Find if Digit Game Can Be Won
 *
 * @author baltan
 * @date 2024/7/29 16:34
 */
public class CanAliceWin {
    public static void main(String[] args) {
        System.out.println(canAliceWin(new int[]{1, 2, 3, 4, 10}));
        System.out.println(canAliceWin(new int[]{1, 2, 3, 4, 5, 14}));
        System.out.println(canAliceWin(new int[]{5, 5, 5, 25}));
    }

    public static boolean canAliceWin(int[] nums) {
        /**
         * 数组nums中所有个位数的和
         */
        int sum1 = 0;
        /**
         * 数组nums中所有两位数的和
         */
        int sum2 = 0;

        for (int num : nums) {
            if (num < 10) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        return sum1 != sum2;
    }
}
