package leetcode.algorithms;

/**
 * Description: 3038. Maximum Number of Operations With the Same Score I
 *
 * @author baltan
 * @date 2024/2/27 17:16
 */
public class MaxOperations3 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 2, 1, 4, 5}));
        System.out.println(maxOperations(new int[]{3, 2, 6, 1, 4}));
    }

    public static int maxOperations(int[] nums) {
        int result = 1;
        /**
         * 每次操作的分数
         */
        int score = nums[0] + nums[1];

        for (int i = 2; i < nums.length && i + 1 < nums.length; i += 2) {
            if (nums[i] + nums[i + 1] != score) {
                break;
            }
            result++;
        }
        return result;
    }
}
