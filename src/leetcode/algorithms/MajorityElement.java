package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 169. Majority Element
 *
 * @author Baltan
 * @date 2017/11/7 16:10
 * @see MajorityElement1
 * @see leetcode.interview.MajorityElement
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 1, 3, 1};
        System.out.println(majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            int times = map.getOrDefault(num, 0) + 1;

            if (times > half) {
                return num;
            }
            map.put(num, times);
        }
        return -1;
    }
}
