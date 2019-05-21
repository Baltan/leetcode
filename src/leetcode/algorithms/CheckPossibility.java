package leetcode.algorithms;

/**
 * Description: 665. Non-decreasing Array
 * @author Baltan
 *
 * @date 2017/11/17 11:30
 */
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums1 = {4, 2, 3};
        int[] nums2 = {4, 2, 1};
        int[] nums3 = {1, 3, 2};
        System.out.println(checkPossibility(nums1));
        System.out.println(checkPossibility(nums2));
        System.out.println(checkPossibility(nums3));
    }

    public static boolean checkPossibility(int[] nums) {
        int revNums = 0;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                revNums++;
                index = i;
            }
        }
        if (revNums > 1) {
            return false;
        } else if (revNums == 0) {
            return true;
        } else {
            if (index == 0 || index == nums.length - 2 || nums[index] <= nums[index + 2] || nums[index - 1] <= nums[index
                    + 1]) {
                return true;
            } else {
                return false;
            }
        }
    }
}
