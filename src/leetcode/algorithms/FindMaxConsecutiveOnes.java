package leetcode.algorithms;

/**
 * Description:Max Consecutive Ones
 * @author Baltan
 *
 * @date 2017/11/6 22:54
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
