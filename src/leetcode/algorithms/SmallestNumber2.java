package leetcode.algorithms;

/**
 * Description: 3345. Smallest Divisible Digit Product I
 *
 * @author Baltan
 * @date 2024/11/14 23:29
 */
public class SmallestNumber2 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(10, 2));
        System.out.println(smallestNumber(15, 3));
    }

    public static int smallestNumber(int n, int t) {
        /**
         * 从n开始递增，判断每个数字是否符合题意
         */
        for (int i = n; ; i++) {
            /**
             * 数字i各个数位上数字的乘积
             */
            int product = 1;
            int j = i;

            while (j > 0) {
                product *= j % 10;
                j /= 10;

                if (product % t == 0) {
                    return i;
                }
            }
        }
    }
}
