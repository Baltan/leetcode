package leetcode.algorithms;

/**
 * Description: 3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K
 *
 * @author baltan
 * @date 2024/1/16 09:26
 */
public class FindMaximumNumber {
    public static void main(String[] args) {
        System.out.println(findMaximumNumber(7L, 2));
        System.out.println(findMaximumNumber(9L, 1));
    }

    public static long findMaximumNumber(long k, int x) {
        long lo = 1;
        long hi = Long.MAX_VALUE / 2;
        /**
         * combinations[i][j]表示从i个中选择j个的方法数
         */
        long[][] combinations = new long[64][64];

        for (int i = 1; i < combinations.length; i++) {
            for (int j = 0; j <= i; j++) {
                getCombinations(i, j, combinations);
            }
        }
        /**
         * 二分搜索计算符合题意的最大值num
         */
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            /**
             * [1,mid]范围内所有数字的二进制值符合题意的设置位的总数
             */
            long setBits = countSetBit(mid, x, combinations, k);

            if (setBits > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    /**
     * 从totalCount个中选择chosenCount个的方法数
     *
     * @param totalCount
     * @param chosenCount
     * @param combinations
     * @return
     */
    public static void getCombinations(int totalCount, int chosenCount, long[][] combinations) {
        if (chosenCount == 0) {
            combinations[totalCount][chosenCount] = 1L;
            return;
        }
        /**
         * 根据组合计算公式，C(totalCount,chosenCount)=C(totalCount,totalCount-chosenCount)
         */
        if (chosenCount > totalCount - chosenCount) {
            combinations[totalCount][chosenCount] = combinations[totalCount][totalCount - chosenCount];
            return;
        }
        combinations[totalCount][chosenCount] = 1L;
        /**
         * C(totalCount,chosenCount)=(totalCount*(totalCount-1)*……*(totalCount-chosenCount+1))/(1*2*……*chosenCount)
         */
        for (int i = 1; i <= chosenCount; i++) {
            combinations[totalCount][chosenCount] = combinations[totalCount][chosenCount] * (totalCount + 1 - i) / i;
        }
    }

    /**
     * 计算[1,limit]范围内所有数字的二进制值符合题意的设置位的总数
     *
     * @param limit
     * @param x
     * @param combinations
     * @param k
     * @return
     */
    public static long countSetBit(long limit, int x, long[][] combinations, long k) {
        if (limit <= 0) {
            return 0L;
        }
        long setBits = 0L;
        /**
         * limit的二进制值不算前导0的总位数
         */
        int totalBits = 64 - Long.numberOfLeadingZeros(limit);
        /**
         * 在[1,limit]中，考虑二进制值总位数小于totalBits的数字，这部分数字，最多只有availableBits个数位为1时，才会被计数
         */
        int availableBits = (totalBits - 1) / x;
        /**
         * 依次计算二进制值总位数小于totalBits的数字中符合题意的设置位个数为[1,availableBits]的情况下设置位的总数
         */
        for (int i = 1; i <= availableBits; i++) {
            /**
             * 从availableBits个数位中选择i个作为符合题意的设置位的数字，共有combinations[availableBits][i]种情况，这些数字剩余
             * totalBits-1-availableBits个数位，既可以为0，也可以为1，共有2^(totalBits-1-availableBits)种组合，所以共得到
             * combinations[availableBits][i]*(2^(totalBits-1-availableBits))*i个符合题意的设置位
             */
            setBits += combinations[availableBits][i] * i * (1L << (totalBits - 1 - availableBits));
            /**
             * 设置位个数已经超过上限，不需要继续累加计算
             */
            if (setBits > k) {
                return setBits;
            }
        }
        /**
         * limit的二进制值除去最高位的1，剩余部分的值
         */
        long y = limit - (1L << (totalBits - 1));
        /**
         * 在[1,limit]中，考虑二进制值总位数为totalBits的数字，这部分数字共有y+1个，且从低到高第totalBits位都为1。对于这部分数字，可以
         * 通过递归计算得到[1,y]范围内所有数字的二进制值符合题意的设置位的总数countSetBit(y,x,combinations,k)，而对于第totalBits位的
         * 1，如果它是符合题意的设置位，则还需加上y+1个设置位
         */

        return setBits + countSetBit(y, x, combinations, k) + (totalBits % x == 0 ? y + 1 : 0);
    }
}
