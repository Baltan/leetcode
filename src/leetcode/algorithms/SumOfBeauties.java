package leetcode.algorithms;

/**
 * Description: 2012. Sum of Beauty in the Array
 *
 * @author Baltan
 * @date 2021/12/3 17:46
 */
public class SumOfBeauties {
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{2, 2, 6}));
        System.out.println(sumOfBeauties(new int[]{1, 2, 3}));
        System.out.println(sumOfBeauties(new int[]{2, 4, 6, 4}));
        System.out.println(sumOfBeauties(new int[]{3, 2, 1}));
    }

    public static int sumOfBeauties(int[] nums) {
        int result = 0;
        int length = nums.length;
        int lastIndex = length - 2;
        /**
         * maxArray[i]表示从nums[0]到nums[i-1]的最大值
         */
        int[] maxArray = new int[length + 1];
        /**
         * minArray[i]表示从nums[i]到nums[length-1]的最小值
         */
        int[] minArray = new int[length + 1];
        maxArray[0] = Integer.MIN_VALUE;
        minArray[length] = Integer.MAX_VALUE;
        /**
         * 从左至右依次生成到nums[i]为止的最大值
         */
        for (int i = 1; i <= length; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], nums[i - 1]);
        }
        /**
         * 从右至左依次生成到nums[i]为止的最小值
         */
        for (int i = length - 1; i >= 0; i--) {
            minArray[i] = Math.min(minArray[i + 1], nums[i]);
        }

        for (int i = 1; i <= lastIndex; i++) {
            if (nums[i] > maxArray[i] && nums[i] < minArray[i + 1]) {
                result += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                result += 1;
            }
        }
        return result;
    }
}
