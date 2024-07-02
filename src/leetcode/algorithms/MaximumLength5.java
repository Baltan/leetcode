package leetcode.algorithms;

/**
 * Description: 3201. Find the Maximum Length of Valid Subsequence I
 *
 * @author Baltan
 * @date 2024/7/2 18:09
 * @see MaximumLength6
 */
public class MaximumLength5 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 3, 4}));
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(maximumLength(new int[]{1, 3}));
    }

    public static int maximumLength(int[] nums) {
        int result = 0;
        /**
         * 头部两个数字为奇数、偶数的子序列的最大长度
         */
        int oddEvenLength = 0;
        /**
         * 头部两个数字为偶数、奇数的子序列的最大长度
         */
        int evenOddLength = 0;
        /**
         * 头部两个数字为奇数、奇数的子序列的最大长度
         */
        int oddOddLength = 0;
        /**
         * 头部两个数字为偶数、偶数的子序列的最大长度
         */
        int evenEvenLength = 0;
        /**
         * 正确序列中的数字奇偶性要不全部相同，要不序列总的奇数和偶数交替出现
         */
        for (int num : nums) {
            if ((num & 1) == 1) {
                /**
                 * 如何头部两个数字为奇数、偶数的子序列当前长度为偶数，则数字num可以拼接到子序列后
                 */
                if ((oddEvenLength & 1) == 0) {
                    oddEvenLength++;
                }
                /**
                 * 如何头部两个数字为偶数、奇数的子序列当前长度为奇数，则数字num可以拼接到子序列后
                 */
                if ((evenOddLength & 1) == 1) {
                    evenOddLength++;
                }
                /**
                 * 数字num可以拼接到全都是奇数的子序列后
                 */
                oddOddLength++;
            } else {
                /**
                 * 如何头部两个数字为奇数、偶数的子序列当前长度为奇数，则数字num可以拼接到子序列后
                 */
                if ((oddEvenLength & 1) == 1) {
                    oddEvenLength++;
                }
                /**
                 * 如何头部两个数字为偶数、奇数的子序列当前长度为偶数，则数字num可以拼接到子序列后
                 */
                if ((evenOddLength & 1) == 0) {
                    evenOddLength++;
                }
                /**
                 * 数字num可以拼接到全都是偶数的子序列后
                 */
                evenEvenLength++;
            }
        }
        /**
         * 四种序列取最长的情况
         */
        result = Math.max(result, oddEvenLength);
        result = Math.max(result, evenOddLength);
        result = Math.max(result, oddOddLength);
        result = Math.max(result, evenEvenLength);
        return result;
    }
}
