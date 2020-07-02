package leetcode.algorithms;

/**
 * Description: 1497. Check If Array Pairs Are Divisible by k
 *
 * @author Baltan
 * @date 2020-07-02 19:15
 */
public class CanArrange {
    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        System.out.println(canArrange(new int[]{-10, 10}, 2));
        System.out.println(canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 5));
    }

    public static boolean canArrange(int[] arr, int k) {
        /**
         * count[i]表示除以k余数为i的数字的个数
         */
        int[] count = new int[k];

        for (int value : arr) {
            if (value < 0) {
                /**
                 * 如果value是负数，将value先加上若干个k使其变为正数后再计算value除以k的余数
                 */
                value += (1 - value / k) * k;
                count[value % k]++;
            } else {
                count[value % k]++;
            }
        }

        for (int i = 1; i < k; i++) {
            /**
             * 如果余数i正好是k的二分之一，则count[i]个除以k余数为i的数两两组合相加可以被k整除，所以如果count[i]不
             * 为偶数，就不存在题目要求的分法
             */
            if (i == k - i && count[i] % 2 != 0) {
                return false;
            }
            /**
             * 每个除以k余数为i的数和除以k余数为k-i的数相加之和可以被k整除，所以如果count[i]和count[k-i]不相等，就
             * 不存在题目要求的分法
             */
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return true;
    }
}
