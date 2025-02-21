package leetcode.algorithms;

/**
 * Description: 3452. Sum of Good Numbers
 *
 * @author Baltan
 * @date 2025/2/21 23:33
 */
public class SumOfGoodNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfGoodNumbers(new int[]{1, 3, 2, 1, 5, 4}, 2));
        System.out.println(sumOfGoodNumbers(new int[]{2, 1}, 1));
    }

    public static int sumOfGoodNumbers(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        /**
         * 逐个判断nums[i]
         */
        for (int i = 0; i < length; i++) {
            if (i - k >= 0 && nums[i - k] >= nums[i]) {
                continue;
            }

            if (i + k < length && nums[i + k] >= nums[i]) {
                continue;
            }
            result += nums[i];
        }
        return result;
    }
}
