package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3770. Largest Prime from Consecutive Prime Sum
 *
 * @author baltan
 * @date 2026/1/29 16:09
 */
public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(largestPrime(393961));
        System.out.println(largestPrime(398771));
        System.out.println(largestPrime(1));
        System.out.println(largestPrime(20));
        System.out.println(largestPrime(2));
    }

    /**
     * 根据题意，nums[i]∈[1,500000]
     */
    private static final int MAX = 500000;
    /**
     * 升序保存[1,500000]中的所有质数
     */
    private static final List<Integer> PRIME_NUMS = new ArrayList<>();
    /**
     * IS_PRIME[i]表示数字i是否是质数
     */
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];

    /**
     * 初始化计算[1,500000]中的各个元素是否是质数
     */
    static {
        outer:
        for (int i = 2; i <= MAX; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (IS_PRIME[j] && i % j == 0) {
                    continue outer;
                }
            }
            IS_PRIME[i] = true;
            PRIME_NUMS.add(i);
        }
    }

    public static int largestPrime(int n) {
        if (n < 2) {
            return 0;
        }
        int result = 0;
        /**
         * 从2开始的所有质数之和
         */
        int sum = 0;

        for (int primeNum : PRIME_NUMS) {
            sum += primeNum;

            if (sum > n) {
                break;
            }

            if (IS_PRIME[sum]) {
                result = sum;
            }
        }
        return result;
    }
}
