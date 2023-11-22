package leetcode.algorithms;

/**
 * Description: 2932. Maximum Strong Pair XOR I
 *
 * @author Baltan
 * @date 2023/11/21 21:54
 */
public class MaximumStrongPairXor {
    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maximumStrongPairXor(new int[]{10, 100}));
        System.out.println(maximumStrongPairXor(new int[]{5, 6, 25, 30}));
    }

    public static int maximumStrongPairXor(int[] nums) {
        int result = 0;
        /**
         * 枚举所有情况
         */
        for (int x : nums) {
            for (int y : nums) {
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    result = Math.max(result, x ^ y);
                }
            }
        }
        return result;
    }
}
