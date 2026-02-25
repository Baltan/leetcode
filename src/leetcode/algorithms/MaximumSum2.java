package leetcode.algorithms;

/**
 * Description: 3780. Maximum Sum of Three Numbers Divisible by Three
 *
 * @author baltan
 * @date 2026/2/8 16:17
 */
public class MaximumSum2 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{4, 2, 3, 1}));
        System.out.println(maximumSum(new int[]{2, 1, 5}));

    }

    public static int maximumSum(int[] nums) {
        int result = 0;
        /**
         * help[i][0]、help[i][1]、help[i][2]依次表示数组nums中除以3的余数为i的最大、第二大、第三大的元素。根据题意，nums[i]∈
         * [1,100000]，当help[i][j]为0时，表示满足的元素不存在
         */
        int[][] help = new int[3][3];

        for (int num : nums) {
            int remainder = num % 3;

            if (num >= help[remainder][0]) {
                help[remainder][2] = help[remainder][1];
                help[remainder][1] = help[remainder][0];
                help[remainder][0] = num;
            } else if (num >= help[remainder][1]) {
                help[remainder][2] = help[remainder][1];
                help[remainder][1] = num;
            } else if (num >= help[remainder][2]) {
                help[remainder][2] = num;
            }
        }
        /**
         * 三元组中的元素除以3的余数都为i的情况
         */
        for (int i = 0; i < 3; i++) {
            if (help[i][0] != 0 && help[i][1] != 0 && help[i][2] != 0) {
                result = Math.max(result, help[i][0] + help[i][1] + help[i][2]);
            }
        }
        /**
         * 三元组中的元素除以3的余数分别为0、1、2的情况
         */
        if (help[0][0] != 0 && help[1][0] != 0 && help[2][0] != 0) {
            result = Math.max(result, help[0][0] + help[1][0] + help[2][0]);
        }
        return result;
    }
}
