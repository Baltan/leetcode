package leetcode.algorithms;

/**
 * Description: 2750. Ways to Split Array Into Good Subarrays
 *
 * @author Baltan
 * @date 2023/7/1 15:34
 */
public class NumberOfGoodSubarraySplits {
    public static void main(String[] args) {
        System.out.println(numberOfGoodSubarraySplits(new int[]{0, 1, 0, 0, 1}));
        System.out.println(numberOfGoodSubarraySplits(new int[]{0, 1, 0}));
    }

    public static int numberOfGoodSubarraySplits(int[] nums) {
        long result = 1L;
        int mod = 1000000007;
        int length = nums.length;
        int lo = 0;
        int hi = length - 1;
        /**
         * 对于连续的“0”计数
         */
        int count = 0;
        /**
         * 找到数组nums中最左边的1
         */
        while (lo < length && nums[lo] != 1) {
            lo++;
        }
        /**
         * 找到数组nums中最右边的1
         */
        while (hi >= 0 && nums[hi] != 1) {
            hi--;
        }
        /**
         * 说明数组nums中没有1
         */
        if (lo == length) {
            return 0;
        }
        /**
         * 说明数组中只有一个1
         */
        if (lo == hi) {
            return 1;
        }
        lo++;

        while (lo < length) {
            if (nums[lo] == 0) {
                count++;
            } else {
                /**
                 * 连续的count个“0”中分配给左侧的子数组的个数可以为[0,count]，共count+1种情况
                 */
                result = (result * (count + 1)) % mod;
                count = 0;
            }
            lo++;
        }
        return (int) result;
    }
}
