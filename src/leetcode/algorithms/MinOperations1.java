package leetcode.algorithms;

/**
 * Description: 1558. Minimum Numbers of Function Calls to Make Target Array
 *
 * @author Baltan
 * @date 2020-09-01 22:54
 */
public class MinOperations1 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 5}));
        System.out.println(minOperations(new int[]{2, 2}));
        System.out.println(minOperations(new int[]{4, 2, 5}));
        System.out.println(minOperations(new int[]{3, 2, 2, 4}));
        System.out.println(minOperations(new int[]{2, 4, 8, 16}));
        System.out.println(minOperations(new int[]{1000000000}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        /**
         * 记录乘以2次数最多的一个数进行乘以2操作的次数，因为乘以2操作是对所有数字同时进行的，所以只需计算最多次
         * 数即可
         */
        int maxDoubleCount = Integer.MIN_VALUE;
        /**
         * 依次将所有数字通过逆向的除以2和减1操作还原成0，只需计算减1的次数即可
         */
        for (int num : nums) {
            /**
             * 当前数字num还原为0的过程中除以2的次数
             */
            int doubleCount = 0;
            /**
             * 逢奇数减1，逢偶数除以2，直到数字变为0
             */
            while (num != 0) {
                if (num % 2 == 0) {
                    num /= 2;
                    doubleCount++;
                } else {
                    num--;
                    /**
                     * 只需计算减1的次数
                     */
                    result++;
                }
            }
            maxDoubleCount = Math.max(maxDoubleCount, doubleCount);
        }
        /**
         * 计算乘以2的次数
         */
        result += maxDoubleCount;
        return result;
    }
}
