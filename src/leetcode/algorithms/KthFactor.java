package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1492. The kth Factor of n
 *
 * @author Baltan
 * @date 2020-06-28 20:27
 */
public class KthFactor {
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));
        System.out.println(kthFactor(7, 2));
        System.out.println(kthFactor(4, 4));
        System.out.println(kthFactor(1, 1));
        System.out.println(kthFactor(1000, 3));
    }

    public static int kthFactor(int n, int k) {
        int squareRoot = (int) Math.sqrt(n);
        /**
         * 升序保存[1,squareRoot]中n的因子
         */
        List<Integer> factors = new ArrayList<>();
        /**
         * 查找[1,squareRoot]中n的因子
         */
        for (int i = 1; i <= squareRoot; i++) {
            if (n % i == 0) {
                factors.add(i);
                /**
                 * 如果从小到大找到了第k个因子，直接返回
                 */
                if (factors.size() == k) {
                    return i;
                }
            }
        }

        int size = factors.size();
        /**
         * 如果n是个平方数，则n共有size*2-1个因子，否则n有size*2个因子。如果n的因子数不足k个，返回-1
         */
        if (Math.pow(factors.get(size - 1), 2) == n && size * 2 - 1 >= k) {
            /**
             * n的第k个因子和n的第size*2-1-k个因子的乘积为n，所以返回n/factors.get(size*2-1-k)
             */
            return n / factors.get(size * 2 - 1 - k);
        } else if (Math.pow(factors.get(size - 1), 2) != n && size * 2 >= k) {
            /**
             * n的第k个因子和n的第size*2-k个因子的乘积为n，所以返回n/factors.get(size*2-k)
             */
            return n / factors.get(size * 2 - k);
        }
        return -1;
    }
}
