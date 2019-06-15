package leetcode.algorithms;

/**
 * Description: 287. Find the Duplicate Number
 *
 * @author Baltan
 * @date 2019-06-15 16:42
 */
public class FindDuplicate1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums2));

        int[] nums3 = {1, 1};
        System.out.println(findDuplicate(nums3));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
