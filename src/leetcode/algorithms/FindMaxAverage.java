package leetcode.algorithms;

/**
 * Description: 643. Maximum Average Subarray I
 * @author Baltan
 *
 * @date 2017/11/9 09:44
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int[] nums2 = {5};
        int k1 = 4;
        int k2 = 1;
        System.out.println(findMaxAverage(nums1, k1));
        System.out.println(findMaxAverage(nums2, k2));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            max = max > sum ? max : sum;
        }
        return max / k;
    }
}
