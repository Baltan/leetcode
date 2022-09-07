package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1679. Max Number of K-Sum Pairs
 *
 * @author Baltan
 * @date 2022/9/4 14:32
 * @see MaxOperations1
 */
public class MaxOperations {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        int result = 0;
        /**
         * 数字i -> i在数组nums中出现的次数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        int halfK = k / 2;
        /**
         * 计算每个数字在数组nums中出现的次数
         */
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (num > halfK) {
                continue;
            }
            int otherNum = k - num;

            if (num != otherNum) {
                int otherCount = countMap.getOrDefault(otherNum, 0);
                result += Math.min(count, otherCount);
            } else {
                result += count / 2;
            }
        }
        return result;
    }
}
