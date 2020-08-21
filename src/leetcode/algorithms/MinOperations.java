package leetcode.algorithms;

/**
 * Description: 1551. Minimum Operations to Make Array Equal
 *
 * @author Baltan
 * @date 2020-08-20 23:22
 */
public class MinOperations {
    public static void main(String[] args) {
        System.out.println(minOperations(3));
        System.out.println(minOperations(6));
    }

    public static int minOperations(int n) {
        /**
         * 所有的n个数最终值都会变为n，将这些数首尾两两配对。如果n为奇数，则最小值需要n-1次操作，小于n的最大值需
         * 要2次操作，一共有n/2个数对，即对n-1、n-3、n-5、……、2这个等差数列求和；如果n为偶数，则最小值需要n-1次
         * 操作，小于n的最大值需要1次操作，一共有n/2个数对，即对n-1、n-3、n-5、……、1这个等差数列求和
         */
        return n % 2 == 1 ? (n - 1 + 2) * (n / 2) / 2 : (n - 1 + 1) * (n / 2) / 2;
    }
}
