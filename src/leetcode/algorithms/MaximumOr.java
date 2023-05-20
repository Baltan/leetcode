package leetcode.algorithms;

/**
 * Description: 2680. Maximum OR
 *
 * @author Baltan
 * @date 2023/5/17 15:53
 */
public class MaximumOr {
    public static void main(String[] args) {
        System.out.println(maximumOr(new int[]{12, 9}, 1));
        System.out.println(maximumOr(new int[]{8, 1, 2}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-or/solutions/2268795/tan-xin-qian-hou-zhui-fen-jie-pythonjava-wrv1/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static long maximumOr(int[] nums, int k) {
        long result = 0L;
        int length = nums.length;
        /**
         * prefixOrs[i]=nums[0] | nums[1] | …… | nums[i-1]
         */
        int[] prefixOrs = new int[length + 1];
        /**
         * suffixOrs[i]=nums[length-1] | nums[length-2] | …… | nums[i]
         */
        int[] suffixOrs = new int[length + 1];
        /**
         * 计算数组nums的前缀按位或的值
         */
        for (int i = 0; i < length; i++) {
            prefixOrs[i + 1] = prefixOrs[i] | nums[i];
        }
        /**
         * 计算数组nums的后缀按位或的值
         */
        for (int i = length - 1; i >= 0; i--) {
            suffixOrs[i] = suffixOrs[i + 1] | nums[i];
        }
        /**
         * 为了使得结果x最大，则x的二进制值最高位的1应当尽可能在更高的数位，所以将k次乘以2的操作都执行在同一个数上，枚举数组nums中的每个数字
         */
        for (int i = 0; i < length; i++) {
            long or = ((long) nums[i] << k) | prefixOrs[i] | suffixOrs[i + 1];
            result = Math.max(result, or);
        }
        return result;
    }
}
