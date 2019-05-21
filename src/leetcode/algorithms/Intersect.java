package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 350. Intersection of Two Arrays II
 *
 * @author Baltan
 * @date 2018/1/4 14:32
 */
public class Intersect {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> nums1List = new ArrayList<>();
        List<Integer> intersectList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1List.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums1List.contains(nums2[i])) {
                intersectList.add(nums2[i]);
                nums1List.remove(new Integer(nums2[i]));
            }
        }
        int[] intersectArray = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            intersectArray[i] = intersectList.get(i);
        }
        return intersectArray;
    }
}
