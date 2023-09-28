package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2865. Beautiful Towers I
 *
 * @author baltan
 * @date 2023/9/27 16:23
 * @see MaximumSumOfHeights1
 */
public class MaximumSumOfHeights {
    public static void main(String[] args) {
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 2, 4, 4)));
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
    }

    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long result = 0L;
        /**
         * 假设索引值为i的塔高度最高，为maxHeights[i]
         */
        for (int i = 0; i < maxHeights.size(); i++) {
            long sum = maxHeights.get(i);
            int left = maxHeights.get(i);
            int right = maxHeights.get(i);
            /**
             * 计算索引值为[0,i)的塔的最大高度
             */
            for (int j = i + 1; j < maxHeights.size(); j++) {
                /**
                 * 索引值为j的塔高度总是不大于索引值为j+1的塔，并且不大于maxHeights[j]
                 */
                int curr = Math.min(left, maxHeights.get(j));
                sum += curr;
                left = curr;
            }
            /**
             * 计算索引值为(i,maxHeights.size()-1]的塔的最大高度
             */
            for (int j = i - 1; j >= 0; j--) {
                /**
                 * 索引值为j的塔高度总是不大于索引值为j-1的塔，并且不大于maxHeights[j]
                 */
                int curr = Math.min(right, maxHeights.get(j));
                sum += curr;
                right = curr;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
