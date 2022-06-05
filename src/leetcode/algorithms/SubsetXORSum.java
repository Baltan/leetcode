package leetcode.algorithms;

/**
 * Description: 1863. Sum of All Subset XOR Totals
 *
 * @author Baltan
 * @date 2022/6/5 12:21
 */
public class SubsetXORSum {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/sum-of-all-subset-xor-totals/solution/yi-chong-lei-si-yu-er-jin-zhi-de-jie-fa-elpun/"></a>
     *
     * @param nums
     * @return
     */
    public static int subsetXORSum(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 总共有max种子数组情况
         */
        int max = (int) Math.pow(2, length);

        for (int i = 0; i < max; i++) {
            int xor = 0;
            /**
             * i的二进制值，i的最低位为1时，表示子数组中包括数字nums[length-1]，否则则不包括，高位以此类推
             */
            int binaryNum = i;
            int index = length - 1;
            /**
             * 逐一判断binaryNum的从低位到高位的每一位是否为1
             */
            while (binaryNum > 0) {
                if ((binaryNum & 1) == 1) {
                    /**
                     * 子数组中包括nums[index]，将nums[index]加入异或计算
                     */
                    xor ^= nums[index];
                }
                index--;
                binaryNum >>= 1;
            }
            result += xor;
        }
        return result;
    }
}
