package leetcode.algorithms;

/**
 * Description: 3370. Smallest Number With All Set Bits
 *
 * @author Baltan
 * @date 2024/12/5 22:53
 */
public class SmallestNumber3 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(1));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(3));
    }

    public static int smallestNumber(int n) {
        /**
         * 只包含置位位的整数都为2的幂减1，从小到大枚举符合条件的数
         */
        for (int i = 0; ; i++) {
            int num = (1 << i) - 1;

            if ((num >= n)) {
                return num;
            }
        }
    }
}
