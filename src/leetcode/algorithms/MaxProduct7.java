package leetcode.algorithms;

/**
 * Description: 3732. Maximum Product of Three Elements After One Replacement
 *
 * @author baltan
 * @date 2026/1/14 13:33
 */
public class MaxProduct7 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-5, 7, 0}));
        System.out.println(maxProduct(new int[]{-4, -2, -1, -3}));
        System.out.println(maxProduct(new int[]{0, 10, 0}));
    }

    public static long maxProduct(int[] nums) {
        /**
         * 数组nums中所有元素绝对值的最大值
         */
        int first = Integer.MIN_VALUE;
        /**
         * 数组nums中所有元素绝对值的第二大值
         */
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            int absNum = Math.abs(num);

            if (absNum >= first) {
                second = first;
                first = absNum;
            } else if (absNum > second) {
                second = absNum;
            }
        }
        /**
         * 根据题意，替换进数组的元素范围为[-100000,100000]
         */
        return (long) first * second * 100000;
    }
}
