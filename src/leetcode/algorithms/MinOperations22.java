package leetcode.algorithms;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 2344. Minimum Deletions to Make Array Divisible
 *
 * @author Baltan
 * @date 2024/5/4 23:40
 */
public class MinOperations22 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 2, 6, 2, 35, 5, 35, 2, 5, 8, 7, 3, 4}, new int[]{105, 70, 70, 175, 105, 105, 105}));
        System.out.println(minOperations(new int[]{2, 3, 2, 4, 3}, new int[]{9, 6, 9, 3, 15}));
        System.out.println(minOperations(new int[]{4, 3, 6}, new int[]{8, 2, 6, 10}));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        int result = 0;
        /**
         * 数组numsDivide中所有元素的最大公约数
         */
        int gcd = numsDivide[0];
        /**
         * 元素i -> 数组nums中元素i出现的次数
         */
        Map<Integer, Integer> countMap = new TreeMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i < numsDivide.length; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        /**
         * 从小到大遍历数组nums中的元素，直到找到第一个可以整除gcd的元素
         */
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (gcd % entry.getKey() == 0) {
                return result;
            }
            /**
             * 数组nums中的所有元素entry.getKey()都要被删除，共entry.getValue()个
             */
            result += entry.getValue();
        }
        /**
         * 如果数组nums中的所有元素都被删除，则返回-1
         */
        return result == nums.length ? -1 : result;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
