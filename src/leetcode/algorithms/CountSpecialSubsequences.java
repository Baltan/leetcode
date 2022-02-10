package leetcode.algorithms;

/**
 * Description: 1955. Count Number of Special Subsequences
 *
 * @author Baltan
 * @date 2022/2/8 15:19
 */
public class CountSpecialSubsequences {
    public static void main(String[] args) {
        System.out.println(countSpecialSubsequences(new int[]{0, 1, 2, 2}));
        System.out.println(countSpecialSubsequences(new int[]{2, 2, 0, 0}));
        System.out.println(countSpecialSubsequences(new int[]{0, 1, 2, 0, 1, 2}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-number-of-special-subsequences/solution/dong-tai-gui-hua-by-endlesscheng-4onu/"></a>
     *
     * @param nums
     * @return
     */
    public static int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        /**
         * 遍历到第i个数为止形式为[0,0,……,0]的序列的个数
         */
        long count0 = 0L;
        /**
         * 遍历到第i个数为止形式为[0,0,……,0,1,1,……,1]的序列的个数
         */
        long count1 = 0L;
        /**
         * 遍历到第i个数为止形式为[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数
         */
        long count2 = 0L;

        for (int num : nums) {
            if (num == 0) {
                /**
                 * 如果当前数字被删除，则遍历到第i个数为止形式为[0,0,……,0]的序列的个数等于遍历到第i-1个数为止形式为
                 * [0,0,……,0]的序列的个数，即count0；如果当前数字被保留，则遍历到第i个数为止形式为[0,0,……,0]的序列的个数等
                 * 于遍历到第i-1个数为止形式为[0,0,……,0]的序列的个数，即count0，此外第i个数为0时可以单独构成一个序列，即前
                 * i-1个数全被删除。所以共可以构成形式为[0,0,……,0]的序列的个数为count0+(count0+1)个。遍历到第i个数为止形式
                 * 为[0,0,……,0,1,1,……,1]和[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数等于遍历到第i-1个数为止形式为
                 * [0,0,……,0,1,1,……,1]和[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数，即count1和count2的值不变
                 */
                count0 = (count0 + (count0 + 1)) % mod;
            } else if (num == 1) {
                /**
                 * 如果当前数字被删除，则遍历到第i个数为止形式为[0,0,……,0,1,1,……,1]的序列的个数等于遍历到第i-1个数为止形式
                 * 为[0,0,……,0,1,1,……,1]的序列的个数，即count1；如果当前数字被保留，则遍历到第i个数为止形式为
                 * [0,0,……,0,1,1,……,1]的序列的个数等于遍历到第i-1个数为止形式为[0,0,……,0]的序列的个数与形式为
                 * [0,0,……,0,1,1,……,1]的序列的个数之和，即count0+count1。所以共可以构成形式为[0,0,……,0,1,1,……,1]的序
                 * 列的个数为count1+(count0+count1)个。遍历到第i个数为止形式为[0,0,……,0]和
                 * [0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数等于遍历到第i-1个数为止形式为[0,0,……,0]和
                 * [0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数，即count0和count2的值不变
                 */
                count1 = ((count0 + count1) + count1) % mod;
            } else {
                /**
                 * 如果当前数字被删除，则遍历到第i个数为止形式为[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数等于遍历到第i-1个
                 * 数为止形式为[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数，即count2；如果当前数字被保留，则遍历到第i个数为
                 * 止形式为[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数等于遍历到第i-1个数为止形式为[0,0,……,0,1,1,……,1]的
                 * 序列的个数与形式为[0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数之和，即count1+count2。所以共可以构成形式为
                 * [0,0,……,0,1,1,……,1,2,2,……,2]的序列的个数为count2+(count1+count2)个。遍历到第i个数为止形式为
                 * [0,0,……,0]和[0,0,……,0,1,1,……,1]的序列的个数等于遍历到第i-1个数为止形式为[0,0,……,0]和
                 * [0,0,……,0,1,1,……,1]的序列的个数，即count0和count1的值不变
                 */
                count2 = ((count1 + count2) + count2) % mod;
            }
        }
        return (int) count2;
    }
}
