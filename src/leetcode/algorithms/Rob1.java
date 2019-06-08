package leetcode.algorithms;

/**
 * Description: 213. House Robber II
 *
 * @author Baltan
 * @date 2019-06-08 09:23
 */
public class Rob1 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{0, 0}));
        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int length = nums.length - 1;
        int[] help1 = new int[length];
        int[] help2 = new int[length];
        help1[0] = nums[0];
        help1[1] = Math.max(nums[0], nums[1]);
        help2[0] = nums[1];
        help2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < length; i++) {
            help1[i] = Math.max(help1[i - 2] + nums[i], help1[i - 1]);
            help2[i] = Math.max(help2[i - 2] + nums[i + 1], help2[i - 1]);
        }
        return Math.max(help1[length - 1], help2[length - 1]);
    }
}
