package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: 349. Intersection of Two Arrays
 *
 * @author Baltan
 * @date 2018/1/2 16:20
 */
public class Intersection {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> intersectionList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersectionList.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] intersectionArray = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            intersectionArray[i] = intersectionList.get(i);
        }
        return intersectionArray;
    }
}
