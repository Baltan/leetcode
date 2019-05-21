package leetcode.algorithms;

/**
 * Description: 1041. Robot Bounded In Circle
 *
 * @author Baltan
 * @date 2019-05-13 13:58
 */
public class IsRobotBounded {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }

    public static boolean isRobotBounded(String instructions) {
        /**
         * 0-N,1-E,2-S,3-W
         */
        int[] directions = {0, 1, 2, 3};
        int direction = directions[0];
        int[] moves = new int[4];
        int length = instructions.length();

        for (int i = 0; i < length; i++) {
            char instruction = instructions.charAt(i);
            if (instruction == 'G') {
                moves[direction]++;
            } else if (instruction == 'L') {
                /**
                 * direction = (direction + 3) % 4
                 */
                direction = (direction + 3) & 3;
            } else {
                /**
                 * direction = (direction + 1) % 4
                 */
                direction = (direction + 1) & 3;
            }
        }

        if (moves[0] == moves[2] && moves[1] == moves[3]) {
            return true;
        } else if (direction != 0) {
            return true;
        } else {
            return false;
        }
    }
}
