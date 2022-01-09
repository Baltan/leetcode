package leetcode.algorithms;

/**
 * Description: 2134. Minimum Swaps to Group All 1's Together II
 *
 * @author Baltan
 * @date 2022/1/9 13:45
 */
public class MinSwaps1 {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
        System.out.println(minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
        System.out.println(minSwaps(new int[]{1, 1, 0, 0, 1}));
        System.out.println(minSwaps(new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSwaps(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(minSwaps(new int[]{0, 0, 1, 1, 1, 1, 0, 0}));
        System.out.println(minSwaps(new int[]{1, 0, 1, 0, 1, 0, 1, 0}));
        System.out.println(minSwaps(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1}));
    }

    public static int minSwaps(int[] nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * 数组nums中1的总个数
         */
        int oneCount = 0;

        for (int num : nums) {
            if (num == 1) {
                oneCount++;
            }
        }
        /**
         * 如果数组中不包含1，则不用进行交换操作
         */
        if (oneCount == 0) {
            return 0;
        }
        /**
         * 窗口数组中0的总个数
         */
        int zeroCount = 0;
        /**
         * 前一个窗口第一个元素的索引位置
         */
        int firstIndex = 0;
        /**
         * 前一个窗口最后一个元素的索引位置
         */
        int lastIndex = oneCount - 1;

        for (int i = 0; i < oneCount; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        /**
         * 当前窗口中0的个数即需要交换操作的次数
         */
        result = Math.min(result, zeroCount);
        /**
         * 向右一步步平移窗口
         */
        for (int i = 1; i < length; i++) {
            /**
             * 平移窗口后，前一个窗口的第一个元素不再包含在窗口中，如果该元素是0，需要将当前窗口中0的个数先减去1
             */
            if (nums[firstIndex] == 0) {
                zeroCount--;
            }
            /**
             * 记录当前窗口第一个元素的索引位置
             */
            if (firstIndex + 1 == length) {
                firstIndex = 0;
            } else {
                firstIndex++;
            }
            /**
             * 计算当前窗口最后一个元素的索引位置
             */
            if (lastIndex + 1 == length) {
                lastIndex = 0;
            } else {
                lastIndex++;
            }
            /**
             * 当前窗口最后一个元素是窗口中新增的，如果该元素是0，需要将当前窗口中0的个数加上1
             */
            if (nums[lastIndex] == 0) {
                zeroCount++;
            }
            /**
             * 当前窗口中0的个数即需要交换操作的次数
             */
            result = Math.min(result, zeroCount);
        }
        return result;
    }
}
