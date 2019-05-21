package leetcode.algorithms;

/**
 * Description: 88. Merge Sorted Array
 * @author Baltan
 *
 * @date 2017/11/11 19:30
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums11 = {0};
        int m1 = 0;
        int[] nums21 = {1};
        int n1 = 0;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = m + n - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;
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
