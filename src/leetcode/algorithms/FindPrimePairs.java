package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 6916. Prime Pairs With Target Sum
 *
 * @author Baltan
 * @date 2023/7/2 15:57
 */
public class FindPrimePairs {
    public static void main(String[] args) {
        System.out.println(findPrimePairs(999958));
        System.out.println(findPrimePairs(10));
        System.out.println(findPrimePairs(2));
        System.out.println(findPrimePairs(1));
        System.out.println(findPrimePairs(1000000));
    }

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 如果n为奇数，如果n能被分成两个质数的和，则只可能为2和另一个奇数
         */
        if (n % 2 == 1) {
            if (isPrime(n - 2)) {
                result.add(Arrays.asList(2, n - 2));
            }
            return result;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                result.add(Arrays.asList(i, n - i));
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
        if (num < 2) {
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
