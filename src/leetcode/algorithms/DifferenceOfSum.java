package leetcode.algorithms;

/**
 * Description: 2535. Difference Between Element Sum and Digit Sum of an Array
 *
 * @author Baltan
 * @date 2023/2/2 13:48
 */
public class DifferenceOfSum {
    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1, 15, 6, 3}));
        System.out.println(differenceOfSum(new int[]{1, 2, 3, 4}));
    }

    public static int differenceOfSum(int[] nums) {
        /**
         * 数组nums中所有数字之和
         */
        int elementSum = 0;
        /**
         * 数组nums中所有数字每一数位数字之和
         */
        int digitSum = 0;

        for (int num : nums) {
            elementSum += num;

            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        /**
         * elementSum肯定大于等于digitSum，所以两数绝对差就是elementSum-digitSum
         */
        return elementSum - digitSum;
    }
}
