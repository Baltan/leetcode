package leetcode.algorithms;

import java.util.*;

/**
 * Description:Degree of an Array
 * @author Baltan
 *
 * @date 2017/11/7 11:29
 */
public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 1};
        int[] nums2 = {49999, 100, 2, 100, 100, 4, 100};
        System.out.println(findShortestSubArray(nums1));
        System.out.println(findShortestSubArray(nums2));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            int times = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], ++times);
        }
        int degree = 0;
        int length = list.size();
        Set eleSet = map.keySet();
        Iterator<Integer> iterator = eleSet.iterator();
        while (iterator.hasNext()) {
            int ele = iterator.next();
            if (map.get(ele) > degree) {
                degree = map.get(ele);
            }
        }
        Iterator<Integer> iterator1 = eleSet.iterator();
        while (iterator1.hasNext()) {
            int ele = iterator1.next();
            if (map.get(ele) == degree) {
                int temp = list.lastIndexOf(ele) - list.indexOf(ele);
                length = temp < length ? temp : length;
            }
        }
        return length + 1;
    }
}
