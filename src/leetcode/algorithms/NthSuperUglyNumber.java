package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 313. Super Ugly Number
 *
 * @author Baltan
 * @date 2019-06-20 10:40
 */
public class NthSuperUglyNumber {
    public static void main(String[] args) {
        int[] prime1 = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(1, prime1));
        System.out.println(nthSuperUglyNumber(2, prime1));
        System.out.println(nthSuperUglyNumber(3, prime1));
        System.out.println(nthSuperUglyNumber(4, prime1));
        System.out.println(nthSuperUglyNumber(5, prime1));
        System.out.println(nthSuperUglyNumber(6, prime1));
        System.out.println(nthSuperUglyNumber(7, prime1));
        System.out.println(nthSuperUglyNumber(8, prime1));
        System.out.println(nthSuperUglyNumber(9, prime1));
        System.out.println(nthSuperUglyNumber(10, prime1));
        System.out.println(nthSuperUglyNumber(11, prime1));
        System.out.println(nthSuperUglyNumber(12, prime1));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new ArrayList<>();
        int length = primes.length;
        int[] indexArray = new int[length];
        int value = 1;

        list.add(1);

        while (list.size() < n) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < length; i++) {
                while (list.get(indexArray[i]) * primes[i] < value) {
                    indexArray[i]++;
                }
                min = Math.min(min, list.get(indexArray[i]) * primes[i]);
            }

            list.add(min);
            value = min + 1;
        }
        return list.get(n - 1);
    }
}
