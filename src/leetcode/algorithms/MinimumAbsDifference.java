package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1200. Minimum Absolute Difference
 *
 * @author Baltan
 * @date 2019-09-23 10:06
 */
public class MinimumAbsDifference {
    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new LinkedList<>();
        /**
         * 当前两数之差绝对值的最小值
         */
        int minDifference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            /**
             * 如果当前两数之差绝对值比之前的两数之差绝对值最小值更小，清空结果List将当前数对加入结果List，
             * 如果当前两数之差绝对值和之前的两数之差绝对值最小值相等，将当前数对加入结果List
             */
            if (arr[i] - arr[i - 1] < minDifference) {
                minDifference = arr[i] - arr[i - 1];
                result = new LinkedList<>();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] == minDifference) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}
