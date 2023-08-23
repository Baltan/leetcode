package leetcode.algorithms;

/**
 * Description: 2829. Determine the Minimum Sum of a k-avoiding Array
 *
 * @author baltan
 * @date 2023/8/23 11:08
 */
public class MinimumSum1 {
    public static void main(String[] args) {
        System.out.println(minimumSum(5, 4));
        System.out.println(minimumSum(2, 6));
        System.out.println(minimumSum(7, 19));
        System.out.println(minimumSum(7, 13));
    }

    public static int minimumSum(int n, int k) {
        if (n <= k / 2) {
            /**
             * 数组中的元素为[1,2,3,……,n-1,n]
             */
            return n * (1 + n) / 2;
        }
        /**
         * 数组的第一部分元素的最大值，即[1,x]
         */
        int x = k / 2;
        /**
         * 数组的第二部分元素的最大值，即[k,y]
         */
        int y = k + (n - x) - 1;
        /**
         * 数组中的元素为[1,2,3,……,x-1,x,k,k+1,k+2,……,y-1,y]
         */
        return (1 + x) * x / 2 + (k + y) * (n - x) / 2;
    }
}
