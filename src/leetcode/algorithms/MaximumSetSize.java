package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 3002. Maximum Size of a Set After Removals
 *
 * @author Baltan
 * @date 2024/1/10 22:04
 */
public class MaximumSetSize {
    public static void main(String[] args) {
        System.out.println(maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        System.out.println(maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        System.out.println(maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
    }

    public static int maximumSetSize(int[] nums1, int[] nums2) {
        int half = nums1.length / 2;
        /**
         * 只在数组num1中出现的数字
         */
        Set<Integer> set1 = new HashSet<>();
        /**
         * 只在数组num2中出现的数字
         */
        Set<Integer> set2 = new HashSet<>();
        /**
         * 在数组num1和num2中都出现的数字
         */
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            /**
             * 数字num在set1或set3中存在，说明num是在两个数组中都出现过的
             */
            if (set1.contains(num) || set3.contains(num)) {
                set3.add(num);
                set1.remove(num);
            } else {
                set2.add(num);
            }
        }
        /**
         * 1、只在数组num1中出现的数字至多可选Math.min(set1.size(),half)个互不相同的
         * 2、只在数组num2中出现的数字至多可选Math.min(set2.size(),half)个互不相同的
         * 3、除去已选的数字，数组num1还需要选Math.max(0,half-set1.size())个数字，数组num2还需要选Math.max(0,half-set1.size())个
         * 数字
         * 4、数组num1和nums2中一共至多可再选Math.min(Math.max(0,half-set1.size())+Math.max(0,half-set1.size()),set3.size())
         * 个互不相同的数字
         */
        return Math.min(set1.size(), half) + Math.min(set2.size(), half) +
                Math.min(Math.max(0, half - set1.size()) + Math.max(0, half - set2.size()), set3.size());
    }
}
