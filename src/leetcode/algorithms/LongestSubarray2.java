package leetcode.algorithms;

/**
 * Description: 2419. Longest Subarray With Maximum Bitwise AND
 *
 * @author Baltan
 * @date 2022/12/17 15:06
 */
public class LongestSubarray2 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
        System.out.println(longestSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(longestSubarray(new int[]{96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979}));
        System.out.println(longestSubarray(new int[]{311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155}));
    }

    public static int longestSubarray(int[] nums) {
        int result = 0;
        /**
         * 数组nums中的最大值
         */
        int max = 0;
        /**
         * 所有元素都为max的子数组的长度
         */
        int length = 0;
        /**
         * 查找数组nums中的最大值
         */
        for (int num : nums) {
            max = Math.max(max, num);
        }
        /**
         * 因为若干个元素进行与运算后得到的值不会大于这些元素的最大值，所以nums的子数组进行与运算能够得到的最大值就是max，只需要计算所有元素都为
         * max的子数组的最大长度即可
         */
        for (int num : nums) {
            if (num != max) {
                length = 0;
            } else {
                length++;
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
