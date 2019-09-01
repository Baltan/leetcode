package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1175. Prime Arrangements
 *
 * @author Baltan
 * @date 2019-09-01 17:29
 */
public class NumPrimeArrangements {
    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(1));
        System.out.println(numPrimeArrangements(5));
        System.out.println(numPrimeArrangements(10));
        System.out.println(numPrimeArrangements(15));
        System.out.println(numPrimeArrangements(20));
        System.out.println(numPrimeArrangements(80));
        System.out.println(numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {
        Set<Integer> primeNumbers = new HashSet<>(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                        79, 83, 89, 97));
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (primeNumbers.contains(i)) {
                count++;
            }
        }
        return (int) (help(count) * help(n - count) % 1000000007);
    }

    public static long help(int n) {
        long product = 1L;

        for (int i = 1; i <= n; i++) {
            product = (product * i) % 1000000007;
        }
        return product;
    }
}
