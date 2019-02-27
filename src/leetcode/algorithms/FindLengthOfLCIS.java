package leetcode.algorithms;

/**
 * Description:Longest Continuous Increasing Subsequence
 * @author Baltan
 *
 * @date 2017/11/7 19:47
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4, 7};
        int[] nums2 = {2, 2, 2, 2, 2};
        int[] nums3 = {};
        System.out.println(findLengthOfLCIS(nums1));
        System.out.println(findLengthOfLCIS(nums2));
        System.out.println(findLengthOfLCIS(nums3));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        if (nums.length == 0) {
            return 0;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                int temp = 1;
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[j + 1] > nums[j]) {
                        temp++;
                    } else {
                        break;
                    }
                }
                maxLength = maxLength > temp ? maxLength : temp;
            }
        }
        return maxLength;
    }
}
