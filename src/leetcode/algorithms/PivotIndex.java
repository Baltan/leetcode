package leetcode.algorithms;

/**
 * Description: 724. Find Pivot Index
 * @author Baltan
 *
 * @date 2017/11/12 16:06
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
    }

    public static int pivotIndex(int[] nums) {
        int sumAll = 0;
        for (int i = 0; i < nums.length; i++) {
            sumAll += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];
            }
            if (sumLeft * 2 + nums[i] == sumAll) {
                return i;
            }
        }
        return -1;
    }
}
