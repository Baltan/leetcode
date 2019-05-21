package leetcode.algorithms;

/**
 * Description: 33. Search in Rotated Sorted Array
 *
 * @author Baltan
 * @date 2019-05-16 21:49
 */
public class Search1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{5, 6, 7, 0, 1, 2, 4}, 0));
        System.out.println(search(new int[]{6, 7, 0, 1, 2, 4, 5}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
