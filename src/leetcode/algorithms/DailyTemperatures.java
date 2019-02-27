package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: Daily Temperatures
 *
 * @author Baltan
 * @date 2018/8/13 09:27
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] array = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            array[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return array;
    }
}
