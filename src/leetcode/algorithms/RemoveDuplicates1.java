package leetcode.algorithms;

/**
 * Description: 80. Remove Duplicates from Sorted Array II
 *
 * @author Baltan
 * @date 2019-03-25 15:23
 */
public class RemoveDuplicates1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums1));
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums2));
        int[] nums3 = {0, 0, 1, 1};
        System.out.println(removeDuplicates(nums3));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 3) {
            return nums.length;
        }

        int count = 1;
        int length = nums.length;
        int l = nums.length;
        int cutNum = 0;

        for (int i = 1; i < l; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    cutNum++;
                    i--;
                    l--;
                    for (int j = i; j < length - cutNum; j++) {
                        nums[j] = nums[j + 1];
                    }
                }
            } else {
                count = 1;
            }
        }
        return length - cutNum;
    }
}
