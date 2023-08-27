package leetcode.algorithms;

/**
 * Description: 2834. Find the Minimum Possible Sum of a Beautiful Array
 *
 * @author Baltan
 * @date 2023/8/27 14:14
 * @see 2829. Determine the Minimum Sum of a k-avoiding Array
 */
public class MinimumPossibleSum {
    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(2, 3));
        System.out.println(minimumPossibleSum(3, 3));
        System.out.println(minimumPossibleSum(1, 1));
    }

    public static long minimumPossibleSum(int n, int target) {
        if (n <= target / 2) {
            /**
             * 数组中的元素为[1,2,3,……,n-1,n]
             */
            return (long) n * (1 + n) / 2;
        }
        /**
         * 数组的第一部分元素的最大值，即[1,x]
         */
        int x = target / 2;
        /**
         * 数组的第二部分元素的最大值，即[target,y]
         */
        int y = target + (n - x) - 1;
        /**
         * 数组中的元素为[1,2,3,……,x-1,x,target,target+1,target+2,……,y-1,y]
         */
        return (long) (1 + x) * x / 2 + (long) (target + y) * (n - x) / 2;
    }
}
