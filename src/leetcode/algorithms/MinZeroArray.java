package leetcode.algorithms;

/**
 * Description: 3356. Zero Array Transformation II
 *
 * @author Baltan
 * @date 2024/11/20 23:34
 * @see IsZeroArray
 */
public class MinZeroArray {
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        System.out.println(minZeroArray(nums1, queries1));

        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {{1, 3, 2}, {0, 2, 1}};
        System.out.println(minZeroArray(nums2, queries2));

        int[] nums3 = {7, 6, 8};
        int[][] queries3 = {{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}};
        System.out.println(minZeroArray(nums3, queries3));
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        /**
         * 假设存在数组x，其中x[i]表示数组nums中元素nums[i]最多可以被减去的值。数组diffs为x的差分数组，其中diffs[0]=x[0],
         * diff[1]=x[1]-x[0],diff[2]=x[2]-x[1],……,diff[i]=x[i]-x[i-1]
         */
        int[] diffs = getDiffs(queries, queries.length, nums.length + 1);

        if (!check(diffs, nums)) {
            return -1;
        }
        int lo = 0;
        int hi = queries.length;
        /**
         * 二分查找使得数组nums变为零数组所需的最少操作次数
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            diffs = getDiffs(queries, mid, nums.length + 1);

            if (check(diffs, nums)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 假设存在数组x，其中x[i]表示数组nums中元素nums[i]最多可以被减去的值，计算数组x的差分数组
     *
     * @param queries
     * @param count   可以对数组nums进行数组queries中的前count次操作
     * @param length  差分数组diffs的长度
     * @return
     */
    public static int[] getDiffs(int[][] queries, int count, int length) {
        int[] diffs = new int[length];

        for (int i = 0; i < count; i++) {
            /**
             * 对于query，数组nums中索引值在[query[0],query[1]]区间内的元素最多都可以被减去query[2]
             */
            int[] query = queries[i];
            diffs[query[0]] += query[2];
            diffs[query[1] + 1] -= query[2];
        }
        return diffs;
    }

    /**
     * 通过差分数组diffs，判断数组nums能否变为零数组
     *
     * @param diffs
     * @param nums
     * @return
     */
    public static boolean check(int[] diffs, int[] nums) {
        int sum = 0;
        /**
         * 如果存在某个元素nums[i]，最多可以被减去的值小于nums[i]，则最终该元素无法变成0，直接返回false
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * 元素nums[i]最多可以减去的值
             */
            sum += diffs[i];

            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
