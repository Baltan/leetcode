package leetcode.algorithms;

/**
 * Description: 1611. Minimum One Bit Operations to Make Integers Zero
 *
 * @author Baltan
 * @date 2023/3/14 21:26
 */
public class MinimumOneBitOperations {
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(2));
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(minimumOneBitOperations(10000));
        System.out.println(minimumOneBitOperations(71683836));
        System.out.println(minimumOneBitOperations(1000000000));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-one-bit-operations-to-make-integers-zero/solutions/1388111/zhao-gui-lu-di-gui-by-a-zhu-8o-zndz/"></a>
     *
     * @param n
     * @return
     */
    public static int minimumOneBitOperations(int n) {
        if (n == 1) {
            return 1;
        }
        int offset = 0;
        /**
         * 查找大于n的最小的2的幂
         */
        while (1 << offset <= n) {
            offset++;
        }
        /**
         * 找规律：
         * n        n的二进制值      最小操作次数      n是否为2的幂
         * ---------------------------------------
         * 1        1               1               √
         * 3        11              2
         * 2        10              3               √
         * 6        110             4
         * 7        111             5
         * 5        101             6
         * 4        100             7               √
         * 12       1100            8
         * 13       1101            9
         * 15       1111            10
         * 14       1110            11
         * 10       1010            12
         * 11       1011            13
         * 9        1001            14
         * 8        1000            15              √
         * ---------------------------------------
         * 假设大于n的最小的2的幂为x=1<<offset，当n的值为2的幂时，最小操作次数为x-1；当n的值不为2的幂时，最小操作次数为
         * minimumOneBitOperations(x>>1)-minimumOneBitOperations(n-(x>>1))=x-1-minimumOneBitOperations(n-(x>>1))
         */
        int x = 1 << offset;
        return n == x >> 1 ? x - 1 : x - 1 - minimumOneBitOperations(n - (x >> 1));
    }
}
