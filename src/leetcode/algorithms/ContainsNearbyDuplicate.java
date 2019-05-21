package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 219. Contains Duplicate II
 * @author Baltan
 *
 * @date 2017/11/10 11:15
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {99, 99};
        int[] nums3 = {1};
        int[] nums4 = {2, 2};
        int[] nums5 = {1, 0, 1, 1};
        int k1 = 0;
        int k2 = 2;
        int k3 = 1;
        int k4 = 3;
        int k5 = 1;
        System.out.println(containsNearbyDuplicate(nums1, k1));
        System.out.println(containsNearbyDuplicate(nums2, k2));
        System.out.println(containsNearbyDuplicate(nums3, k3));
        System.out.println(containsNearbyDuplicate(nums4, k4));
        System.out.println(containsNearbyDuplicate(nums5, k5));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null || i - value > k) {
                map.put(nums[i], i);
            } else if (value != null && i - value <= k) {
                return true;
            }
        }
        return false;
    }
}
