package leetcode.algorithms;

/**
 * Description: 907. Sum of Subarray Minimums
 *
 * @author Baltan
 * @date 2020-07-10 09:00
 */
public class SumSubarrayMins {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{71, 55, 82, 55}));
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public static int sumSubarrayMins(int[] A) {
        int result = 0;
        int mod = 1000000007;
        int length = A.length;
        /**
         * 计算A[i]作为子数组最小值的的子数组的个数，将个数乘以A[i]加入result
         */
        for (int i = 0; i < length; i++) {
            /**
             * A[i]之后连续的大于等于A[i]的数字的个数
             */
            int length1 = 0;
            int length2 = 0;
            /**
             * 计算A[i]之后连续的大于等于A[i]的数字的个数
             */
            for (int j = i + 1; j < length; j++) {
                if (A[j] < A[i]) {
                    break;
                }
                length1++;
            }
            /**
             * 计算A[i]之前连续的大于A[i]的数字的个数（因为大于等于的情况在之前已经计算过了）
             */
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] <= A[i]) {
                    break;
                }
                length2++;
            }
            /**
             * 从length1个数中取[0,length1]个数，从length2个数中取[0,length2]个数，两两组合，可以和A[i]构成
             * (length1+1)*(length2+1)个子数组
             */
            result = (result + (length1 + 1) * (length2 + 1) * A[i]) % mod;
        }
        return result;
    }
}
