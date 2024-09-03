package leetcode.algorithms;

/**
 * Description: 2366. Minimum Replacements to Sort the Array
 *
 * @author baltan
 * @date 2024/9/2 13:43
 */
public class MinimumReplacement {
    public static void main(String[] args) {
        System.out.println(minimumReplacement(new int[]{12, 9, 7, 6, 17, 19, 21}));
        System.out.println(minimumReplacement(new int[]{3, 9, 3}));
        System.out.println(minimumReplacement(new int[]{1, 2, 3, 4, 5}));
    }

    public static long minimumReplacement(int[] nums) {
        long result = 0L;
        /**
         * 倒序遍历数组nums并拆分元素后得到的最小值，前缀中的元素拆分后的数字都不会大于这个最小值
         */
        int min = Integer.MAX_VALUE;
        /**
         * 贪心思想，保证数组后面的数字尽可能地大
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            /**
             * 如果当前数字本身就不大于后一个数字，则不用进行拆分
             */
            if (nums[i] <= min) {
                min = nums[i];
                continue;
            }
            int quotient = nums[i] / min;
            int remainder = nums[i] - quotient * min;
            /**
             * 当前数字nums[i]至少需要被拆分的份数
             */
            int parts = remainder == 0 ? quotient : quotient + 1;
            result += parts - 1;
            /**
             * 将nums[i]拆分为parts个数字后，需要保证拆分后最前面的数字尽可能地大，则应当将nums[i]尽可能均匀地拆分
             */
            min = nums[i] / parts;
        }
        return result;
    }
}
