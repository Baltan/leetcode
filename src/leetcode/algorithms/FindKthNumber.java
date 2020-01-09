package leetcode.algorithms;

/**
 * Description: 668. Kth Smallest Number in Multiplication Table
 *
 * @author Baltan
 * @date 2020-01-08 11:50
 */
public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(findKthNumber(3, 3, 5));
        System.out.println(findKthNumber(2, 3, 6));
        System.out.println(findKthNumber(12, 12, 17));
        System.out.println(findKthNumber(30000, 30000, 1343113));
        System.out.println(findKthNumber(30000, 30000, 76372));
        System.out.println(findKthNumber(30000, 30000, 9999));
        System.out.println(findKthNumber(42, 34, 401));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/er-fen-cha-zhao-by-jason-2-5/"></a>
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        /**
         * 二分查找m*n的乘法表中第k小的数字
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = getCount(m, n, mid);
            /**
             * 如果比count比k小，则所求值一定比mid大，但是如果count和k相等，mid不一定是所求值，因为
             * 可能乘法表中根本就没有mid这个乘积，需要继续查找更小的值进行计算
             */
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    /**
     * m*n的乘法表中不大于threshold的数字的个数
     *
     * @param m
     * @param n
     * @param threshold
     * @return
     */
    public static int getCount(int m, int n, int threshold) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            count += Math.min(m, threshold / i);
        }
        return count;
    }
}
