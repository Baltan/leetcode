package leetcode.algorithms;

/**
 * Description: 2310. Sum of Numbers With Units Digit K
 *
 * @author Baltan
 * @date 2023/1/20 13:45
 */
public class MinimumNumbers {
    public static void main(String[] args) {
        System.out.println(minimumNumbers(58, 9));
        System.out.println(minimumNumbers(37, 2));
        System.out.println(minimumNumbers(0, 7));
    }

    public static int minimumNumbers(int num, int k) {
        /**
         * 所求和num为0，直接返回空多重集
         */
        if (num == 0) {
            return 0;
        }
        int result = 0;
        /**
         * 多重集中所有数字的和，主要是为了获得这些数字之和的个位，用来和num的个位作比较
         */
        int sum = 0;
        /**
         * num的个位
         */
        int numUnitsDigit = num % 10;
        /**
         * 因为每10个个位都为k的数字相加得到的和个位又为0，所以如果可以，多重集中至多只需要10个个位为k的数字
         */
        while (result < 10) {
            sum += k;
            result++;
            /**
             * 当前多重集中所有数字之和的个位
             */
            int sumUnitsDigit = sum % 10;
            /**
             * 多重集中的数字至少为k，所以多重集中所有数字之和至少为k*result，如果k*result不足num，只需要在某些数字上加若干个10即可
             */
            if (sumUnitsDigit == numUnitsDigit && k * result <= num) {
                return result;
            }
        }
        return -1;
    }
}
