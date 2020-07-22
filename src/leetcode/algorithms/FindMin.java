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
        /**
         * 如果nums[lo]不大于nums[hi]，说明数组nums没有被旋转，或者说在nums[0]处进行了旋转，最小值就是nums[0]
         */
        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        }

        /**
         * 二分查找。在升序数组在中间某点旋转后大致呈现：
         *     /
         *   /
         *         /
         *       /
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            /**
             * 如果nums[mid]左右两侧的的数字都大于它，则nums[mid]就是旋转数组右半部分的左端点，也就是数组nums的最
             * 小值；如果nums[mid]大于nums[hi]，则nums[mid]在数组左半部分中，而数组最小值在数组右半部分中，所以在
             * mid右侧的子数组中继续查找；如果nums[mid]小于nums[hi]，则nums[mid]在数组右半部分中，而数组最小值为
             * 右半部分左端点且不为nums[mid]，所以在mid左侧的子数组中继续查找
             */
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
