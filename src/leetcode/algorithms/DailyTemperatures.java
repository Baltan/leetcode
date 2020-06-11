package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 739. Daily Temperatures
 *
 * @author Baltan
 * @date 2018/8/13 09:27
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/"></a>
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        /**
         * 保存索引的单调栈，栈顶的索引对应的温度始终为是最高的
         */
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length - 1; i >= 0; i--) {
            /**
             * 将栈顶低于当前索引对应的温度的索引都出栈
             */
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
