package leetcode.algorithms;

/**
 * Description: 55. Jump Game
 *
 * @author Baltan
 * @date 2018/9/17 10:09
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int maxIndex = nums.length - 1;
        int currMaxIndex = 0;
        for (int i = 0; i < nums.length && currMaxIndex >= i; i++) {
            int index = i + nums[i];
            currMaxIndex = index > currMaxIndex ? index : currMaxIndex;
            if (currMaxIndex >= maxIndex) {
                return true;
            }
        }
        return currMaxIndex >= maxIndex;
    }
}
