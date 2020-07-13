package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.LinkedList;
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
        OutputUtils.print1DIntegerArray(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        /**
         * 将nums1和nums2都进行升序排列
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        /**
         * 双指针，如果当前nums1和nums2指向的数字相同，则将该数字加入到交集中，同时向后移动两个指针；否则向后移动指向
         * 较小数字的指针
         */
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int size = list.size();
        int index = 0;
        int[] result = new int[size];

        for (int value : list) {
            result[index++] = value;
        }
        return result;
    }
}
