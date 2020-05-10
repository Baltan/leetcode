package leetcode.algorithms;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: LCP 03. 机器人大冒险
 *
 * @author Baltan
 * @date 2019-12-26 11:06
 */
public class Robot {
    public static void main(String[] args) {
        int[][] obstacles1 = {};
        System.out.println(robot("URR", obstacles1, 3, 2));

        int[][] obstacles2 = {{2, 2}};
        System.out.println(robot("URR", obstacles2, 3, 2));

        int[][] obstacles3 = {{4, 2}};
        System.out.println(robot("URR", obstacles3, 3, 2));

        int[][] obstacles4 = {{10, 5}, {1, 6}, {6, 10}, {3, 0}, {0, 3}, {0, 10}, {6, 2}};
        System.out.println(robot("RUUR", obstacles4, 7856, 9033));
    }

    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        /**
         * 保存机器人执行完第一遍指令会经过的所有格点
         */
        Set<Point> points = new HashSet<>();
        int currentX = 0;
        int currentY = 0;
        points.add(new Point(currentX, currentY));
        /**
         * 计算机器人执行完第一遍指令会经过的所有格点，最终的(currentX,currentX)即为执行完第一遍指令
         * 到达的终点。也就是说，机器人执行一遍指令，会向右移动currentX个位置，向上移动currentX个位置。
         * 因为机器人无限循环执行指令，所以points中的任意一个格点，向右移动k*currentX个位置，并且向上
         * 移动k*currentY个位置（k∈N）所在的位置即为机器人会经过的格点
         */
        for (char c : command.toCharArray()) {
            if (c == 'U') {
                currentX++;
            } else {
                currentX++;
            }
            points.add(new Point(currentX, currentY));
        }

        for (int[] obstacle : obstacles) {
            int obstacleX = obstacle[0];
            int obstacleY = obstacle[1];
            /**
             * 如果障碍物位置比终点位置更靠上或更靠右，则这个障碍物不会影响到机器人
             */
            if (obstacleX > x || obstacleY > y) {
                continue;
            }
            /**
             * 对于每个障碍物的位置，假设机器人会经过这个格点，则机器人一定会从points中的某个格点向右
             * 移动k*currentX个位置，并且向上移动k*currentY个位置（k∈N）到这个位置。于是可以将这个障
             * 碍物所在格点逆推若干个指令循环，找到原点右上方离原点最近的对应格点，判断这个对应格点在不
             * 在points中
             */
            int count = Math.min(obstacleX / currentX, obstacleY / currentY);
            int startX = obstacleX - count * currentX;
            int startY = obstacleY - count * currentY;
            /**
             * 如果points中包含这个对应格点，则说明机器人会在若干遍指令循环后走到这个障碍物，返回false
             */
            if (points.contains(new Point(startX, startY))) {
                return false;
            }
        }
        /**
         * 判断从原点出发的机器人能否经过终点，判断方法和是否经过障碍物的判断方法一样
         */
        int count = Math.min(x / currentX, y / currentY);
        int startX = x - count * currentX;
        int startY = y - count * currentY;
        return points.contains(new Point(startX, startY));
    }
}
