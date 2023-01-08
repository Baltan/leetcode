package leetcode.algorithms;

/**
 * Description: 2401. Longest Nice Subarray
 *
 * @author Baltan
 * @date 2022/12/23 09:23
 */
public class LongestNiceSubarray {
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(longestNiceSubarray(new int[]{3, 1, 5, 11, 13}));
    }

    public static int longestNiceSubarray(int[] nums) {
        int result = 1;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            /**
             * 子数组前缀中所有元素按位或的结果
             */
            int or = nums[i];

            for (int j = i + 1; j < length; j++) {
                /**
                 * 因为子数组中任意两个数按位与的结果都是0，所以同一个二进制位上，这些数字中至多只有一个数字该位上为1。如果or的二进制值的某一
                 * 位为1，说明子数组前缀中已经存在在该位上值为1的数字，当nums[j]&or不为0时，说明nums[j]在同样的位上值为1，不满足题意，否则
                 * 可以将nums[j]追加到子数组中
                 */
                if ((or & nums[j]) == 0) {
                    or |= nums[j];
                    result = Math.max(result, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
