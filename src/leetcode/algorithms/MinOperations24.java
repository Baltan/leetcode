package leetcode.algorithms;

/**
 * Description: 3192. Minimum Operations to Make Binary Array Elements Equal to One II
 *
 * @author baltan
 * @date 2024/6/27 14:19
 */
public class MinOperations24 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 1, 1, 0, 1}));
        System.out.println(minOperations(new int[]{1, 0, 0, 0}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        /**
         * 此前是否已进行偶数次操作
         */
        boolean evenOperations = true;

        for (int num : nums) {
            /**
             * 如果num一开始为0，并且此前已对num进行偶数次反转操作，则当前num仍为0，需要进行一次反转操作；如果num一开始为1，并且此前已对
             * num进行奇数次反转操作，则当前num变为0，需要进行一次反转操作
             */
            if ((num == 0 && evenOperations) || (num == 1 && !evenOperations)) {
                result++;
                evenOperations = !evenOperations;
            }
        }
        return result;
    }
}
