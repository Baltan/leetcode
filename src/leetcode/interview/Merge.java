package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 10.01. 合并排序的数组
 *
 * @author Baltan
 * @date 2017/11/11 19:30
 * @see leetcode.algorithms.Merge
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums21 = {2, 5, 6};
        int n1 = 3;
        merge(nums11, m1, nums21, n1);
        OutputUtils.print1DIntegerArray(nums11);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = m + n - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        /**
         * 分别从后向前遍历nums1和nums2，取nums1[i]或nums2[j]较大值或剩下的唯一一个值从后
         * 向前填充nums1即可
         */
        while (mergeIndex >= 0) {
            if (nums1Index >= 0 && nums2Index >= 0) {
                if (nums1[nums1Index] >= nums2[nums2Index]) {
                    nums1[mergeIndex] = nums1[nums1Index];
                    nums1Index--;
                } else {
                    nums1[mergeIndex] = nums2[nums2Index];
                    nums2Index--;
                }
            } else if (nums1Index >= 0) {
                nums1[mergeIndex] = nums1[nums1Index];
                nums1Index--;
            } else if (nums2Index >= 0) {
                nums1[mergeIndex] = nums2[nums2Index];
                nums2Index--;
            }
            mergeIndex--;
        }
    }
}
