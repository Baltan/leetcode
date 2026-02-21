package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3811. Number of Alternating XOR Partitions
 *
 * @author baltan
 * @date 2026/2/19 13:28
 * @see AlternatingXOR
 */
public class AlternatingXOR1 {
    public static void main(String[] args) {
        System.out.println(alternatingXOR(new int[]{2, 3, 1, 4}, 1, 5));
        System.out.println(alternatingXOR(new int[]{1, 0, 0}, 1, 0));
        System.out.println(alternatingXOR(new int[]{7}, 1, 7));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-alternating-xor-partitions/solutions/3883194/he-fa-zi-xu-lie-dppythonjavacgo-by-endle-ivxh/"></a>
     *
     * @param nums
     * @param target1
     * @param target2
     * @return
     */
    public static int alternatingXOR(int[] nums, int target1, int target2) {
        int mod = 1000000007;
        /**
         * 数组nums的前缀数组中所有元素按位异或的值
         */
        int prefixXor = 0;
        /**
         * i -> 分割数组nums按位异或的值为i的前缀子数组，满足题意且最后一段按位异或的值为target1的分割方案数
         */
        Map<Integer, Integer> map1 = new HashMap<>();
        /**
         * i -> 分割数组nums按位异或的值为i的前缀子数组，满足题意且最后一段按位异或的值为target2的分割方案数
         */
        Map<Integer, Integer> map2 = new HashMap<>();
        /**
         * 哨兵，计算得到第一个分割段时，相当于之前有一个前缀按位异或的值为0（prefixXor^target1=target1^target1=0），且最后一段按位异或
         * 的值为target2的分割方案，这样就可以让分割第一段的方案数是1
         */
        map2.put(0, 1);

        for (int i = 0; ; i++) {
            prefixXor ^= nums[i];
            /**
             * 前缀子数组nums[0……i]按题意分割后的最后一段按位异或的值为target1的方案数
             */
            int plan1 = map2.getOrDefault(prefixXor ^ target1, 0);
            /**
             * 前缀子数组nums[0……i]按题意分割后的最后一段按位异或的值为target2的方案数
             */
            int plan2 = map1.getOrDefault(prefixXor ^ target2, 0);
            map1.put(prefixXor, (map1.getOrDefault(prefixXor, 0) + plan1) % mod);
            map2.put(prefixXor, (map2.getOrDefault(prefixXor, 0) + plan2) % mod);
            /**
             * 已完成数组nums的分割
             */
            if (i == nums.length - 1) {
                return (plan1 + plan2) % mod;
            }
        }
    }
}
