package leetcode.algorithms;

/**
 * Description: 657. Robot Return to Origin
 *
 * @author Baltan
 * @date 2017/11/17 14:13
 */
public class JudgeCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }

    public static boolean judgeCircle(String moves) {
        /**
         * 机器人所在坐标
         */
        int[] position = {0, 0};
        char[] charArray = moves.toCharArray();

        for (char c : charArray) {
            if ('U' == c) {
                position[0]++;
            } else if ('D' == c) {
                position[0]--;
            } else if ('R' == c) {
                position[1]++;
            } else if ('L' == c) {
                position[1]--;
            }
        }
        /**
         * 判断最终位置的坐标是否是原点
         */
        return position[0] == 0 && position[1] == 0;
    }
}
