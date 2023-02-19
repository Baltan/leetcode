package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2568. Minimum Impossible OR
 *
 * @author Baltan
 * @date 2023/2/19 14:06
 */
public class MinImpossibleOR {
    public static void main(String[] args) {
        System.out.println(minImpossibleOR(new int[]{2, 1}));
        System.out.println(minImpossibleOR(new int[]{5, 3, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-impossible-or/solutions/2119478/nao-jin-ji-zhuan-wan-pythonjavacgo-by-en-7j89/"></a>
     *
     * @param nums
     * @return
     */
    public static int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        /**
         * 查找不在数组nums中的最小的2的幂2^i。因为1、2、4、……、2^(i-1)都在数组nums中，则[1,2^i-1]都可以用这部分数字通过按位或运算得到
         */
        for (int i = 0; i < 32; i++) {
            int target = 1 << i;

            if (!set.contains(target)) {
                return target;
            }
        }
        return -1;
    }
}
