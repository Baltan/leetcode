package leetcode.algorithms;

/**
 * Description: 1827. Minimum Operations to Make the Array Increasing
 *
 * @author Baltan
 * @date 2022/6/16 09:14
 */
public class MinOperations4 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 1}));
        System.out.println(minOperations(new int[]{1, 5, 2, 4, 1}));
        System.out.println(minOperations(new int[]{8}));
    }

    public static int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int result = 0;
        /**
         * 操作结束后使得每一个数都比前一个数大1即可
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result += (nums[i - 1] + 1 - nums[i]);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
