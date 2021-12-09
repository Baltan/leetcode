package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2007. Find Original Array From Doubled Array
 *
 * @author Baltan
 * @date 2021/12/9 14:15
 */
public class FindOriginalArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findOriginalArray(new int[]{0, 1, 0, 0}));
        OutputUtils.print1DIntegerArray(findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}));
        OutputUtils.print1DIntegerArray(findOriginalArray(new int[]{6, 3, 0, 1}));
        OutputUtils.print1DIntegerArray(findOriginalArray(new int[]{1}));
    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }

        int[] result = new int[changed.length / 2];
        int index = 0;
        /**
         * i -> changed中i出现的次数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        Arrays.sort(changed);

        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        /**
         * 从小到大依次在changed中查找num和num的两倍值
         */
        for (int num : changed) {
            if (countMap.get(num) == 0) {
                continue;
            }

            int doubleValue = num * 2;
            /**
             * 将num从changed中移除
             */
            countMap.put(num, countMap.get(num) - 1);
            /**
             * 如果num的两倍值在changed中不存在了，说明符合条件的原始数组不存在
             */
            if (!countMap.containsKey(doubleValue) || countMap.get(doubleValue) == 0) {
                return new int[0];
            }
            /**
             * 将num的两倍值从changed中移除
             */
            countMap.put(doubleValue, countMap.get(doubleValue) - 1);
            result[index++] = num;
        }
        return result;
    }
}
