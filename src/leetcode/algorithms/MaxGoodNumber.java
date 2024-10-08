package leetcode.algorithms;

/**
 * Description: 3309. Maximum Possible Number by Binary Concatenation
 *
 * @author Baltan
 * @date 2024/10/8 19:18
 */
public class MaxGoodNumber {
    public static void main(String[] args) {
        System.out.println(maxGoodNumber(new int[]{1, 2, 3}));
        System.out.println(maxGoodNumber(new int[]{2, 8, 16}));
    }

    public static int maxGoodNumber(int[] nums) {
        int result = Integer.MIN_VALUE;
        /**
         * nums[0]的二进制值的总位数
         */
        int length0 = 32 - Integer.numberOfLeadingZeros(nums[0]);
        /**
         * nums[1]的二进制值的总位数
         */
        int length1 = 32 - Integer.numberOfLeadingZeros(nums[1]);
        /**
         * nums[2]的二进制值的总位数
         */
        int length2 = 32 - Integer.numberOfLeadingZeros(nums[2]);
        /**
         * 枚举数组nums中三个数字组合的所有情况
         */
        result = Math.max(result, (nums[0] << (length1 + length2)) + (nums[1] << length2) + nums[2]);
        result = Math.max(result, (nums[0] << (length1 + length2)) + (nums[2] << length1) + nums[1]);
        result = Math.max(result, (nums[1] << (length0 + length2)) + (nums[0] << length2) + nums[2]);
        result = Math.max(result, (nums[1] << (length0 + length2)) + (nums[2] << length0) + nums[0]);
        result = Math.max(result, (nums[2] << (length0 + length1)) + (nums[0] << length1) + nums[1]);
        result = Math.max(result, (nums[2] << (length0 + length1)) + (nums[1] << length0) + nums[0]);
        return result;
    }
}
