package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2567. Minimum Score by Changing Two Elements
 *
 * @author Baltan
 * @date 2023/2/19 14:47
 */
public class MinimizeSum {
    public static void main(String[] args) {
        System.out.println(minimizeSum(new int[]{1, 4, 3}));
        System.out.println(minimizeSum(new int[]{1, 4, 7, 8, 5}));
    }

    public static int minimizeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        /**
         * 总能通过修改数组nums中的某一个数使得nums的最小得分为0，于是只要通过修改另一个数使得nums的最大得分尽可能小即可，也就是说要减小数组
         * nums中最大值和最小值的差：
         * 1、可以将最小的两个数修改为第三小的数，则答案为nums[length-1]-nums[2]
         * 2、可以将最小的数修改为第二小的数，将最大的数修改为第二大的数，则答案为nums[length-2]-nums[1]
         * 3、可以将最大的两个数修改为第三大的数，则答案为nums[length-3]-nums[0]
         * 三种情况取nums的最大得分最小的即可
         */
        return Math.min(Math.min(nums[length - 1] - nums[2], nums[length - 2] - nums[1]), nums[length - 3] - nums[0]);
    }
}
