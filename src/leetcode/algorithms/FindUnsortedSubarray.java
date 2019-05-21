package leetcode.algorithms;

/**
 * Description: 581. Shortest Unsorted Continuous Subarray
 * @author Baltan
 *
 * @date 2017/11/12 23:01
 */
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 3, 2, 2, 2};
        int[] nums4 = {2, 3, 3, 2, 4};
        System.out.println(findUnsortedSubarray(nums1));
        System.out.println(findUnsortedSubarray(nums2));
        System.out.println(findUnsortedSubarray(nums3));
        System.out.println(findUnsortedSubarray(nums4));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        boolean flagStart = false;
        boolean flagEnd = false;
        for (int i = 0; i < nums.length - 1 && !flagStart; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    start = i;
                    flagStart = true;
                    break;
                }
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0 && !flagEnd; j--) {
                if (nums[j] > nums[i]) {
                    end = i;
                    flagEnd = true;
                    break;
                }
            }
        }
        return end != start ? end - start + 1 : 0;
    }
}
