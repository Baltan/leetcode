package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1818. Minimum Absolute Sum Difference
 *
 * @author Baltan
 * @date 2022/6/21 09:18
 */
public class MinAbsoluteSumDiff {
    public static void main(String[] args) {
        System.out.println(minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
        System.out.println(minAbsoluteSumDiff(new int[]{2, 4, 6, 8, 10}, new int[]{2, 4, 6, 8, 10}));
        System.out.println(minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/minimum-absolute-sum-difference/solution/jue-dui-chai-zhi-he-by-leetcode-solution-gv78/"></a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        long sum = 0L;
        int length = nums1.length;
        int[] clone = nums1.clone();
        Arrays.sort(clone);

        for (int i = 0; i < length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }

        long result = sum;
        /**
         * 对nums2中的每一个元素，在clone中二分查找最接近该元素的数
         */
        for (int i = 0; i < length; i++) {
            int target = nums2[i];
            int lo = 0;
            int hi = length - 1;
            /**
             * 在clone中二分查找不大于target的最大值的索引
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (clone[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            /**
             * 尝试将nums1[i]替换为clone[lo]后，计算绝对差值和
             */
            result = Math.min(result, sum - Math.abs(nums1[i] - nums2[i]) + Math.abs(clone[lo] - nums2[i]));
            /**
             * 如果clone[lo]不是clone中的最大值，尝试将nums1[i]替换为clone[lo+1]后，计算绝对差值和
             */
            if (lo < length - 1) {
                result = Math.min(result,
                        sum - Math.abs(nums1[i] - nums2[i]) + Math.abs(clone[lo + 1] - nums2[i]));
            }
        }
        return (int) (result % mod);
    }
}
