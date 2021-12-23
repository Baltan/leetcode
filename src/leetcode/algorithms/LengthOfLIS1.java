package leetcode.algorithms;

/**
 * Description: 300. Longest Increasing Subsequence
 *
 * @author Baltan
 * @date 2020-02-01 13:10
 * @see LengthOfLIS
 * @see KIncreasing
 */
public class LengthOfLIS1 {
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1));

        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums2));

        int[] nums3 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums3));

        int[] nums4 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums4));

        int[] nums5 = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(nums5));
    }

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        /**
         * d[i]表示长度为i的递增子数组的最后一个元素的大小
         */
        int[] d = new int[length + 1];
        /**
         * 递增子数组的长度
         */
        int lengthOfLIS = 1;
        /**
         * 数组nums的第一个元素构成一个长度为1的递增子数组
         */
        d[1] = nums[0];

        for (int i = 1; i < length; i++) {
            /**
             * 如果nums[i]大于递增子数组d中的最后一个元素，则可以使递增子数组的长度增加1，否则通过二分查找得到递增子数组中第一
             * 个大于nums[i]的数字，如果这个数字的前一个数字小于nums[i]或者这个数字就是数组d的第一个数字，用nums[i]替换这个
             * 数字，使得递增子数组中的数字尽可能小，从而后面拼接得到更长递增子数组的概率更大
             */
            if (nums[i] > d[lengthOfLIS]) {
                lengthOfLIS++;
                d[lengthOfLIS] = nums[i];
            } else {
                int index = binarySearch(d, lengthOfLIS, nums[i]);

                if (index == 1 || d[index - 1] < nums[i]) {
                    d[index] = nums[i];
                }
            }
        }
        return lengthOfLIS;
    }

    /**
     * 在数组d中找到第一个比target大的数，返回索引位置
     *
     * @param d
     * @param hi
     * @param target
     * @return
     */
    public static int binarySearch(int[] d, int hi, int target) {
        int lo = 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (d[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
