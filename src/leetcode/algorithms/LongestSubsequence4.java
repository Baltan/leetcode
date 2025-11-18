package leetcode.algorithms;

/**
 * Description: 3702. Longest Subsequence With Non-Zero Bitwise XOR
 *
 * @author baltan
 * @date 2025/11/13 11:15
 */
public class LongestSubsequence4 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1, 2, 3}));
        System.out.println(longestSubsequence(new int[]{2, 3, 4}));
    }

    public static int longestSubsequence(int[] nums) {
        /**
         * 数组nums中所有元素按位异或的值
         */
        int xor = 0;
        /**
         * 数组nums中是否存在非0元素
         */
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }
        /**
         * 如果数组nums中所有元素按位异或的值不为0，则nums自身是满足要求的最长子序列；否则，只要从数组中移除任意一个非0元素x，则剩余子序列中
         * 所有元素按位异或的值即为x
         */
        return xor == 0 ? (hasNonZero ? nums.length - 1 : 0) : nums.length;
    }
}
