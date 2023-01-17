package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 2343. Query Kth Smallest Trimmed Number
 *
 * @author Baltan
 * @date 2023/1/16 15:54
 * @see SmallestTrimmedNumbers1
 */
public class SmallestTrimmedNumbers {
    public static void main(String[] args) {
        String[] nums1 = {"102", "473", "251", "814"};
        int[][] queries1 = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        OutputUtils.print1DIntegerArray(smallestTrimmedNumbers(nums1, queries1));

        String[] nums2 = {"24", "37", "96", "04"};
        int[][] queries2 = {{2, 1}, {2, 2}};
        OutputUtils.print1DIntegerArray(smallestTrimmedNumbers(nums2, queries2));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        int length = nums[0].length();

        for (int[] query : queries) {
            int k = query[0];
            int trim = query[1];
            Integer[] indexes = IntStream.range(0, nums.length).boxed().toArray(Integer[]::new);
            /**
             * 对数组nums的索引数组按照每个num的最右trim位数字升序排列，如果最右trim位完全相同，则按照索引值升序排列
             */
            Arrays.sort(indexes, (x, y) -> {
                for (int i = length - trim; i < length; i++) {
                    if (nums[x].charAt(i) != nums[y].charAt(i)) {
                        return nums[x].charAt(i) - nums[y].charAt(i);
                    }
                }
                return x - y;
            });
            result[index++] = indexes[k - 1];
        }
        return result;
    }
}
