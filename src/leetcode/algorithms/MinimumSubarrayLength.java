package leetcode.algorithms;

/**
 * Description: 3097. Shortest Subarray With OR at Least K II
 *
 * @author Baltan
 * @date 2024/4/2 20:40
 * @see MinimumSubarrayLength1
 */
public class MinimumSubarrayLength {
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(minimumSubarrayLength(new int[]{1, 2}, 0));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * 子数组第一个元素在数组nums中的索引值
         */
        int lo = 0;
        /**
         * 子数组最后一个元素在数组nums中的索引值
         */
        int hi = 0;
        /**
         * bitCounts[0]-bitCounts[31]依次表示子数组中所有元素的二进制值从最高位到最低位上1的总个数
         */
        int[] bitCounts = new int[32];
        increment(bitCounts, nums[0], 1);
        /**
         * 子数组中所有元素按位或运算的值，初始时子数组为[nums[0]]
         */
        int or = nums[0];
        /**
         * 因为按位或运算有非严格递增的性质，当or小于k时，向右移动指针hi，扩大子数组，否则尝试向右移动指针lo，缩小子数组
         */
        while (true) {
            if (or < k) {
                if (hi + 1 < length) {
                    /**
                     * 向右移动指针hi，扩大子数组
                     */
                    hi++;
                    increment(bitCounts, nums[hi], 1);
                    or = getOr(bitCounts);
                } else {
                    /**
                     * 子数组已经无法再扩大，结束计算
                     */
                    break;
                }
            } else {
                result = Math.min(result, hi - lo + 1);

                if (lo < hi) {
                    /**
                     * 向右移动指针lo，缩小子数组
                     */
                    increment(bitCounts, nums[lo], -1);
                    or = getOr(bitCounts);
                    lo++;
                } else if (hi + 1 < length) {
                    /**
                     * 指针lo、hi重合，即子数组中只有唯一一个元素，只能同时右移指针lo、hi
                     */
                    increment(bitCounts, nums[lo], -1);
                    lo++;
                    hi++;
                    increment(bitCounts, nums[hi], 1);
                    or = getOr(bitCounts);
                } else {
                    /**
                     * 指针lo、hi都已经指向数组nums中的最后一个元素，结束计算
                     */
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 数字num加入子数组（weight为1）或从子数组中移除（weight为-1）后，更新bitCounts
     *
     * @param bitCounts
     * @param num
     * @param weight
     */
    public static void increment(int[] bitCounts, int num, int weight) {
        for (int i = 31; i >= 0; i--) {
            int bit = num & 1;
            bitCounts[i] += bit * weight;
            num >>= 1;
        }
    }

    /**
     * 计算子数组中所有元素按位或运算的值
     *
     * @param bitCounts
     * @return
     */
    public static int getOr(int[] bitCounts) {
        int or = 0;
        int offset = 0;

        for (int i = 31; i >= 0; i--) {
            or += bitCounts[i] == 0 ? 0 : (1 << offset);
            offset++;
        }
        return or;
    }
}
