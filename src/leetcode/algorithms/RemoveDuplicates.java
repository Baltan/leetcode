package leetcode.algorithms;

/**
 * Description:Remove Duplicates from Sorted Array
 * @author Baltan
 *
 * @date 2017/11/9 17:09
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println(removeDuplicates(nums1));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int removeNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                removeNum++;
            } else {
                nums[i - removeNum] = nums[i];
            }
        }
        return nums.length - removeNum;
    }
}