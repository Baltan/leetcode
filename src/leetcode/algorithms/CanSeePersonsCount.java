package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 1944. Number of Visible People in a Queue
 *
 * @author Baltan
 * @date 2022/2/17 09:05
 */
public class CanSeePersonsCount {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9}));
        OutputUtils.print1DIntegerArray(canSeePersonsCount(new int[]{5, 1, 2, 3, 10}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/number-of-visible-people-in-a-queue/solution/dan-diao-zhan-de-ying-yong-by-endlessche-pdub/"></a>
     *
     * @param heights
     * @return
     */
    public static int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] result = new int[length];
        /**
         * 单调栈，栈顶到栈底索引对应用户的身高单调递增
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(length - 1);

        for (int i = length - 2; i >= 0; i--) {
            /**
             * 所有身高小于当前用户身高的栈顶索引对应的用户都能被当前用户看到
             */
            int currHeight = heights[i];

            while (!stack.isEmpty() && currHeight > heights[stack.peek()]) {
                /**
                 * 对于索引值小于i的当前用户左边的用户，看不到能被当前用户向右看到的用户，因为那些右边的用户身高都小于当前用户，
                 * 会被当前用户挡住，所以这部分已被看到的用户不影响更左边的用户的判断，直接出栈
                 */
                stack.pop();
                result[i]++;
            }
            /**
             * 除了当前用户直接相邻的右边那部分比他矮的用户可以被看到外，栈中还有元素，说明他右边存在一个比他高的用户，该用户也能
             * 被看到
             */
            if (!stack.isEmpty()) {
                result[i]++;
            }
            /**
             * 当前用户索引入栈，继续维持单调栈结构，用于第i-1个用户的判断
             */
            stack.push(i);
        }
        return result;
    }
}
