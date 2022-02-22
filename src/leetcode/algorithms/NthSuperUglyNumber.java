package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 313. Super Ugly Number
 *
 * @author Baltan
 * @date 2019-06-20 10:40
 * @see NthUglyNumber
 * @see leetcode.interview.GetKthMagicNumber
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
        /**
         * 数组中的length个元素代表丑数序列中的不同丑数的length个索引位置
         */
        int[] indexArray = new int[length];
        int value = 1;
        list.add(1);

        while (list.size() < n) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < length; i++) {
                /**
                 * 沿着丑数序列，将每个丑数乘以primes[i]，直到找到不小于value的丑数
                 */
                while (list.get(indexArray[i]) * primes[i] < value) {
                    indexArray[i]++;
                }
                /**
                 * 找到以上i个不小于value的丑数的最小值
                 */
                min = Math.min(min, list.get(indexArray[i]) * primes[i]);
            }
            /**
             * 将新找到的丑数加入到丑数序列中
             */
            list.add(min);
            /**
             * 将value改为新找到的丑数加1，查找的下一个丑数必然不小于这个值
             */
            value = min + 1;
        }
        return list.get(n - 1);
    }
}
