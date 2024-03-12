package leetcode.algorithms;

/**
 * Description: 3065. Minimum Operations to Exceed Threshold Value I
 *
 * @author Baltan
 * @date 2024/3/12 22:16
 */
public class MinOperations20 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 1));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 9));
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        /**
         * 找到数组nums中所有小于k的元素，将其移除
         */
        for (int num : nums) {
            if (num < k) {
                result++;
            }
        }
        return result;
    }
}
