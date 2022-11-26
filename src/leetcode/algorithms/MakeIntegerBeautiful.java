package leetcode.algorithms;

/**
 * Description: 2457. Minimum Addition to Make Integer Beautiful
 *
 * @author Baltan
 * @date 2022/11/25 09:48
 */
public class MakeIntegerBeautiful {
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(16L, 6));
        System.out.println(makeIntegerBeautiful(467L, 6));
        System.out.println(makeIntegerBeautiful(1L, 1));
        System.out.println(makeIntegerBeautiful(734504727L, 10));
        System.out.println(makeIntegerBeautiful(6068060761L, 3));
    }

    /**
     * @param n
     * @param target
     * @return
     */
    public static long makeIntegerBeautiful(long n, int target) {
        int sum = getSum(n);

        if (sum <= target) {
            return 0;
        }
        long pow = 10L;
        /**
         * 逐一令十位、百位、千位等更高位上的值加1，同时低位的数字都变为0，因为只有这样才可能使得所有数位上数字的和更小，从而有可能小于等于
         * target。例如：n为734504727，则依次对734504730、734504800、734505000、734510000等数字进行判断
         */
        while (true) {
            long num = (n / pow + 1) * pow;

            if (getSum(num) <= target) {
                return num - n;
            }
            pow *= 10;
        }
    }

    /**
     * 计算数字num所有数位上数字的和
     *
     * @param num
     * @return
     */
    public static int getSum(long num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
