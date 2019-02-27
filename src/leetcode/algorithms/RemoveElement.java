package leetcode.algorithms;

/**
 * Description:Remove Element
 * @author Baltan
 *
 * @date 2017/11/8 14:11
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {3, 2, 2, 3};
        System.out.println(removeElement(nums1, 2));
        System.out.println(removeElement(nums2, 3));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int removeNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                removeNum++;
            } else {
                nums[i - removeNum] = nums[i];
            }
        }
        return nums.length - removeNum;
    }
}
