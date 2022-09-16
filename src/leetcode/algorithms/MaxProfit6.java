package leetcode.algorithms;

/**
 * Description: 1648. Sell Diminishing-Valued Colored Balls
 *
 * @author Baltan
 * @date 2022/9/15 20:25
 */
public class MaxProfit6 {
    public static void main(String[] args) {
        System.out.println(maxProfit(
                new int[]{701695700, 915736894, 35093938, 364836059, 452183894, 951826038, 861556610,
                        441929847, 842650446, 858413011, 457896886, 35119509, 776620034, 396643588, 83585103,
                        681609037}, 598226067));
        System.out.println(maxProfit(new int[]{2, 5}, 4));
        System.out.println(maxProfit(new int[]{3, 5}, 6));
        System.out.println(maxProfit(new int[]{497978859, 167261111, 483575207, 591815159}, 836556809));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/sell-diminishing-valued-colored-balls/solution/liang-chong-si-lu-you-hua-tan-xin-suan-fa-you-hua-/"></a>
     *
     * @param inventory
     * @param orders
     * @return
     */
    public static int maxProfit(int[] inventory, int orders) {
        long result = 0L;
        int mod = 1000000007;
        int lo = 1;
        int hi = 1000000000;
        /**
         * 二分查找最后一个卖出的球的价值
         */
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            /**
             * 所有价值大于mid的球的总个数
             */
            long totalCount = 0L;
            /**
             * 剩余价值等于mid的球的总个数
             */
            int mostCount = 0;

            for (int initCount : inventory) {
                if (initCount > mid) {
                    /**
                     * 价值为initCount、initCount-1、initCount-2、……、mid+1的球都会被卖掉，共计卖出soldCount个
                     */
                    int soldCount = initCount - mid;
                    totalCount += soldCount;
                    mostCount++;
                } else if (initCount == mid) {
                    mostCount++;
                }
            }
            /**
             * 除了价值大于mid的totalCount个球一定会被卖掉，剩余价值为mid的mostCount个球也能被卖掉一部分或全部卖掉，这种情况
             * 下，最多一共能被卖掉totalCount+mostCount个球，如果仍不足orders要求的数量，说明最后一个卖出的球的价值一定小于
             * mid
             */
            if (totalCount + mostCount < orders) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        /**
         * 计算价值大于mid的totalCount个球的总价值
         */
        for (int initCount : inventory) {
            if (initCount > lo) {
                int soldCount = initCount - lo;
                result = (result + getSum(initCount, lo + 1, soldCount)) % mod;
                orders -= soldCount;
            }
        }
        /**
         * 计算价值等于mid的若干个球的总价值
         */
        if (orders > 0) {
            result = (result + 1L * orders * lo) % mod;
        }
        return (int) result;
    }

    /**
     * 求数列和
     *
     * @param start
     * @param end
     * @param count
     * @return
     */
    public static long getSum(int start, int end, int count) {
        return 1L * (start + end) * count / 2;
    }
}
