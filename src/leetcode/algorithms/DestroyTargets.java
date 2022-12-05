package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2453. Destroy Sequential Targets
 *
 * @author Baltan
 * @date 2022/12/1 19:50
 */
public class DestroyTargets {
    public static void main(String[] args) {
        System.out.println(destroyTargets(new int[]{1, 5, 3, 2, 2}, 10000));
        System.out.println(destroyTargets(new int[]{3, 7, 8, 1, 1, 5}, 2));
        System.out.println(destroyTargets(new int[]{1, 3, 5, 2, 4, 6}, 2));
        System.out.println(destroyTargets(new int[]{6, 2, 5}, 100));
    }

    public static int destroyTargets(int[] nums, int space) {
        int result = Integer.MAX_VALUE;
        /**
         * 数组nums中除以space同余的元素的最大个数
         */
        int maxCount = 0;
        /**
         * 余数i -> 数组nums中除以space余数为i的元素的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * 余数i -> 数组nums中除以space余数为i的元素的最小值
         */
        Map<Integer, Integer> minValueMap = new HashMap<>();

        for (int num : nums) {
            int remainder = num % space;
            /**
             * 当前遍历过的数组nums中除以space余数为remainder的元素的个数
             */
            int count = countMap.getOrDefault(remainder, 0) + 1;
            countMap.put(remainder, count);
            /**
             * 当前遍历过的数组nums中除以space余数为remainder的元素的最小值
             */
            int minValue = Math.min(num, minValueMap.getOrDefault(remainder, Integer.MAX_VALUE));
            minValueMap.put(remainder, minValue);

            if (count > maxCount || (count == maxCount && minValue < result)) {
                result = minValue;
                maxCount = count;
            }
        }
        return result;
    }
}
