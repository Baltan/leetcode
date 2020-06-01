package leetcode.algorithms;

/**
 * Description: 287. Find the Duplicate Number
 *
 * @author Baltan
 * @date 2019-06-15 16:42
 * @see FindDuplicate1
 * @see DetectCycle
 * @see HasCycle
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums2));

        int[] nums3 = {1, 1};
        System.out.println(findDuplicate(nums3));
    }

    public static int findDuplicate(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
