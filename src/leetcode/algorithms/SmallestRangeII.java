package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 910. Smallest Range II
 *
 * @author Baltan
 * @date 2020-02-25 13:06
 */
public class SmallestRangeII {
    public static void main(String[] args) {
        System.out.println(smallestRangeII(new int[]{1}, 0));
        System.out.println(smallestRangeII(new int[]{0, 10}, 2));
        System.out.println(smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/smallest-range-ii/solution/tai-nan-liao-zhi-neng-hua-tu-ping-zhi-jue-by-user8/"></a>
     *
     * @param A
     * @param K
     * @return
     */
    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int length = A.length;
        /**
         * 结果不会大于A[length-1]-A[0]，否则将所有元素都加K或减K就能得到更小的结果
         */
        int result = A[length - 1] - A[0];
        /**
         * 将A[0]……A[i-1]的所有值都加K，将A[i]……A[length-1]的所有值都减K，则最小值一定在
         * A[0]+K和A[i]-K中产生，最大值一定在A[i-1]+K和A[length-1]-K中产生，对于每一个i
         * 都计算最大值和最小值的差
         */
        for (int i = 1; i < length; i++) {
            int max = Math.max(A[i - 1] + K, A[length - 1] - K);
            int min = Math.min(A[0] + K, A[i] - K);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
