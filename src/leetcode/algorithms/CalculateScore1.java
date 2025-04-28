package leetcode.algorithms;

/**
 * Description: 3522. Calculate Score After Performing Instructions
 *
 * @author Baltan
 * @date 2025/4/28 23:24
 */
public class CalculateScore1 {
    public static void main(String[] args) {
        System.out.println(calculateScore(new String[]{"jump", "add", "add", "jump", "add", "jump"}, new int[]{2, 1, 3, 1, -2, -3}));
        System.out.println(calculateScore(new String[]{"jump", "add", "add"}, new int[]{3, 1, 1}));
        System.out.println(calculateScore(new String[]{"jump"}, new int[]{0}));
    }

    public static long calculateScore(String[] instructions, int[] values) {
        long result = 0L;
        int length = instructions.length;
        /**
         * 当前将要执行的指令
         */
        int index = 0;
        /**
         * isVisited[i]表示指令instructions[i]是否已执行过
         */
        boolean[] isVisited = new boolean[length];
        /**
         * 从指令instructions[0]开始模拟指令执行
         */
        while (index >= 0 && index < length && !isVisited[index]) {
            isVisited[index] = true;

            if ("jump".equals(instructions[index])) {
                index = index + values[index];
            } else {
                result += values[index];
                index++;
            }
        }
        return result;
    }
}
