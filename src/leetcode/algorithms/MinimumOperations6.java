package leetcode.algorithms;

/**
 * Description: 3190. Find Minimum Operations to Make All Elements Divisible by Three
 *
 * @author Baltan
 * @date 2024/6/24 22:58
 */
public class MinimumOperations6 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4}));
        System.out.println(minimumOperations(new int[]{3, 6, 9}));
    }

    public static int minimumOperations(int[] nums) {
        int result = 0;
        /**
         * 如果num%3为0，则不需要操作；如果num%3为1，则执行一次减1操作；如果num%3为1，则执行一次加1操作。所以计算不能被3整除的数字个数即可
         */
        for (int num : nums) {
            if (num % 3 != 0) {
                result++;
            }
        }
        return result;
    }
}
