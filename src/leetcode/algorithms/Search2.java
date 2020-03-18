package leetcode.algorithms;

/**
 * Description: 81. Search in Rotated Sorted Array II
 *
 * @author Baltan
 * @date 2019-05-18 17:30
 * @see Search
 * @see Search1
 * @see leetcode.interview.Search
 */
public class Search2 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search(new int[]{3, 3, 3, 3, 3, 1, 2}, 3));
        System.out.println(search(new int[]{3, 3, 3, 3, 3, 1, 2}, 1));
        System.out.println(search(new int[]{3, 1, 2, 3, 3, 3, 3}, 3));
        System.out.println(search(new int[]{3, 1, 2, 3, 3, 3, 3}, 1));
    }

    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[lo] == nums[mid]) {
                lo++;
            } else if (nums[mid] >= nums[lo]) {
                /**
                 * 如果nums[mid]>=nums[lo]，则前半段是单调递增的。如果nums[lo]<=target<nums[mid]，则
                 * 前半段中可能会存在target，在前半段中继续二分搜索，否则在后半段中继续二分搜索
                 */
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                /**
                 * 如果nums[mid]<nums[lo]，则后半段是单调递增的。如果nums[mid]<target<=nums[hi]，则后
                 * 半段中可能会存在target，在后半段中继续二分搜索，否则在前半段中继续二分搜索
                 */
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
