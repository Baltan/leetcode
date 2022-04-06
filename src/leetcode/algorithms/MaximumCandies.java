package leetcode.algorithms;

/**
 * Description: 2226. Maximum Candies Allocated to K Children
 *
 * @author Baltan
 * @date 2022/4/5 14:16
 */
public class MaximumCandies {
    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{5, 8, 6}, 3));
        System.out.println(maximumCandies(new int[]{2, 5}, 11));
    }

    public static int maximumCandies(int[] candies, long k) {
        /**
         * 糖果总数
         */
        long sum = 0L;

        for (int candy : candies) {
            sum += candy;
        }

        if (sum < k) {
            return 0;
        }
        /**
         * 每个孩子最少可能分到的糖果数
         */
        long min = 0;
        /**
         * 每个孩子最多可能分到的糖果数
         */
        long max = sum / k;
        /**
         * 二分查找每个孩子可能分到的最大糖果数
         */
        while (min < max) {
            /**
             * 向上取整
             */
            long mid = (min + max + 1) / 2;
            /**
             * 当每个孩子分到的糖果数为mid时，所有糖果可以分得的最大堆数
             */
            long piles = 0;

            for (int candy : candies) {
                piles += candy / mid;
            }

            if (piles >= k) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return (int) min;
    }
}
