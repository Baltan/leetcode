package leetcode.algorithms;

/**
 * Description: 2342. Max Sum of a Pair With Equal Sum of Digits
 *
 * @author Baltan
 * @date 2023/1/16 16:27
 */
public class MaximumSum1 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));
    }

    public static int maximumSum(int[] nums) {
        int result = -1;
        /**
         * help[i]表示各个数位和为i的已遍历到的最大数字，按照题意，nums[i]∈[1,1000000000]，所以nums[i]的各个数位和的最大值为81（即当
         * nums[i]为999999999时）
         */
        int[] help = new int[9 * 9 + 1];

        for (int num : nums) {
            /**
             * 数字num的各个数位的和
             */
            int sum = getSum(num);
            /**
             * num和help[sum]各个数位和相同，可以构成一个数对
             */
            if (help[sum] != 0) {
                result = Math.max(result, help[sum] + num);
            }
            /**
             * 更新各个数位和为sum的最大数字
             */
            help[sum] = Math.max(help[sum], num);
        }
        return result;
    }

    /**
     * 计算数字num的各个数位的和
     *
     * @param num
     * @return
     */
    public static int getSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
