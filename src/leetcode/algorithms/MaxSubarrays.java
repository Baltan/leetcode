package leetcode.algorithms;

/**
 * Description: 2871. Split Array Into Maximum Number of Subarrays
 *
 * @author Baltan
 * @date 2023/10/3 23:59
 */
public class MaxSubarrays {
    public static void main(String[] args) {
        System.out.println(maxSubarrays(new int[]{0}));
        System.out.println(maxSubarrays(new int[]{1, 0, 2, 0, 1, 2}));
        System.out.println(maxSubarrays(new int[]{5, 7, 1, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/split-array-into-maximum-number-of-subarrays/solutions/2464645/li-yong-and-xing-zhi-yi-ci-bian-li-pytho-p3bj/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxSubarrays(int[] nums) {
        /**
         * 数组nums中所有数字进行与运算的结果。初始值为-1，因为-1的二进制值为0b1111……111，与任何数与运算后都等于那个数
         */
        int min = -1;

        for (int num : nums) {
            min &= num;
        }
        /**
         * 因为任何数字进行与运算后的结果不可能大于其本身，所以数组nums中所有元素进行与运算的结果x，一定不大于其子数组中所有元素进行与运算的
         * 结果y。如果x不为0，则y>=x>0，若分割成多个子数组，每个子数组的与运算结果的和一定大于x；如果x为0，则只需保证分割出的每个子数组中所
         * 有元素与运算结果都为0即可
         */
        if (min != 0) {
            return 1;
        } else {
            int result = 0;
            int and = -1;

            for (int num : nums) {
                if (and == 0) {
                    /**
                     * 得到了一个所有元素与运算结果为0的子数组
                     */
                    result++;
                    and = num;
                } else {
                    and &= num;
                }
            }
            /**
             * 判断数组nums中最后若干个元素自身能否再构成一个所有元素与运算结果为0的子数组，如果不能则只需合并到前一个子数组中即可
             */
            return result + ((and == 0) ? 1 : 0);
        }
    }
}
