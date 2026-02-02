package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3761. Minimum Absolute Distance Between Mirror Pairs
 *
 * @author baltan
 * @date 2026/1/27 16:05
 */
public class MinMirrorPairDistance {
    public static void main(String[] args) {
        System.out.println(minMirrorPairDistance(new int[]{1000000000, 1}));
        System.out.println(minMirrorPairDistance(new int[]{12, 21, 45, 33, 54}));
        System.out.println(minMirrorPairDistance(new int[]{120, 21}));
        System.out.println(minMirrorPairDistance(new int[]{21, 120}));
    }

    public static int minMirrorPairDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        /**
         * reversedNum -> 逆序遍历数组nums过程中元素reversedNum最后一次出现的索引值（即索引值的最小值）
         */
        Map<Long, Integer> map = new HashMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            int y = nums[i];
            /**
             * 长整形防止整型溢出
             */
            long weight = 1L;
            /**
             * 元素nums[i]反转后的值
             */
            long reversedNum = 0L;

            while (x > 0) {
                x /= 10;
                weight *= 10;
            }
            weight /= 10;
            /**
             * 计算元素nums[i]反转后的值
             */
            while (y > 0) {
                int remainder = y % 10;
                reversedNum += remainder * weight;
                y /= 10;
                weight /= 10;
            }
            /**
             * 数组nums中元素nums[i]的右侧存在其反转后的值reversedNum，且最近一次出现的索引值为map.get(reversedNum)
             */
            if (map.containsKey(reversedNum)) {
                result = Math.min(result, map.get(reversedNum) - i);
            }
            map.put((long) nums[i], i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
