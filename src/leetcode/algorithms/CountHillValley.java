package leetcode.algorithms;

/**
 * Description: 2210. Count Hills and Valleys in an Array
 *
 * @author Baltan
 * @date 2022/3/23 00:23
 */
public class CountHillValley {
    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(countHillValley(new int[]{6, 6, 5, 5, 4, 1}));
    }

    public static int countHillValley(int[] nums) {
        int result = 0;
        /**
         * 峰谷可能的最小索引位置
         */
        int first = 1;
        /**
         * 峰谷可能的最大索引位置
         */
        int last = nums.length - 2;

        for (int i = first; i <= last; i++) {
            /**
             * 当前位置可能不是峰谷，或者和前一个位置同为一个峰谷，不需要判断
             */
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            /**
             * 左边不等于nums[i]的邻居的位置
             */
            int leftPos = i;
            /**
             * 右边不等于nums[i]的邻居的位置
             */
            int rightPos = i;

            while (leftPos >= first && nums[leftPos] == nums[i]) {
                leftPos--;
            }

            while (rightPos <= last && nums[rightPos] == nums[i]) {
                rightPos++;
            }
            /**
             * 判断左右是否同时存在不相等的邻居，并且两个邻居同时小于nums[i]或者大于nums[i]
             */
            if ((nums[i] - nums[leftPos]) * (nums[i] - nums[rightPos]) > 0) {
                result++;
            }
        }
        return result;
    }
}
