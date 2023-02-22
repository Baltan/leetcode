package leetcode.algorithms;

/**
 * Description: 2293. Min Max Game
 *
 * @author Baltan
 * @date 2023/2/17 09:38
 */
public class MinMaxGame {
    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println(minMaxGame(new int[]{3}));
    }

    public static int minMaxGame(int[] nums) {
        int length = nums.length;

        while (length != 1) {
            /**
             * 算法过程结束后，数组的长度减半，后续只用前半部分数组保存计算得到的结果
             */
            length >>= 1;

            for (int i = 0; i < length; i++) {
                if ((i & 1) == 0) {
                    nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
        }
        return nums[0];
    }
}
