package leetcode.algorithms;

/**
 * Description: 3622. Check Divisibility by Digit Sum and Product
 *
 * @author Baltan
 * @date 2025/8/24 16:50
 */
public class CheckDivisibility {
    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));
        System.out.println(checkDivisibility(23));
    }

    public static boolean checkDivisibility(int n) {
        /**
         * 数字n的各位数字之和
         */
        int sum = 0;
        /**
         * 数字n的各位数字之积
         */
        int product = 1;
        int m = n;

        while (m > 0) {
            int num = m % 10;
            sum += num;
            product *= num;
            m /= 10;
        }
        return n % (sum + product) == 0;
    }
}
