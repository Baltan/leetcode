package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1051. Height Checker
 *
 * @author Baltan
 * @date 2019-05-26 12:26
 */
public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(heightChecker(new int[]{1}));
        System.out.println(heightChecker(new int[]{2, 1}));
    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int length = heights.length;
        int[] sortArray = Arrays.copyOf(heights, length);
        Arrays.sort(sortArray);

        for (int i = 0; i < length; i++) {
            if (heights[i] != sortArray[i]) {
                count++;
            }
        }
        return count;
    }
}
