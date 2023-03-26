package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2602. Minimum Operations to Make All Array Elements Equal
 *
 * @author Baltan
 * @date 2023/3/26 12:55
 */
public class MinOperations12 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
        System.out.println(minOperations(new int[]{2, 9, 6, 3}, new int[]{10}));
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> result = new ArrayList<>(queries.length);
        int length = nums.length;
        /**
         * 排序后数组nums的前缀和
         */
        long[] prefixSums = new long[length + 1];
        Arrays.sort(nums);
        /**
         * 计算排序后数组nums的前缀和
         */
        for (int i = 1; i <= length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        for (int query : queries) {
            int ceilIndex = getCeilIndex(nums, query);
            int floorIndex = getFloorIndex(nums, query);

            if (ceilIndex == -1 && floorIndex == -1) {
                /**
                 * 数组nums中所有元素都等于query，不需要进行任何操作
                 */
                result.add(0L);
            } else if (ceilIndex == -1) {
                /**
                 * 数组nums中所有元素都大于等于query，只需要对大于query的元素进行-1操作。所有大于query的元素之和为prefixSums[length]-
                 * prefixSums[floorIndex]，需要将这部分元素之和操作为query*(length-floorIndex)
                 */
                long decreaseTimes = prefixSums[length] - prefixSums[floorIndex] - (long) query * (length - floorIndex);
                result.add(decreaseTimes);
            } else if (floorIndex == -1) {
                /**
                 * 数组nums中所有元素都小于等于query，只需要对小于query的元素进行+1操作。所有小于query的元素之和为query*(ceilIndex+1)，
                 * 需要将这部分元素之和操作为prefixSums[ceilIndex+1]
                 */
                long increaseTimes = (long) query * (ceilIndex + 1) - prefixSums[ceilIndex + 1];
                result.add(increaseTimes);
            } else {
                /**
                 * 数组nums中既有大于query的元素，也有小于query的元素，所有小于query的元素之和为query*(ceilIndex+1)，需要将这部分元素
                 * 之和操作为prefixSums[ceilIndex+1]；所有大于query的元素之和为prefixSums[length]-prefixSums[floorIndex]，需要
                 * 将这部分元素之和操作为query*(length-floorIndex)
                 */
                long increaseTimes = (long) query * (ceilIndex + 1) - prefixSums[ceilIndex + 1];
                long decreaseTimes = prefixSums[length] - prefixSums[floorIndex] - (long) query * (length - floorIndex);
                result.add(increaseTimes + decreaseTimes);
            }
        }
        return result;
    }

    /**
     * 在数组nums中二分查找小于query的最大元素的索引
     *
     * @param nums
     * @param query
     * @return
     */
    private static int getCeilIndex(int[] nums, int query) {
        if (nums[0] >= query) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (nums[mid] >= query) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    /**
     * 在数组nums中二分查找大于query的最小元素的索引
     *
     * @param nums
     * @param query
     * @return
     */
    private static int getFloorIndex(int[] nums, int query) {
        if (nums[nums.length - 1] <= query) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] <= query) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
