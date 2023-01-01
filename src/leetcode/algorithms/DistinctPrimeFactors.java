package leetcode.algorithms;

/**
 * Description: 2521. Distinct Prime Factors of Product of Array
 *
 * @author Baltan
 * @date 2023/1/1 13:24
 */
public class DistinctPrimeFactors {
    public static void main(String[] args) {
        System.out.println(distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6}));
        System.out.println(distinctPrimeFactors(new int[]{2, 4, 8, 16}));
    }

    public static int distinctPrimeFactors(int[] nums) {
        int result = 0;
        /**
         * 根据题意，nums[i]∈[2,1000]
         */
        int max = 1000;

        for (int i = 2; i <= max; i++) {
            if (!isPrime(i)) {
                continue;
            }
            /**
             * 判断数组nums中是否有某个数字含有质因数i
             */
            for (int num : nums) {
                if (num % i == 0) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
