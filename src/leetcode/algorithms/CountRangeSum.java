package leetcode.algorithms;

/**
 * Description: 327. Count of Range Sum
 *
 * @author Baltan
 * @date 2019-06-21 11:08
 */
public class CountRangeSum {
    public static void main(String[] args) {
        int[] nums1 = {-2, 5, -1};
        System.out.println(countRangeSum(nums1, -2, 2));

        int[] nums2 = {-2147483647, 0, -2147483647, 2147483647};
        System.out.println(countRangeSum(nums2, -564, 3864));
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            long sum = nums[i];

            if (sum >= lower && sum <= upper) {
                result++;
            }

            for (int j = i + 1; j < length; j++) {
                sum += nums[j];

                if (sum >= lower && sum <= upper) {
                    result++;
                }
            }
        }
        return result;
    }
}
