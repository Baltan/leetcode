package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 3755. Find Maximum Balanced XOR Subarray Length
 *
 * @author baltan
 * @date 2026/1/26 10:38
 */
public class MaxBalancedSubarray {
    public static void main(String[] args) {
        System.out.println(maxBalancedSubarray(new int[]{3, 1, 3, 2, 0}));
        System.out.println(maxBalancedSubarray(new int[]{3, 2, 8, 5, 4, 14, 9, 15}));
        System.out.println(maxBalancedSubarray(new int[]{0}));
    }

    public static int maxBalancedSubarray(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * evenCounts[i+1]表示数组nums的前i个元素中偶数的个数
         */
        int[] evenCounts = new int[length + 1];
        /**
         * oddCounts[i+1]表示数组nums的前i个元素中奇数的个数
         */
        int[] oddCounts = new int[length + 1];
        /**
         * xor -> 数组nums中所有元素按位异或值为xor的前缀子数组中最后一个元素的索引值的集合
         */
        Map<Integer, List<Integer>> xorMap = new HashMap<>();
        /**
         * 数组nums的前缀子数组中所有元素按位异或值
         */
        int prefixXor = 0;
        /**
         * 哨兵，数组nums的前缀子数组为空数组时的情况
         */
        xorMap.computeIfAbsent(0, x -> new ArrayList<>()).add(-1);

        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];
            List<Integer> indexes = xorMap.computeIfAbsent(prefixXor, x -> new ArrayList<>());
            /**
             * 计算数组nums的前缀子数组nums[0……i]中奇数元素和偶数元素的个数
             */
            if (nums[i] % 2 == 0) {
                evenCounts[i + 1] = evenCounts[i] + 1;
                oddCounts[i + 1] = oddCounts[i];
            } else {
                oddCounts[i + 1] = oddCounts[i] + 1;
                evenCounts[i + 1] = evenCounts[i];
            }
            /**
             * 前缀子数组nums[0……i]和nums[0……index]中所有元素按位异或值相等，则子数组nums[i+1……index]中所有元素按位异或值为0，如果子
             * 数组中奇数元素和偶数元素的个数相等，则说明nums[i+1……index]是一个平衡异或子数组
             */
            for (int index : indexes) {
                if (evenCounts[i + 1] - evenCounts[index + 1] == oddCounts[i + 1] - oddCounts[index + 1]) {
                    result = Math.max(result, i - index);
                    break;
                }
            }
            indexes.add(i);
        }
        return result;
    }
}
