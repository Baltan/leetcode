package leetcode.algorithms;

/**
 * Description: 2148. Count Elements With Strictly Smaller and Greater Elements
 *
 * @author Baltan
 * @date 2022/1/24 10:27
 */
public class CountElements {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{11, 7, 2, 15}));
        System.out.println(countElements(new int[]{-3, 3, 3, 90}));
    }

    public static int countElements(int[] nums) {
        int result = 0;
        /**
         * 数组nums中的最小值
         */
        int min = Integer.MAX_VALUE;
        /**
         * 数组nums中的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * 查找数组nums中最小值和最大值
         */
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            /**
             * 非最小值和最大值的数字num符合要求，因为可以保证最小值min严格小于num，最大值max严格大于num
             */
            if (num != min && num != max) {
                result++;
            }
        }
        return result;
    }
}
