package leetcode.algorithms;

/**
 * Description: 2221. Find Triangular Sum of an Array
 *
 * @author Baltan
 * @date 2022/4/10 11:28
 */
public class TriangularSum {
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(triangularSum(new int[]{5}));
    }

    public static int triangularSum(int[] nums) {
        int length = nums.length;

        while (length > 1) {
            /**
             * 经过一轮操作后，剩余的数字个数减少1
             */
            length--;
            /**
             * 计算这轮操作过后剩余的数字
             */
            for (int i = 0; i < length; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
