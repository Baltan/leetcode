package leetcode.algorithms;

/**
 * Description: 1822. Sign of the Product of an Array
 *
 * @author Baltan
 * @date 2022/6/18 22:25
 */
public class ArraySign {
    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(arraySign(new int[]{-1, 1, -1, 1, -1}));
    }

    public static int arraySign(int[] nums) {
        /**
         * nums中负数的个数
         */
        int negativeCount = 0;

        for (int num : nums) {
            /**
             * 如果nums中包含0，则所有nums中所有元素的乘积为0，返回signFunc(0)为0
             */
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negativeCount++;
            }
        }
        /**
         * 如果nums中负数的个数为偶数，则nums中所有元素的乘积为正数，否则为负数
         */
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
