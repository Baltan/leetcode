package leetcode.algorithms;

/**
 * Description: 2457. Minimum Addition to Make Integer Beautiful
 *
 * @author Baltan
 * @date 2022/11/25 09:48
 */
public class MakeIntegerBeautiful {
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(16, 6));
        System.out.println(makeIntegerBeautiful(467, 6));
        System.out.println(makeIntegerBeautiful(1, 1));
        System.out.println(makeIntegerBeautiful(734504727, 10));
    }

    public static long makeIntegerBeautiful(long n, int target) {
        /**
         * 从0开始逐一尝试，直达使得n+i是一个美丽整数
         */
        for (int i = 0; ; i++) {
            if (getSum(n + i) <= target) {
                return i;
            }
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
