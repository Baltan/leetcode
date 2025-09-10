package leetcode.algorithms;

/**
 * Description: 3637. Trionic Array I
 *
 * @author baltan
 * @date 2025/9/4 16:38
 */
public class IsTrionic {
    public static void main(String[] args) {
        System.out.println(isTrionic(new int[]{1, 2, 3}));
        System.out.println(isTrionic(new int[]{5, 9, 1, 7}));
        System.out.println(isTrionic(new int[]{1, 3, 5, 4, 2, 6}));
        System.out.println(isTrionic(new int[]{2, 1, 3}));
        System.out.println(isTrionic(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public static boolean isTrionic(int[] nums) {
        /**
         * 数组中极大值的个数
         */
        int topCount = 0;
        /**
         * 数组中极小值的个数
         */
        int bottomCount = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            /**
             * 相邻两数相等，不满足三段式数组的特征
             */
            if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                return false;
            }
            /**
             * nums[i]为一个极大值
             */
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                topCount++;
                /**
                 * 极大值的个数多余1个，不满足三段式数组的特征
                 */
                if (topCount > 1) {
                    return false;
                }
            }
            /**
             * nums[i]为一个极小值
             */
            if (nums[i - 1] > nums[i] && nums[i + 1] > nums[i]) {
                /**
                 * 极小值先于极大值出现，不满足三段式数组的特征
                 */
                if (topCount == 0) {
                    return false;
                }
                bottomCount++;
                /**
                 * 极小值的个数多余1个，不满足三段式数组的特征
                 */
                if (bottomCount > 1) {
                    return false;
                }
            }
        }
        /**
         * 数组中恰好有一个极大值和一个极小值，并且极大值先于极小值出现时，满足三段式数组的特征
         */
        return topCount == 1 && bottomCount == 1;
    }
}
