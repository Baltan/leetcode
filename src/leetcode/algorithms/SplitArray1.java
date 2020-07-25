package leetcode.algorithms;

/**
 * Description: 410. Split Array Largest Sum
 *
 * @author Baltan
 * @date 2020-07-25 23:31
 * @see SplitArray
 */
public class SplitArray1 {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1, 2147483647}, 2));
        System.out.println(splitArray(new int[]{1, 2147483646}, 1));
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(
                splitArray(new int[]{7, 4, 3, 22, 5, 7, 8, 24, 2, 18, 5, 13, 43, 76, 13, 46, 68, 24, 10}, 4));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/split-array-largest-sum/solution/fen-ge-shu-zu-de-zui-da-zhi-by-leetcode-solution/"></a>
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray(int[] nums, int m) {
        /**
         * 子数组的和至少为nums中的最大值，即将这个最大值单独作为一个子数组
         */
        int max = Integer.MIN_VALUE;
        /**
         * 子数组的和至多为nums中所有元素的和，即将nums本身作为唯一的一个子数组。注意：sum以及下面的变量lo、hi、
         * result都要初始化为long类型，否则可能会发生整型溢出
         */
        long sum = 0L;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        long lo = max;
        long hi = sum;
        long result = hi;
        /**
         * 二分法
         */
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            /**
             * 如果可以将nums分割成m个连续的子数组使得每个子数组的和不超过mid，则可以缩小子数组的和继续尝试，否则要
             * 增大子数组的和
             */
            if (split(nums, m, mid)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) result;
    }

    /**
     * 判断能否将nums分割成m个连续的子数组使得每个子数组的和不超过sum
     *
     * @param nums
     * @param m
     * @param sum
     * @return
     */
    public static boolean split(int[] nums, int m, long sum) {
        /**
         * 当前这个子数组中所有元素的和
         */
        int currentSum = 0;
        /**
         * 分割的子数组的个数
         */
        int sectionCount = 1;

        for (int num : nums) {
            /**
             * 如当前子数组中加入num还是不会超过sum，就将num加入当前子数组，否则需要重新创建一个新的子数组
             */
            if (currentSum + num <= sum) {
                currentSum += num;
            } else {
                /**
                 * 创建新的子数组，将num加入
                 */
                currentSum = num;
                /**
                 * 子数组的个数加1
                 */
                sectionCount++;
            }
        }
        /**
         * 只要最终分割的子数组的个数sectionCount不超过m个，就可以实现将nums分割成m个连续的子数组并且使得每个子
         * 数组的和不超过sum
         */
        return sectionCount <= m;
    }
}
