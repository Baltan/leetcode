package leetcode.algorithms;

/**
 * Description: 137. Single Number II
 *
 * @author Baltan
 * @date 2020-03-21 12:19
 * @see SingleNumber
 * @see SingleNumber2
 * @see SingleNumber1
 * @see SingleNumber3
 */
public class SingleNumber4 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/single-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--31/"></a>
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        int length = nums.length;

        for (int i = 0; i < 32; i++) {
            /**
             * 数组nums中所有数字二进制表示的低位第i位上1的个数
             */
            int count = 0;

            for (int j = 0; j < length; j++) {
                if ((nums[j] & 1) == 1) {
                    count++;
                }
                nums[j] >>>= 1;
            }
            /**
             * 如果第i位上1的个数不为3的倍数，说明只出现1次的数字的二进制表示在这位上也为1
             */
            if (count % 3 != 0) {
                result += 1 << i;
            }
        }
        return result;
    }
}
