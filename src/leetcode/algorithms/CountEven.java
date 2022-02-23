package leetcode.algorithms;

/**
 * Description: 2180. Count Integers With Even Digit Sum
 *
 * @author Baltan
 * @date 2022/2/23 09:28
 */
public class CountEven {
    public static void main(String[] args) {
        System.out.println(countEven(4));
        System.out.println(countEven(30));
    }

    public static int countEven(int num) {
        int result = 0;

        if (num < 9) {
            /**
             * 10以下正整数及小于等于它的各位数字之和为偶数的正整数的个数对应关系为
             * 1    2   3   4   5   6   7   8   9
             * 0    1   1   2   2   3   3   4   4
             * 所以10以下部分小于等于num的各位数字之和为偶数的正整数的个数为num/2
             */
            result = num / 2;
            return result;
        } else {
            /**
             * 计数10以下部分小于等于num的各位数字之和为偶数的正整数的个数
             */
            result += 4;
        }
        /**
         * 小于等于num的最大的10的倍数
         */
        int upperLimit = num / 10 * 10;
        /**
         * 数字upperLimit的各位数字之和
         */
        int upperLimitDigitSum = digitSum(upperLimit);
        /**
         * 当upperLimitDigitSum为奇数时，例如：
         * 10   11  12  13  14  15  16  17  18  19
         * 0    1   1   2   2   3   3   4   4   5
         * 小于等于num且大于等于upperLimit的各位数字之和为偶数的正整数的个数为(num-upperLimit+1)/2
         *
         * 当upperLimitDigitSum为偶数时，例如：
         * 20   21  22  23  24  25  26  27  28  29
         * 1    1   2   2   3   3   4   4   5   5
         * 小于等于num且大于等于upperLimit的各位数字之和为偶数的正整数的个数为(num-upperLimit)/2+1
         */
        if (upperLimitDigitSum % 2 == 0) {
            result += (num - upperLimit) / 2 + 1;
        } else {
            result += (num - upperLimit + 1) / 2;
        }
        /**
         * 区间[10,upperLimit)中各位数字之和为偶数的正整数的个数刚好占这部分数字的一半，因为每组[k*10,(k+1)*10)中都是5个
         */
        if (num >= 20) {
            result += (upperLimit - 10) / 2;
        }
        return result;
    }

    /**
     * 计算数字num的各位数字之和
     *
     * @param num
     * @return
     */
    public static int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
