package leetcode.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Description: 169. Majority Element
 * @author Baltan
 *
 * @date 2017/11/7 16:10
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 1, 3, 1};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int times = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], ++times);
        }
        Set<Integer> keys = map.keySet();
        Iterator<Integer> ite = keys.iterator();
        while (ite.hasNext()) {
            int ele = ite.next();
            if (map.get(ele) > nums.length / 2) {
                return ele;
            }
        }
        return 0;
    }
}
