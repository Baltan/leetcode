package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 面试题57 - II. 和为s的连续正数序列
 *
 * @author Baltan
 * @date 2020-03-06 11:56
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(findContinuousSequence(9));
        OutputUtils.print2DIntegerArray(findContinuousSequence(15));
    }

    public static int[][] findContinuousSequence(int target) {
        Stack<int[]> stack = new Stack<>();
        int doubleTarget = target << 1;
        /**
         * 从项数为2的连续正整数序列开始逐一尝试，项数越少首个数字越大
         */
        for (int itemCount = 2; ; itemCount++) {
            /**
             * 如果从1开始连续itemCount项的连续正整数序列的各项之和大于doubleTarget，则更多
             * 项的连续正整数序列的各项之和更加大于doubleTarget，所以不用再继续计算
             */
            if ((1 + itemCount) * itemCount > doubleTarget) {
                break;
            }
            /**
             * ∵ 求和公式(首项+末项)*项数/2=和
             * ∴ 2*和=(首项+末项)*项数
             * 则doubleTarget应该为项数的整数倍
             */
            if (doubleTarget % itemCount == 0) {
                /**
                 * 首项和末项之和
                 */
                int sum = doubleTarget / itemCount;
                /**
                 * 末项和首项之差
                 */
                int difference = itemCount - 1;
                /**
                 * 首项的值
                 */
                double firstItem = (sum - difference) / 2.0;
                /**
                 * 如果首项的值是一个正整数，则找到了一个符合条件的序列
                 */
                if (firstItem % 1 == 0) {
                    int[] arr = new int[itemCount];
                    /**
                     * 填充连续正整数序列
                     */
                    for (int i = 0; i < itemCount; i++) {
                        arr[i] = (int) (i + firstItem);
                    }
                    stack.push(arr);
                }
            }
        }

        int size = stack.size();
        int[][] result = new int[size][];

        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
