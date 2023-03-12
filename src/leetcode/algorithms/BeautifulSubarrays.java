package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2588. Count the Number of Beautiful Subarrays
 *
 * @author Baltan
 * @date 2023/3/12 12:50
 */
public class BeautifulSubarrays {
    public static void main(String[] args) {
        System.out.println(beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
        System.out.println(beautifulSubarrays(new int[]{1, 10, 4}));
    }

    public static long beautifulSubarrays(int[] nums) {
        long result = 0L;
        /**
         * 当数组nums的某个前缀子数组中，所有数字的二进制值中在第i位上为1的个数为偶数时，mask的第i位为0，否则为1。初始时，前缀中没有任何数字，
         * mask的值为0
         */
        int mask = 0;
        /**
         * i -> 数组nums的前缀子数组的mask值为i的前缀的个数
         */
        Map<Integer, Long> maskMap = new HashMap<>();
        /**
         * 前缀为空数组的情况
         */
        maskMap.put(mask, 1L);

        for (int num : nums) {
            int bit = 0;

            while (num != 0) {
                if ((num & 1) == 1) {
                    /**
                     * 如果num的第bit位为1，则mask的第bit位要由1变为0，或由0变为1
                     */
                    mask += (mask >> bit & 1) == 1 ? -(1 << bit) : (1 << bit);
                }
                num >>= 1;
                bit++;
            }
            long count = maskMap.getOrDefault(mask, 0L);
            /**
             * 假设数组nums的前缀子数组[0,1,……,x]和[0,1,……,y]的mask值相等，则子数组[x+1,x+2,……,y]是一个美丽子数组
             */
            result += count;
            maskMap.put(mask, count + 1);
        }
        return result;
    }
}
