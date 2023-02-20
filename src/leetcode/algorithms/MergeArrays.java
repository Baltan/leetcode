package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2570. Merge Two 2D Arrays by Summing Values
 *
 * @author Baltan
 * @date 2023/2/20 09:48
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[][] nums11 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums12 = {{1, 4}, {3, 2}, {4, 1}};
        OutputUtils.print2DIntegerArray(mergeArrays(nums11, nums12));

        System.out.println("---------------------------------------");

        int[][] nums21 = {{2, 4}, {3, 6}, {5, 5}};
        int[][] nums22 = {{1, 3}, {4, 3}};
        OutputUtils.print2DIntegerArray(mergeArrays(nums21, nums22));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        /**
         * 双指针，如果两个指针指向的数组id相同，则合并两个数组，将它们的val相加，否则取id较小的那个数组
         */
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1][0] == nums2[index2][0]) {
                    nums1[index1][1] += nums2[index2][1];
                    result.add(nums1[index1]);
                    index1++;
                    index2++;
                } else if (nums1[index1][0] < nums2[index2][0]) {
                    result.add(nums1[index1]);
                    index1++;
                } else {
                    result.add(nums2[index2]);
                    index2++;
                }
            } else if (index1 < nums1.length) {
                result.add(nums1[index1]);
                index1++;
            } else {
                result.add(nums2[index2]);
                index2++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
