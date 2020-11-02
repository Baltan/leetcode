package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashSet;
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
        /**
         * 保存nums1和nums2的交集的元素
         */
        Set<Integer> intersectionSet = new HashSet<>();
        /**
         * 保存nums1中的所有元素
         */
        Set<Integer> set = new HashSet<>();

        for (int value : nums1) {
            set.add(value);
        }

        for (int value : nums2) {
            /**
             * 如果value在nums1中也存在，并且还没有被加入到intersectionSet中，才将value加入到intersectionSet中
             */
            if (set.contains(value) && !intersectionSet.contains(value)) {
                intersectionSet.add(value);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;

        for (int value : intersectionSet) {
            result[index++] = value;
        }
        return result;
    }
}
