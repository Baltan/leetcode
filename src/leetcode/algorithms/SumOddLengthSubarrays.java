package leetcode.algorithms;

/**
 * Description: 1588. Sum of All Odd Length Subarrays
 *
 * @author Baltan
 * @date 2022/10/16 12:29
 */
public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        int length = arr.length;
        /**
         * 数组数组nums的前缀和的前缀和
         */
        int[] prefixSums = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < length; i++) {
            /**
             * 子数组[arr[0],arr[1],……,arr[i]]的长度
             */
            int currLength = i + 1;
            /**
             * j表示奇数长度子数组的可能长度
             */
            for (int j = 1; j <= currLength; j += 2) {
                result += prefixSums[i + 1] - prefixSums[i + 1 - j];
            }
        }
        return result;
    }
}
