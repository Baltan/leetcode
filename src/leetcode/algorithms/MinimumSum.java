package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2160. Minimum Sum of Four Digit Number After Splitting Digits
 *
 * @author Baltan
 * @date 2022/2/15 14:21
 */
public class MinimumSum {
    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
    }

    public static int minimumSum(int num) {
        /**
         * 保存num中四个数位上的数字
         */
        int[] nums = new int[4];
        int index = 0;

        while (num != 0) {
            nums[index++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums);
        /**
         * 将四个数字中最小的两个放十位，最大的两个放个位
         */
        return nums[0] * 10 + nums[1] * 10 + nums[2] + nums[3];
    }
}
