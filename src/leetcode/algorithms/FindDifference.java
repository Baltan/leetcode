package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 2215. Find the Difference of Two Arrays
 *
 * @author Baltan
 * @date 2022/3/29 22:10
 */
public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>(2);
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        /**
         * 筛选set1中有set2中没有的数字
         */
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        /**
         * 筛选set2中有set1中没有的数字
         */
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}
