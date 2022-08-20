package leetcode.algorithms;

/**
 * Description: 1712. Ways to Split Array Into Three Subarrays
 *
 * @author Baltan
 * @date 2022/8/14 16:01
 */
public class WaysToSplit {
    public static void main(String[] args) {
        System.out.println(waysToSplit(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(waysToSplit(new int[]{1, 1, 1}));
        System.out.println(waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(waysToSplit(new int[]{3, 2, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/solution/by-user2269a-gwgc/"></a>
     *
     * @param nums
     * @return
     */
    public static int waysToSplit(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        int length = nums.length;
        /**
         * 数组nums中所有元素的和
         */
        int sum = 0;
        /**
         * 数组nums的前缀和
         */
        int[] prefixSums = new int[length + 1];
        /**
         * 计算数组nums的前缀和
         */
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        /**
         * 根据题意，leftSum<=midSum<=rightSum，所以leftSum的最大值不会超过maxLeftSum
         */
        int maxLeftSum = sum / 3;
        /**
         * 枚举left子数组中包含的元素的个数，至少1个，至多length-2个
         */
        for (int leftCount = 1, maxLeftCont = length - 2; leftCount <= maxLeftCont; leftCount++) {
            /**
             * 如果leftSum大于maxLeftSum
             */
            if (prefixSums[leftCount] > maxLeftSum) {
                break;
            }
            /**
             * mid子数组中最少包含的元素的个数
             */
            int minMidCount = getMinMidCount(prefixSums, length, leftCount);
            /**
             * mid子数组中最多包含的元素的个数
             */
            int maxMidCount = getMaxMidCount(prefixSums, length, leftCount);

            if (maxMidCount >= minMidCount) {
                result = (result + (maxMidCount - minMidCount + 1)) % mod;
            }
        }
        return (int) result;
    }

    /**
     * 二分查找mid子数组中最少包含的元素的个数
     */
    public static int getMinMidCount(int[] prefixSums, int totalCount, int leftCount) {
        int lo = 1;
        int hi = totalCount - leftCount - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            /**
             * mid子数组中所有元素的和
             */
            int midSum = prefixSums[leftCount + mid] - prefixSums[leftCount];

            if (midSum < prefixSums[leftCount]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 二分查找mid子数组中最多包含的元素的个数
     */
    public static int getMaxMidCount(int[] prefixSums, int totalCount, int leftCount) {
        int lo = 1;
        int hi = totalCount - leftCount - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            /**
             * mid子数组中所有元素的和
             */
            int midSum = prefixSums[leftCount + mid] - prefixSums[leftCount];
            /**
             * right子数组中所有元素的和
             */
            int rightSum = prefixSums[totalCount] - prefixSums[leftCount + mid];

            if (midSum > rightSum) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
