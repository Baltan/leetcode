package leetcode.algorithms;

/**
 * Description: House Robber
 *
 * @author Baltan
 * @date 2018/8/8 16:23
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] numArray = new int[nums.length];

        numArray[0] = nums[0];
        numArray[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < numArray.length; i++) {
            numArray[i] = Math.max(numArray[i - 2] + nums[i], numArray[i - 1]);
        }
        return numArray[numArray.length - 1];
    }
}
