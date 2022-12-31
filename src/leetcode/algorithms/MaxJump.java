package leetcode.algorithms;

/**
 * Description: 2498. Frog Jump II
 *
 * @author Baltan
 * @date 2022/12/15 16:10
 */
public class MaxJump {
    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{0, 3}));
        System.out.println(maxJump(new int[]{0, 2, 5, 6, 7}));
        System.out.println(maxJump(new int[]{0, 3, 9}));
    }

    public static int maxJump(int[] stones) {
        /**
         * 如果只有两块石头，直接从第一块石头跳到最后一块石头
         */
        if (stones.length == 2) {
            return stones[1];
        }
        int result = Integer.MIN_VALUE;
        int length = stones.length;
        /**
         * 隔一块石头跳一次
         */
        for (int i = 2; i < length; i++) {
            result = Math.max(result, stones[i] - stones[i - 2]);
        }
        return result;
    }
}
