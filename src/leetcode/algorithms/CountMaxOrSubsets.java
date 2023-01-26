package leetcode.algorithms;

/**
 * Description: 2044. Count Number of Maximum Bitwise-OR Subsets
 *
 * @author Baltan
 * @date 2023/1/25 21:51
 */
public class CountMaxOrSubsets {
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/solutions/1335667/tong-ji-an-wei-huo-neng-de-dao-zui-da-zh-r6zd/"></a>
     *
     * @param nums
     * @return
     */
    public static int countMaxOrSubsets(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * max的二进制值表示0b11……11（共length个1），从低到高第i位为1时表示nums[i]在子集中，否则表示不在子集中
         */
        int max = (1 << length) - 1;
        /**
         * 子集中所有元素按位或运算的最大值
         */
        int maxOr = 0;
        /**
         * 因为要求子集非空，所以从1开始循环
         */
        for (int i = 1; i <= max; i++) {
            /**
             * 当前子集中所有元素按位或运算的结果
             */
            int or = 0;
            /**
             * num的二进制表示的每一位确定了数组nums中的每个数是否在子集中
             */
            int num = i;
            int bit = 0;

            while (num > 0) {
                /**
                 * 判断num的最低位，即i的从低到高第bit位是否为1
                 */
                if ((num & 1) == 1) {
                    or |= nums[bit];
                }
                num >>= 1;
                bit++;
            }

            if (or > maxOr) {
                result = 1;
                maxOr = or;
            } else if (or == maxOr) {
                result++;
            }
        }
        return result;
    }
}
