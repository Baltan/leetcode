package leetcode.algorithms;

/**
 * Description: 1524. Number of Sub-arrays With Odd Sum
 *
 * @author Baltan
 * @date 2020-08-05 22:54
 */
public class NumOfSubarrays1 {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(numOfSubarrays(new int[]{100, 100, 99, 99}));
        System.out.println(numOfSubarrays(new int[]{7}));
    }

    public static int numOfSubarrays(int[] arr) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 当前前缀和中偶数的个数，不包含任何元素时，前缀和为0，所以初始化为1
         */
        int evenCount = 1;
        /**
         * 当前前缀和中奇数的个数
         */
        int oddCount = 0;
        /**
         * 前缀和
         */
        int prefixSum = 0;

        for (int num : arr) {
            /**
             * 当前前缀和
             */
            prefixSum += num;
            /**
             * 如果当前前缀和为奇数，则当前前缀和和前面所有偶数前缀和相减得到的子数组的和为奇数，否则当前前缀和和
             * 前面所有奇数前缀和相减得到的子数组的和为奇数
             */
            if ((prefixSum & 1) == 1) {
                result += evenCount;
                oddCount++;
            } else {
                result += oddCount;
                evenCount++;
            }
        }
        return (int) (result % mod);
    }
}
