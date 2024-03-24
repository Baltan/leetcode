package leetcode.algorithms;

/**
 * Description: 2321. Maximum Score Of Spliced Array
 *
 * @author Baltan
 * @date 2024/3/23 18:09
 * @see leetcode.interview.MaxSubArray
 * @see leetcode.algorithms.MaxSubArray
 * @see MaximumCostSubstring
 */
public class MaximumsSplicedArray {
    public static void main(String[] args) {
        System.out.println(maximumsSplicedArray(new int[]{60, 60, 60}, new int[]{10, 90, 10}));
        System.out.println(maximumsSplicedArray(new int[]{20, 40, 20, 70, 30}, new int[]{50, 20, 50, 40, 20}));
        System.out.println(maximumsSplicedArray(new int[]{7, 11, 13}, new int[]{1, 1, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-score-of-spliced-array/solutions/1626030/by-endlesscheng-fm8l/"></a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int length = nums1.length;
        /**
         * 数组nums1中所有元素之和
         */
        int sum1 = 0;
        /**
         * 数组nums2中所有元素之和
         */
        int sum2 = 0;
        /**
         * 数组nums2中所有被交换元素之和-数组nums1中所有被交换元素之和
         */
        int swap1 = Integer.MIN_VALUE;
        /**
         * 数组nums1中所有被交换元素之和-数组nums2中所有被交换元素之和
         */
        int swap2 = Integer.MIN_VALUE;
        /**
         * 数组nums1的子数组中所有元素之和
         */
        int temp1 = 0;
        /**
         * 数组nums2的子数组中所有元素之和
         */
        int temp2 = 0;
        /**
         * 根据题意，需要将数组nums1中某个子数组和nums2中对应位置的子数组交换，使得交换后nums1中所有元素之和或者nums2中所有元素之和尽可能
         * 大。假设最终nums1中所有元素之和更大，则和=∑nums1[i]+(∑nums2[m……n]-∑nums1[m……n])=∑nums1[i]+(nums2[m]-nums1[m])+……+
         * (nums2[n]-nums1[n])，只需要使得(nums2[m]-nums1[m])+……+(nums2[n]-nums1[n])部分尽可能大即可，相当于求数组
         * [nums2[0]-nums1[0],nums2[1]-nums1[1],……,nums2[length-1]-nums1[length-1]]中子数组元素之和的最大值。如果最终nums2中所
         * 有元素之和更大，则同理。
         */
        for (int i = 0; i < length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            /**
             * 如果当前元素nums2[i]-nums1[i]加上它前面子数组中所有元素之和大于元素nums2[i]-nums1[i]本身，就继续扩展它前面的子数组，否
             * 则就从当前数字开始重新尝试扩展子数组
             */
            temp1 = Math.max(nums2[i] - nums1[i] + temp1, nums2[i] - nums1[i]);
            swap1 = Math.max(swap1, temp1);
            /**
             * 如果当前元素nums1[i]-nums2[i]加上它前面子数组中所有元素之和大于元素nums1[i]-nums2[i]本身，就继续扩展它前面的子数组，否
             * 则就从当前数字开始重新尝试扩展子数组
             */
            temp2 = Math.max(nums1[i] - nums2[i] + temp2, nums1[i] - nums2[i]);
            swap2 = Math.max(swap2, temp2);
        }
        /**
         * 交换子数组后，两数组各自元素之和取较大值
         */
        return Math.max(sum1 + swap1, sum2 + swap2);
    }
}
