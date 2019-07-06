package leetcode.algorithms;

import java.util.*;

/**
 * Description: 398. Random Pick Index
 *
 * @author Baltan
 * @date 2019-07-05 22:55
 */
public class Solution5 {
    private Random rand;
    private int[] nums;

    public Solution5(int[] nums) {
        this.rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = 0;
        int count = 0;
        int randomNum;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                count++;
                randomNum = rand.nextInt(count);

                if (randomNum == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution5 solution = new Solution5(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(3));
    }
}
