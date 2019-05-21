package leetcode.algorithms;

/**
 * Description: 204. Count Primes
 *
 * @author Baltan
 * @date 2018/1/8 21:31
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(9));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(1500000));
    }

    public static int countPrimes(int n) {
        int primeNumberQuantity = 0;
        boolean[] arr = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!arr[i]) {
                for (int j = i; i * j < n; j++) {
                    arr[i * j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (arr[i] == false) {
                primeNumberQuantity++;
            }
        }
        return primeNumberQuantity;
    }
}