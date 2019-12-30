package leetcode.algorithms;

/**
 * Description: 1300. Sum of Mutated Array Closest to Target
 *
 * @author Baltan
 * @date 2019-12-30 12:11
 */
public class FindBestValue {
    public static void main(String[] args) {
        int[] arr1 = {4, 9, 3};
        System.out.println(findBestValue(arr1, 10));

        int[] arr2 = {2, 3, 5};
        System.out.println(findBestValue(arr2, 10));

        int[] arr3 = {60864, 25176, 27249, 21296, 20204};
        System.out.println(findBestValue(arr3, 56803));
    }

    public static int findBestValue(int[] arr, int target) {
        /**
         * 因为target大于等于1，所以value最小可能为0
         */
        int lo = 0;
        /**
         * 因为数组中的元素小于等于100000，所以value最大可能为100000
         */
        int hi = 100000;
        /**
         * 二分查找使转换后的数组和不小于target的最小的value
         */
        while (lo < hi) {
            /**
             * 假设当前的value就是mid
             */
            int mid = (lo + hi) / 2;
            int sum = sum(arr, mid);
            /**
             * 如果转换后的数组和小于target，则value的值应当大于mid；如果转换后的数组和不小于target，
             * 则value的值小于等于mid
             */
            if (sum < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 当value为lo-1时，可以使得转换后的数组和小于target且最接近target；当value为lo时，可以使得
         * 转换后的数组和不小于target且最接近target，取两者中使得转换后的数组和最接近target的value
         */
        if (target - sum(arr, lo - 1) <= sum(arr, lo) - target) {
            return lo - 1;
        } else {
            return lo;
        }
    }

    /**
     * 对转换后的数组中的所有元素求和
     *
     * @param arr
     * @param value
     * @return
     */
    public static int sum(int[] arr, int value) {
        int sum = 0;

        for (int num : arr) {
            sum += Math.min(num, value);
        }
        return sum;
    }
}
