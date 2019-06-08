package leetcode.algorithms;

/**
 * Description: 215. Kth Largest Element in an Array
 *
 * @author Baltan
 * @date 2019-06-08 12:41
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4));

        int[] nums3 = {-1, 2, 0};
        System.out.println(findKthLargest(nums3, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        int arrLength = nums.length;
        for (int i = 1; i < arrLength; i++) {
            int currNum = nums[i];
            int j;
            for (j = i - 1; j >= 0 && nums[j] > currNum; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = currNum;
        }
        return nums[arrLength - k];
    }
}
