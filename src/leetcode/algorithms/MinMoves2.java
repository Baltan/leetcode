package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 462. Minimum Moves to Equal Array Elements II
 *
 * @author Baltan
 * @date 2018/8/17 22:05
 */
public class MinMoves2 {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1, 2, 3}));
        System.out.println(minMoves2(new int[]{1, 99, 100}));
        System.out.println(minMoves2(new int[]{99}));
        System.out.println(minMoves2(new int[]{1, 0, 0, 8, 6}));
    }

    public static int minMoves2(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int midNum = nums[length / 2];
        int moveNum = 0;
        for (int i = 0; i < length / 2; i++) {
            moveNum += (midNum - nums[i]);
        }
        for (int i = length / 2 + 1; i < length; i++) {
            moveNum += (nums[i] - midNum);
        }
        return moveNum;
    }
}
