package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Description: 636. Exclusive Time of Functions
 *
 * @author Baltan
 * @date 2020-01-10 21:51
 */
public class ExclusiveTime {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(
                exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        /**
         * 保存所有函数执行的开始日志
         */
        Stack<String[]> stack = new Stack<>();
        int length = logs.size();

        for (int i = 0; i < length; i++) {
            String[] infos = logs.get(i).split(":");
            String status = infos[1];

            if (Objects.equals(status, "start")) {
                /**
                 * 如果当前这条日志是开始日志：
                 * 1、如果stack中还有日志记录，则栈顶这条日志记录就是当前开始执行的函数的外层函数的开始
                 * 日志，两条日志的时间差就是外层函数执行已经占用的时间，记录下该时间后，将当前日志入栈；
                 * 2、如果此时stack中没有日志，直接将当前日志入栈
                 *
                 * 如果当前这条日志是结束日止，则stack中一定有日志记录，且栈顶这条日志记录就是当前函数
                 * 的开始日志，将栈顶的日志记录出栈，这两条日志的时间差就是当前函数执行占用的时间。此时
                 * 如果stack中还有日志记录，说明当前函数还有外层函数，栈顶的日志记录就是外层函数的开始
                 * 日志，在当前函数执行完成后，外层函数重新开始执行，所以将栈顶外层函数的开始时间更新为
                 * 当前函数的结束时间加1，用于计算外层函数在当前函数执行完成后执行的时间
                 */
                if (!stack.isEmpty()) {
                    String[] prevInfos = stack.peek();
                    /**
                     * 外层函数id
                     */
                    int prevFunctionId = Integer.valueOf(prevInfos[0]);
                    /**
                     * 外层函数的开始时间
                     */
                    int prevStartTime = Integer.valueOf(prevInfos[2]);
                    /**
                     * 当前函数的开始时间
                     */
                    int currStartTime = Integer.valueOf(infos[2]);
                    /**
                     * 外层函数执行已经占用的时间
                     */
                    result[prevFunctionId] += (currStartTime - prevStartTime);
                    stack.push(infos);
                } else {
                    stack.push(infos);
                }
            } else {
                String[] startInfos = stack.pop();
                /**
                 * 当前函数id
                 */
                int currFunctionId = Integer.valueOf(infos[0]);
                /**
                 * 当前函数的开始时间
                 */
                int currStartTime = Integer.valueOf(startInfos[2]);
                /**
                 * 当前函数的结束时间
                 */
                int currEndTime = Integer.valueOf(infos[2]);
                /**
                 * 当前函数执行占用的时间
                 */
                result[currFunctionId] += (currEndTime - currStartTime + 1);
                /**
                 * 如果stack中还有日志记录，说明当前函数还有外层函数，栈顶的日志记录就是外层函数的开始
                 * 日志，在当前函数执行完成后，外层函数重新开始执行，所以将栈顶外层函数的开始时间更新为
                 * 当前函数的结束时间加1，用于计算外层函数在当前函数执行完成后执行的时间
                 */
                if (!stack.isEmpty()) {
                    String[] prevInfos = stack.pop();
                    prevInfos[2] = String.valueOf(currEndTime + 1);
                    stack.push(prevInfos);
                }
            }
        }
        return result;
    }
}
