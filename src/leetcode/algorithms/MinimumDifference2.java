package leetcode.algorithms;

/**
 * Description: 3171. Find Subarray With Bitwise OR Closest to K
 *
 * @author baltan
 * @date 2024/6/19 09:15
 */
public class MinimumDifference2 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{6}, 2));
        System.out.println(minimumDifference(new int[]{1, 3, 1, 3}, 2));
        System.out.println(minimumDifference(new int[]{1, 2, 4, 5}, 3));
        System.out.println(minimumDifference(new int[]{1}, 10));
    }

    public static int minimumDifference(int[] nums, int k) {
        /**
         * 子数组中只有数字nums[0]，并且|k-nums[0]|为0，不可能令|k-or|得到更小的结果
         */
        if (nums[0] == k) {
            return 0;
        }
        /**
         * bitCounts[i]表示子数组中所有数字的二进制值中，由低到高第i位为1的数字的个数
         */
        int[] bitCounts = new int[32];
        /**
         * 子数组中所有数字按位或的值，初始化子数组中只有一个数字nums[0]
         */
        int or = nums[0];
        int lo = 0;
        int hi = 0;
        int result = Math.abs(or - k);
        int num = nums[0];
        /**
         * 子数组中数字的二进制值由低到高的位数
         */
        int bitIndex = 0;
        /**
         * 对数字nums[0]的二进制值各个位上的1计数
         */
        while (num != 0) {
            bitCounts[bitIndex] += (num & 1);
            num >>= 1;
            bitIndex++;
        }
        /**
         * 通过滑动窗口调整子数组中的数字，如果子数组为空数组或者子数组中所有数字按位或的值or小于k，则扩展子数组；如果子数组中所有数字按位或
         * 的值or大于k，则缩小子数组（因为或运算总是使得结果非减）
         */
        while (hi < nums.length) {
            if (or < k || lo == hi) {
                if (hi + 1 < nums.length) {
                    /**
                     * 子数组中增加数字nums[hi+1]
                     */
                    num = nums[hi + 1];
                    or |= num;
                    result = Math.min(result, Math.abs(or - k));
                    bitIndex = 0;
                    /**
                     * 对数字nums[hi+1]的二进制值各个位上的1计数
                     */
                    while (num != 0) {
                        bitCounts[bitIndex] += (num & 1);
                        num >>= 1;
                        bitIndex++;
                    }
                    hi++;
                } else {
                    break;
                }
            } else {
                /**
                 * 子数组中除去数字nums[lo]
                 */
                num = nums[lo];
                bitIndex = 0;
                /**
                 * 排除数字nums[lo]的二进制值各个位上的1
                 */
                while (num != 0) {
                    int bit = num & 1;
                    bitCounts[bitIndex] -= bit;
                    /**
                     * 子数组中所有数字按位或的值or之前在bitIndex为上1，除去数字nums[lo]后为0
                     */
                    if (bit == 1 && bitCounts[bitIndex] == 0) {
                        or -= (1 << bitIndex);
                    }
                    num >>= 1;
                    bitIndex++;
                }
                result = Math.min(result, Math.abs(or - k));
                lo++;
            }
            /**
             * 子数组中所有数字按位或的值or为k，则|k-or|为0，不可能令|k-or|得到更小的结果
             */
            if (result == 0) {
                break;
            }
        }
        return result;
    }
}
