package leetcode.algorithms;

/**
 * Description: 1671. Minimum Number of Removals to Make Mountain Array
 *
 * @author Baltan
 * @date 2024/11/3 19:06
 */
public class MinimumMountainRemovals {
    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{4, 3, 2, 1, 1, 2, 3, 1}));
        System.out.println(minimumMountainRemovals(new int[]{1, 3, 1}));
        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * leftLengths[i]表示子数组nums[0……i]中以nums[i]作为最后一个元素的严格递增子序列的最大长度
         */
        int[] leftLengths = new int[length];
        /**
         * rightLengths[i]表示子数组nums[i……length-1]中以nums[i]作为第一个元素的严格递减子序列的最大长度
         */
        int[] rightLengths = new int[length];
        leftLengths[0] = 1;
        rightLengths[length - 1] = 1;
        /**
         * 遍历计算以nums[i]作为最后一个元素的严格递增子序列
         */
        for (int i = 1; i < length - 1; i++) {
            leftLengths[i] = 1;

            for (int j = 0; j < i; j++) {
                /**
                 * 元素nums[i]可以追加在以nums[j]作为最后一个元素的严格递增子序列的后面，子序列的长度增加1
                 */
                if (nums[i] > nums[j]) {
                    leftLengths[i] = Math.max(leftLengths[i], leftLengths[j] + 1);
                }
            }
        }
        /**
         * 遍历计算以nums[i]作为第一个元素的严格递减子序列
         */
        for (int i = length - 2; i > 0; i--) {
            rightLengths[i] = 1;

            for (int j = length - 1; j > i; j--) {
                /**
                 * 元素nums[i]可以追加在以nums[j]作为第一个元素的严格递减子序列的最前面，子序列的长度增加1
                 */
                if (nums[i] > nums[j]) {
                    rightLengths[i] = Math.max(rightLengths[i], rightLengths[j] + 1);
                }
            }
        }
        /**
         * 遍历计算将数组nums变成以nums[i]作为最大值的山形数组时需要删除的元素个数
         */
        for (int i = 1; i < length - 1; i++) {
            /**
             * 如果leftLengths[i]为0或rightLengths[i]为0，说明nums[i]的左侧或右侧没有小于它的元素，不能作为山形数组的最大值
             */
            if (leftLengths[i] != 1 && rightLengths[i] != 1) {
                /**
                 * 山形数组的总长度为leftLengths[i]+rightLengths[i]-1
                 */
                result = Math.min(result, length - (leftLengths[i] + rightLengths[i] - 1));
            }
        }
        return result;
    }
}
