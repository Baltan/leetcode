package leetcode.algorithms;

/**
 * Description: 1464. Maximum Product of Two Elements in an Array
 *
 * @author Baltan
 * @date 2022/11/4 09:45
 */
public class MaxProduct4 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 4, 5, 2}));
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(maxProduct(new int[]{3, 7}));
    }

    public static int maxProduct(int[] nums) {
        /**
         * i为数组nums中的最大值
         */
        int i = Math.max(nums[0], nums[1]);
        /**
         * j为数组nums中的次大值
         */
        int j = Math.min(nums[0], nums[1]);
        int length = nums.length;

        for (int k = 2; k < length; k++) {
            if (nums[k] >= i) {
                j = i;
                i = nums[k];
            } else if (nums[k] > j) {
                j = nums[k];
            }
        }
        return (i - 1) * (j - 1);
    }
}
