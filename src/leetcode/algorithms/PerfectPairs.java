package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3649. Number of Perfect Pairs
 *
 * @author baltan
 * @date 2025/9/11 17:07
 */
public class PerfectPairs {
    public static void main(String[] args) {
        System.out.println(perfectPairs(new int[]{0, -8}));
        System.out.println(perfectPairs(new int[]{0, 1, 2, 3}));
        System.out.println(perfectPairs(new int[]{-3, 2, -1, 4}));
        System.out.println(perfectPairs(new int[]{1, 10, 100, 1000}));
    }

    public static long perfectPairs(int[] nums) {
        long result = 0L;
        Arrays.sort(nums);
        /**
         * 元素nums[i]之前所有元素中0的个数
         */
        int zeroCount = nums[0] == 0 ? 1 : 0;
        /**
         * ∵ min(|a-b|,|a+b|)<=min(|a|,|b|)
         * ∴ min(|a-b|,|a-(-b)|)<=min(|a-0|,|b-0|)
         * ∴ 在坐标轴上，min(点a到点b的距离,点a到点-b的距离)<=min(点a到原点的距离,点b到原点的距离)
         *
         * ∵ max(|a-b|,|a+b|)>=max(|a|,|b|)
         * ∴ max(|a-b|,|a-(-b)|)>=max(|a-0|,|b-0|)
         * ∴ 在坐标轴上，max(点a到点b的距离,点a到点-b的距离)>=max(点a到原点的距离,点b到原点的距离)
         *
         * 所以，在已知点b坐标的情况下，可以求得点a∈[⌈-2b⌉,⌊-b/2⌋]或a∈[⌈b/2⌉,⌊2b⌋]（假设b为正数，当b为负数时直接取绝对值计算即可）
         */
        for (int i = 1; i < nums.length; i++) {
            /**
             * 当b=0时，a也只能为0，直接累加nums[i]之前元素0的个数即可
             */
            if (nums[i] == 0) {
                result += zeroCount;
                zeroCount++;
            } else {
                int b = Math.abs(nums[i]);
                /**
                 * 二分计算a∈[⌈b/2⌉,⌊2b⌋]时的元素个数
                 */
                int positiveUpperBoundIndex = binarySearchUpperBound(nums, (int) Math.floor(2.0 * b), i);
                int positiveLowerBoundIndex = binarySearchLowerBound(nums, (int) Math.ceil(b / 2.0), i);
                /**
                 * 二分计算a∈[⌈-2b⌉,⌊-b/2⌋]时的元素个数
                 */
                int negativeUpperBoundIndex = binarySearchUpperBound(nums, (int) Math.floor(-b / 2.0), i);
                int negativeLowerBoundIndex = binarySearchLowerBound(nums, (int) Math.ceil(-2.0 * b), i);

                if (positiveUpperBoundIndex != -1 && positiveLowerBoundIndex != -1) {
                    result += positiveUpperBoundIndex - positiveLowerBoundIndex + 1;
                }

                if (negativeUpperBoundIndex != -1 && negativeLowerBoundIndex != -1) {
                    result += negativeUpperBoundIndex - negativeLowerBoundIndex + 1;
                }
            }
        }
        return result;
    }

    /**
     * 在子数组nums[0……index-1]中二分查找大于等于lowerLimit的最小元素的索引，如果不存在则返回-1
     *
     * @param nums
     * @param lowerLimit
     * @param index
     * @return
     */
    public static int binarySearchLowerBound(int[] nums, int lowerLimit, int index) {
        if (nums[index - 1] < lowerLimit) {
            return -1;
        }
        int lo = 0;
        int hi = index - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < lowerLimit) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在子数组nums[0……index-1]中二分查找小于等于upperLimit的最大元素的索引，如果不存在则返回-1
     *
     * @param nums
     * @param upperLimit
     * @param index
     * @return
     */
    public static int binarySearchUpperBound(int[] nums, int upperLimit, int index) {
        if (nums[0] > upperLimit) {
            return -1;
        }
        int lo = 0;
        int hi = index - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (nums[mid] > upperLimit) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
