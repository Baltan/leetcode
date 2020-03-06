package leetcode.algorithms;

/**
 * Description: 829. Consecutive Numbers Sum
 *
 * @author Baltan
 * @date 2019-08-28 09:33
 * @see FindContinuousSequence
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(1));
        System.out.println(consecutiveNumbersSum(2));
        System.out.println(consecutiveNumbersSum(3));
        System.out.println(consecutiveNumbersSum(4));
        System.out.println(consecutiveNumbersSum(5));
        System.out.println(consecutiveNumbersSum(6));
        System.out.println(consecutiveNumbersSum(7));
        System.out.println(consecutiveNumbersSum(8));
        System.out.println(consecutiveNumbersSum(9));
        System.out.println(consecutiveNumbersSum(10));
        System.out.println(consecutiveNumbersSum(11));
        System.out.println(consecutiveNumbersSum(12));
        System.out.println(consecutiveNumbersSum(13));
        System.out.println(consecutiveNumbersSum(9999999));
        System.out.println(consecutiveNumbersSum(1000000000));
    }

    public static int consecutiveNumbersSum(int N) {
        int result = 0;
        /**
         * 假如连续正整数从1开始，并且 1+2+3+……+n = n(1+n)/2 > n*n/2 >= N,
         * 则当 n > Math.sqrt(2 * N) 时，n个连续正整数的和一定大于N，所以最多只可能有
         * Math.sqrt(2 * N) 个连续正整数
         */
        int threshold = (int) Math.sqrt(2 * N);
        /**
         * 如果是奇数个连续正整数，并且中位数 N/i 为整数，并且最小值 N/i-(i-1)/2 > 0，
         * 这连续奇数个正整数的和可以为N
         * 如果是偶数个连续正整数，因为首尾两两相加的和是相等的，共有 i/2 对，如果每对的
         * 和为奇数（因为中位数两个数相邻和为奇数），并且最小值 N/i-(i/2-1) > 0，这连续
         * 偶数个正整数的和可以为N
         */
        for (int i = 1; i <= threshold; i++) {
            if ((i & 1) == 1 && N % i == 0 && N / i - (i - 1) / 2 > 0) {
                result++;
            } else if ((i & 1) == 0 && N % (i / 2) == 0 && ((N * 2 / i) & 1) == 1 &&
                    N / i - (i / 2 - 1) > 0) {
                result++;
            }
        }
        return result;
    }
}
