package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3719. Longest Balanced Subarray I
 *
 * @author Baltan
 * @date 2026/1/2 16:35
 */
public class LongestBalanced1 {
    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{2, 5, 4, 3}));
        System.out.println(longestBalanced(new int[]{3, 2, 2, 5, 4}));
        System.out.println(longestBalanced(new int[]{1, 2, 3, 2}));
    }

    public static int longestBalanced(int[] nums) {
        int result = 0;
        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < length; i++) {
            /**
             * isVisited[x]表示子数组nums[i……j]中是否包含元素x
             */
            boolean[] isVisited = new boolean[max + 1];
            /**
             * 子数组nums[i……j]中不同偶数元素和不同奇数元素的个数之差
             */
            int countDiff = 0;

            for (int j = i; j < length; j++) {
                if (!isVisited[nums[j]]) {
                    isVisited[nums[j]] = true;
                    countDiff += (nums[j] & 1) == 0 ? 1 : -1;
                }

                if (countDiff == 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}
