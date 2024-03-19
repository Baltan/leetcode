package leetcode.algorithms;

/**
 * Description: 3079. Find the Sum of Encrypted Integers
 *
 * @author Baltan
 * @date 2024/3/19 22:07
 */
public class SumOfEncryptedInt {
    public static void main(String[] args) {
        System.out.println(sumOfEncryptedInt(new int[]{1, 2, 3}));
        System.out.println(sumOfEncryptedInt(new int[]{10, 21, 31}));
    }

    public static int sumOfEncryptedInt(int[] nums) {
        int result = 0;
        /**
         * 数字nums[i]是n位数，其中最大数位值为m，加密后就会得到weight[n]*m。根据题意，nums[i]∈[1,1000]，所以weight[n]最多是四位数
         */
        int[] weight = {0, 1, 11, 111, 1111};

        for (int num : nums) {
            /**
             * 数字num是位数
             */
            int count = 0;
            /**
             * 数字num中的最大数位值
             */
            int max = 0;

            while (num > 0) {
                int digit = num % 10;
                num /= 10;
                count++;
                max = Math.max(max, digit);
            }
            result += max * weight[count];
        }
        return result;
    }
}
