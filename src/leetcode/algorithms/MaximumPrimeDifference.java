package leetcode.algorithms;

/**
 * Description: 3115. Maximum Prime Difference
 *
 * @author Baltan
 * @date 2024/4/17 22:03
 */
public class MaximumPrimeDifference {
    public static void main(String[] args) {
        System.out.println(maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        System.out.println(maximumPrimeDifference(new int[]{4, 8, 2, 8}));
    }

    public static int maximumPrimeDifference(int[] nums) {
        /**
         * isPrime[num]表示数字num是否是质数，根据题意num=nums[i]∈[1,100]
         */
        boolean[] isPrime = new boolean[101];
        /**
         * 数组nums中第一个质数的索引值
         */
        int first = -1;
        /**
         * 数组nums中最后一个质数的索引值
         */
        int last = -1;
        /**
         * 依次判断[2,100]中的每个数字是否是质数
         */
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                isPrime[i] = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (isPrime[nums[i]]) {
                first = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (isPrime[nums[i]]) {
                last = i;
                break;
            }
        }
        return last - first;
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
