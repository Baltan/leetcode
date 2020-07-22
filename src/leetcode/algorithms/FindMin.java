package leetcode.algorithms;

/**
 * Description: 153. Find Minimum in Rotated Sorted Array
 *
 * @author Baltan
 * @date 2019-06-01 20:10
 * @see FindMin1
 * @see leetcode.interview.MinArray
 */
public class FindMin {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2, 4, 5, 6, 7, 0}));
        System.out.println(findMin(new int[]{2, 4, 5, 6, 7, 0, 1}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{5, 6, 7, 0, 1, 2, 4}));
        System.out.println(findMin(new int[]{6, 7, 0, 1, 2, 4, 5}));
        System.out.println(findMin(new int[]{7, 0, 1, 2, 4, 5, 6}));
        System.out.println(findMin(new int[]{1, 2, 4, 5, 6, 0}));
        System.out.println(findMin(new int[]{2, 4, 5, 6, 0, 1}));
        System.out.println(findMin(new int[]{4, 5, 6, 0, 1, 2}));
        System.out.println(findMin(new int[]{5, 6, 0, 1, 2, 4}));
        System.out.println(findMin(new int[]{6, 0, 1, 2, 4, 5}));
        System.out.println(findMin(new int[]{0, 1, 2, 4, 5, 6}));
        System.out.println(findMin(new int[]{0}));
        System.out.println(findMin(new int[]{0, 1}));
        System.out.println(findMin(new int[]{1, 0}));
        System.out.println(findMin(new int[]{2, 1, 0}));
    }

    public static int findMin(int[] nums) {
        int length = nums.length;
        int lo = 0;
        int hi = length - 1;

        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid - 1 >= 0 && mid + 1 < length && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo];
    }
}
