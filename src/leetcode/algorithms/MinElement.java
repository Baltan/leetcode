package leetcode.algorithms;

/**
 * Description: 3300. Minimum Element After Replacement With Digit Sum
 *
 * @author Baltan
 * @date 2024/9/29 00:20
 */
public class MinElement {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{10, 12, 13, 14}));
        System.out.println(minElement(new int[]{1, 2, 3, 4}));
        System.out.println(minElement(new int[]{999, 19, 199}));
    }

    public static int minElement(int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int num : nums) {
            /**
             * 数字num各个数位上数字的和
             */
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            result = Math.min(result, sum);
        }
        return result;
    }
}
