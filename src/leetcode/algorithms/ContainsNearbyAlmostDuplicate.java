package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 220. Contains Duplicate III
 *
 * @author Baltan
 * @date 2019-06-11 10:13
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums1, 3, 0));

        int[] nums2 = {1, 0, 1, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums2, 1, 2));

        int[] nums3 = {1, 5, 9, 1, 5, 9};
        System.out.println(containsNearbyAlmostDuplicate(nums3, 2, 3));

        int[] nums4 = {-2147483648, -2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums4, 3, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }

        int length = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < length; i++) {
            long bottom = (long) nums[i] - t;
            long top = (long) nums[i] + t;
            Long v1 = set.ceiling(bottom);
            Long v2 = set.floor(top);

            if (v1 != null && v1 <= nums[i]) {
                return true;
            }

            if (v2 != null && v2 >= nums[i]) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= k) {
                set.remove(new Long(nums[i - k]));
            }
        }
        return false;
    }
}
