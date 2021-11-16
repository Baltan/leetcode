package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2069. Walking Robot Simulation II
 *
 * @author Baltan
 * @date 2021/11/16 21:39
 * @see RobotSim
 */
public class Robot1 {
    public static void main(String[] args) {
        Robot1 robot1_1 = new Robot1(6, 3);
        robot1_1.move(2);
        robot1_1.move(2);
        System.out.println(Arrays.toString(robot1_1.getPos()));
        System.out.println(robot1_1.getDir());
        robot1_1.move(2);
        robot1_1.move(1);
        robot1_1.move(4);
        System.out.println(Arrays.toString(robot1_1.getPos()));
        System.out.println(robot1_1.getDir());

        System.out.println("-----------------------");

        Robot1 robot1_2 = new Robot1(97, 98);
        System.out.println(Arrays.toString(robot1_2.getPos()));
        System.out.println(robot1_2.getDir());
        robot1_2.move(66392);
        robot1_2.move(83376);
        robot1_2.move(71796);
        robot1_2.move(57514);
        robot1_2.move(36284);
        robot1_2.move(69866);
        robot1_2.move(31652);
        robot1_2.move(32038);
        System.out.println(Arrays.toString(robot1_2.getPos()));
        System.out.println(robot1_2.getDir());
        robot1_2.move(88780);
        System.out.println(Arrays.toString(robot1_2.getPos()));
        System.out.println(robot1_2.getDir());
    }

    /**
     * 当前位置坐标
     */
    private int[] pos;
    /**
     * 方向数组
     */
    private String[] dirs;
    /**
     * dirs[dirIndex]表示当前朝向
     */
    private int dirIndex;
    private int width;
    private int height;
    /**
     * 外围走一圈的长度
     */
    private int loopLength;

    public Robot1(int width, int height) {
        pos = new int[]{0, 0};
        dirs = new String[]{"East", "North", "West", "South"};
        dirIndex = 0;
        this.width = width;
        this.height = height;
        loopLength = (width + height - 2) * 2;
    }

    public void move(int num) {
        /**
         * 实际走过的步数
         */
        int actualNum = num;
        /**
         * 走过的圈数如果大于一圈，就只考虑剩余移动不足一圈的部分
         */
        if (num >= loopLength) {
            int loopNum = num / loopLength;
            num -= loopNum * loopLength;
        }

        while (num > 0) {
            /**
             * 当前如果在四个角上，需要先逆时针旋转90度，再继续移动
             */
            if (dirIndex == 0 && pos[0] == width - 1) {
                dirIndex = 1;
            } else if (dirIndex == 1 && pos[1] == height - 1) {
                dirIndex = 2;
            } else if (dirIndex == 2 && pos[0] == 0) {
                dirIndex = 3;
            } else if (dirIndex == 3 && pos[1] == 0) {
                dirIndex = 0;
            }

            if (dirIndex == 0) {
                /**
                 * 在底边上（y=0）可以移动的最大步数
                 */
                int maxStepNum = width - 1 - pos[0];
                /**
                 * 在底边上（y=0）实际移动的步数
                 */
                int moveNum = Math.min(num, maxStepNum);
                /**
                 * 剩余还需移动的步数
                 */
                num -= moveNum;
                /**
                 * 在底边上（y=0）移动后的位置
                 */
                pos[0] += moveNum;
            } else if (dirIndex == 1) {
                /**
                 * 在右边上（x=width-1）可以移动的最大步数
                 */
                int maxStepNum = height - 1 - pos[1];
                /**
                 * 在右边上（x=width-1）实际移动的步数
                 */
                int moveNum = Math.min(num, maxStepNum);
                /**
                 * 剩余还需移动的步数
                 */
                num -= moveNum;
                /**
                 * 在右边上（x=width-1）移动后的位置
                 */
                pos[1] += moveNum;
            } else if (dirIndex == 2) {
                /**
                 * 在顶边上（y=height-1）可以移动的最大步数
                 */
                int maxStepNum = pos[0];
                /**
                 * 在顶边上（y=height-1）实际移动的步数
                 */
                int moveNum = Math.min(num, maxStepNum);
                /**
                 * 剩余还需移动的步数
                 */
                num -= moveNum;
                /**
                 * 在顶边上（y=height-1）移动后的位置
                 */
                pos[0] -= moveNum;
            } else if (dirIndex == 3) {
                /**
                 * 在左边上（x=0）可以移动的最大步数
                 */
                int maxStepNum = pos[1];
                /**
                 * 在左边上（x=0）实际移动的步数
                 */
                int moveNum = Math.min(num, maxStepNum);
                /**
                 * 剩余还需移动的步数
                 */
                num -= moveNum;
                /**
                 * 在左边上（x=0）移动后的位置
                 */
                pos[1] -= moveNum;
            }
        }
        /**
         * 如果是在移动过后最后停在了四个角上，最终的朝向是确定的（例如：开始时是[0,0]朝"East"，以后再回到[0,0]，只可能是朝"South"）
         */
        if (actualNum > 0) {
            if (pos[0] == 0 && pos[1] == 0) {
                dirIndex = 3;
            } else if (pos[0] == width - 1 && pos[1] == 0) {
                dirIndex = 0;
            } else if (pos[0] == width - 1 && pos[1] == height - 1) {
                dirIndex = 1;
            } else if (pos[0] == 0 && pos[1] == height - 1) {
                dirIndex = 2;
            }
        }
    }

    public int[] getPos() {
        return pos;
    }

    public String getDir() {
        return dirs[dirIndex];
    }
}
