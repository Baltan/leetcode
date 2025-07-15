package leetcode.algorithms;

/**
 * Description: 3587. Minimum Adjacent Swaps to Alternate Parity
 *
 * @author Baltan
 * @date 2025/7/13 14:00
 */
public class MinSwaps5 {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{2, 4, 6, 5, 7}));
        System.out.println(minSwaps(new int[]{2, 4, 5, 7}));
        System.out.println(minSwaps(new int[]{1, 2, 3}));
        System.out.println(minSwaps(new int[]{4, 5, 6, 8}));
    }

    public static int minSwaps(int[] nums) {
        /**
         * 数组nums中奇数的个数
         */
        int oddCount = 0;
        /**
         * 数组nums中偶数的个数
         */
        int evenCount = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        /**
         * 如果数组nums中奇数和偶数的个数之差大于1，则一定不能获得有效排列
         */
        if (Math.abs(oddCount - evenCount) > 1) {
            return -1;
        }

        if (evenCount > oddCount) {
            return help(nums, 0);
        } else if (oddCount > evenCount) {
            return help(nums, 1);
        } else {
            return Math.min(help(nums, 0), help(nums, 1));
        }
    }

    /**
     * 将数组nums变成一个有效排列，且nums[0]除以2的余数为remainder时的最小相邻交换次数
     *
     * @param nums
     * @param remainder
     * @return
     */
    public static int help(int[] nums, int remainder) {
        int result = 0;
        int position = 0;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 如果nums[i]除以2的余数为remainder，则需要将nums[i]交换到nums[position]的位置
             */
            if (nums[i] % 2 == remainder) {
                result += Math.abs(i - position);
                position += 2;
            }
        }
        return result;
    }
}
