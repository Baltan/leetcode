package leetcode.algorithms;

/**
 * Description: 3765. Complete Prime Number
 *
 * @author baltan
 * @date 2026/1/27 16:54
 */
public class CompletePrime {
    public static void main(String[] args) {
        System.out.println(completePrime(23));
        System.out.println(completePrime(39));
        System.out.println(completePrime(7));
    }

    public static boolean completePrime(int num) {
        /**
         * 数字num的后缀
         */
        int suffix = 0;
        int weight = 1;
        int x = num;
        /**
         * num自身不是质数
         */
        if (!isPrime(num)) {
            return false;
        }

        while (num > 0) {
            int remainder = num % 10;
            suffix += weight * remainder;
            /**
             * suffix等于原始数字num时，不需要重复计算其是否是质数
             */
            if (suffix != x && !isPrime(suffix)) {
                return false;
            }
            num /= 10;
            weight *= 10;
            /**
             * num为0时，说明是原始数字num的空前缀，不需要判断是否是质数
             */
            if (num > 0 && !isPrime(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
