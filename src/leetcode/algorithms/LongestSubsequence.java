package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1218. Longest Arithmetic Subsequence of Given Difference（5214. 最长定差子序列）
 *
 * @author Baltan
 * @date 2019-10-09 08:47
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(longestSubsequence(arr1, 1));

        int[] arr2 = {1, 3, 5, 7};
        System.out.println(longestSubsequence(arr2, 1));

        int[] arr3 = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(longestSubsequence(arr3, -2));

        int[] arr4 = {1};
        System.out.println(longestSubsequence(arr4, 2));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            /**
             * 到当前数字为止，最长定差子序列的长度
             */
            int currentLength = map.getOrDefault(num - difference, 0) + 1;
            /**
             * 保存以当前数字作为结尾的最长定差子序列的长度
             */
            map.put(num, currentLength);
            result = Math.max(result, currentLength);
        }
        return result;
    }
}
