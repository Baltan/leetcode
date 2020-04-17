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
        /**
         * 当前遍历过的位置中能到达的最远位置
         */
        int currMaxIndex = 0;

        for (int i = 0; i < nums.length && currMaxIndex >= i; i++) {
            currMaxIndex = Math.max(currMaxIndex, i + nums[i]);
            /**
             * 如果能到达的最远位置大于最后一个索引位置了，说明可以到达最后一个位置
             */
            if (currMaxIndex >= maxIndex) {
                return true;
            }
        }
        return currMaxIndex >= maxIndex;
    }
}
