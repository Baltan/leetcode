package leetcode.algorithms;

/**
 * Description: 453. Minimum Moves to Equal Array Elements
 *
 * @author Baltan
 * @date 2018/1/2 15:51
 */
public class MinMoves {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 3}));
    }

    public static int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
