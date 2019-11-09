package leetcode.algorithms;

/**
 * Description: 1250. Check If It Is a Good Array
 *
 * @author Baltan
 * @date 2019-11-09 17:19
 */
public class IsGoodArray {
    public static void main(String[] args) {
        System.out.println(isGoodArray(new int[]{12, 5, 7, 23}));
        System.out.println(isGoodArray(new int[]{29, 6, 10}));
        System.out.println(isGoodArray(new int[]{3, 6}));
        System.out.println(isGoodArray(new int[]{1}));
    }

    public static boolean isGoodArray(int[] nums) {
        /**
         * 计算所有数字的最大公因数，若最大公因数为1，就是好数组
         */
        int greatestCommonDivisor = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            int max = Math.max(greatestCommonDivisor, nums[i]);
            int min = Math.min(greatestCommonDivisor, nums[i]);
            int remainder = max % min;

            while (remainder != 0) {
                max = min;
                min = remainder;
                remainder = max % min;
            }
            greatestCommonDivisor = min;
            /**
             * 如果当前这些的数字的最大公因数已经为1了，后面的数字可以不用再做计算，所有数字的最大公因数肯定也为1
             */
            if (greatestCommonDivisor == 1) {
                return true;
            }
        }
        return greatestCommonDivisor == 1;
    }
}
