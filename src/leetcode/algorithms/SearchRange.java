package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 34. Find First and Last Position of Element in Sorted Array
 *
 * @author Baltan
 * @date 2019-05-17 09:08
 */
public class SearchRange {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5));
        OutputUtils.print1DIntegerArray(
                searchRange(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 9}, 5));
        OutputUtils.print1DIntegerArray(
                searchRange(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 9}, 4));
        OutputUtils.print1DIntegerArray(
                searchRange(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 9}, 1));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{1, 1}, 2));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{1, 1}, 1));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{3}, 3));
        OutputUtils.print1DIntegerArray(searchRange(new int[]{3}, 1));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        int lo = 0;
        int hi = length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                result[0] = result[1] = mid;
                int leftmost = findLeft(nums, 0, mid - 1, target);
                int rightmost = findRight(nums, mid + 1, hi, target);

                if (leftmost != -1) {
                    result[0] = leftmost;
                }

                if (rightmost != -1) {
                    result[1] = rightmost;
                }
                break;
            } else if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    /**
     * 查找左端点
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int findLeft(int[] nums, int start, int end, int target) {
        int result = -1;
        int lo = start;
        int hi = end;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                result = mid;
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    /**
     * 查找右端点
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int findRight(int[] nums, int start, int end, int target) {
        int result = -1;
        int lo = start;
        int hi = end;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                result = mid;
                lo = mid + 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}
