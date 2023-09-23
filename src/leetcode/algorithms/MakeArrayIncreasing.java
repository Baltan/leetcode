package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1187. Make Array Strictly Increasing
 *
 * @author Baltan
 * @date 2023/9/23 17:26
 */
public class MakeArrayIncreasing {
    public static void main(String[] args) {
        System.out.println(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 3, 2, 4}));
        System.out.println(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{4, 3, 1}));
        System.out.println(makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 6, 3, 3}));
    }

    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int length = arr1.length;
        /**
         * dp[i][j]表示前缀数组[arr1[0],arr1[1],……,arr1[i]]在进行j次操作后，使得其严格递增的情况下最后一个元素可以得到的最小值
         */
        int[][] dp = new int[length][length + 1];
        Arrays.sort(arr2);
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        /**
         * 对于长度为1的前缀数组[arr1[0]]，如果不进行操作，则最后一个元素的最小值就是其自身
         */
        dp[0][0] = arr1[0];
        /**
         * 如果进行一次操作，则可以将arr1[0]替换为数组arr2中的最小值arr2[0]，则最后一个元素的最小值就是arr2[0]
         */
        dp[0][1] = arr2[0];

        for (int i = 1; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            /**
             * 对于当前前缀数组[arr1[0],……,arr1[i]]，如果不进行操作就能保证其严格递增，则必须保证arr1[i]大于dp[i-1][0]，此时前缀数组
             * 最后一个元素的最小值就是arr1[i]
             */
            if (arr1[i] > dp[i - 1][0]) {
                dp[i][0] = arr1[i];
            }

            for (int j = 1; j <= i + 1; j++) {
                /**
                 * 对于当前前缀数组[arr1[0],……,arr1[i]]，如果进行j次操作能保证其严格递增，在不对arr1[i]进行替换的基础上，必须保证
                 * arr1[i]大于dp[i-1][j]，此时前缀数组最后一个元素的最小值就是arr1[i]
                 */
                if (arr1[i] > dp[i - 1][j]) {
                    dp[i][j] = arr1[i];
                }
                /**
                 * 在对arr1[i]进行替换的基础上，在数组arr[2]中找到大于dp[i-1][j-1]的最小值，如果存在最小值则判断是否可以减小dp[i][j]
                 */
                int index = binarySearch(arr2, dp[i - 1][j - 1]);

                if (index != -1) {
                    dp[i][j] = Math.min(dp[i][j], arr2[index]);
                }
            }
        }
        /**
         * 在保证数组arr1严格递增的情况下，取最小的操作次数
         */
        for (int j = 0; j <= length; j++) {
            if (dp[length - 1][j] != Integer.MAX_VALUE) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 在数组arr中找到第一个大于num的元素的索引，如果没有则返回-1
     *
     * @param arr
     * @param num
     * @return
     */
    public static int binarySearch(int[] arr, int num) {
        /**
         * 数组中所有数字都不大于num，直接返回-1；
         */
        if (arr[arr.length - 1] <= num) {
            return -1;
        }
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] > num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
