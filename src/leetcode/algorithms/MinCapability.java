package leetcode.algorithms;

/**
 * Description: 2560. House Robber IV
 *
 * @author Baltan
 * @date 2023/2/5 16:18
 * @see Rob
 * @see Rob1
 * @see Rob2
 */
public class MinCapability {
    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));
        System.out.println(minCapability(new int[]{2, 7, 9, 3, 1}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.com/problems/house-robber-iv/solutions/3143697/java-c-python-binary-search-o-1-space/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int minCapability(int[] nums, int k) {
        /**
         * 根据题意，nums[i]∈[1,1000000000]
         */
        int lo = 1;
        int hi = 1000000000;
        int length = nums.length;
        /**
         * 二分查找强盗的最小能力的最大值
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            /**
             * 当每座房子的钱不超过mid时，强盗可以抢劫的最大房子数量
             */
            int count = 0;
            /**
             * 贪心，从左至右抢劫尽可能多的房子
             */
            for (int i = 0; i < length; ) {
                if (nums[i] <= mid) {
                    count += 1;
                    /**
                     * 当前房子被抢劫了，要跳过下一座房子
                     */
                    i += 2;
                } else {
                    i += 1;
                }
            }

            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
