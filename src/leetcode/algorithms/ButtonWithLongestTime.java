package leetcode.algorithms;

/**
 * Description: 3386. Button with Longest Push Time
 *
 * @author Baltan
 * @date 2024/12/17 23:50
 */
public class ButtonWithLongestTime {
    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int[][]{{7, 1}, {19, 3}, {9, 4}, {12, 5}, {2, 8}, {15, 10}, {18, 12}, {7, 14}, {19, 16}}));
        System.out.println(buttonWithLongestTime(new int[][]{{1, 2}, {2, 5}, {3, 9}, {1, 15}}));
        System.out.println(buttonWithLongestTime(new int[][]{{10, 5}, {1, 7}}));
    }

    public static int buttonWithLongestTime(int[][] events) {
        int result = Integer.MAX_VALUE;
        /**
         * 最长一次按键的时间
         */
        int maxTime = 0;
        /**
         * 前一次按下按键的时刻
         */
        int prevTime = 0;

        for (int[] event : events) {
            int index = event[0];
            int time = event[1] - prevTime;
            prevTime = event[1];

            if (time > maxTime || (time == maxTime && index < result)) {
                result = index;
                maxTime = time;
            }
        }
        return result;
    }
}
