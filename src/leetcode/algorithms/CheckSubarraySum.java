package leetcode.algorithms;

/**
 * Description: 523. Continuous Subarray Sum
 *
 * @author Baltan
 * @date 2019-10-26 13:47
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums1, 6));

        int[] nums2 = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums2, 6));

        int[] nums3 = {0, 0};
        System.out.println(checkSubarraySum(nums3, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] prefixSum = new int[length + 1];
        /**
         * 计算数组的前缀和
         */
        for (int i = 1; i <= length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        /**
         * 逐一计算前缀和数组中位置不相邻的两个元素的差，判断是否为k的倍数
         */
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 2; j <= length; j++) {
                /**
                 * 如果k为0，前缀和数组中两个不相邻元素的差也为0，则存在满足条件的子数组；如果k不为0，前缀和数组中
                 * 两个不相邻元素的差对k取模为0，则也存在满足条件的子数组
                 */
                if (k == 0) {
                    if (prefixSum[j] - prefixSum[i] == 0) {
                        return true;
                    }
                } else if ((prefixSum[j] - prefixSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
