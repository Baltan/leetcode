package leetcode.algorithms;

/**
 * Description: 1824. Minimum Sideway Jumps
 *
 * @author Baltan
 * @date 2022/6/19 13:35
 */
public class MinSideJumps {
    public static void main(String[] args) {
        System.out.println(minSideJumps(new int[]{0, 1, 2, 3, 0}));
        System.out.println(minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
        System.out.println(minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
    }

    public static int minSideJumps(int[] obstacles) {
        int result = 0;
        /**
         * 当前所处位置
         */
        int position = 0;
        /**
         * 当前所在跑道
         */
        int lane = 2;
        /**
         * 终点位置
         */
        int end = obstacles.length - 1;

        while (position < end) {
            /**
             * 如果当前跑道的下一步不会遇到障碍物，就在当前跑道一直向前走，直到走到障碍物的前一步进行一次侧跳
             */
            if (obstacles[position + 1] != lane) {
                position = nextObstacle(position + 1, lane, obstacles) - 1;
            } else {
                /**
                 * 侧跳变更跑道时，在另两条跑道中选择下一个障碍物尽可能远的跑道
                 */
                if (lane == 1) {
                    /**
                     * 第2条跑道position位置之后的下一个障碍物的位置
                     */
                    int position1 = nextObstacle(position, 2, obstacles);
                    /**
                     * 第3条跑道position位置之后的下一个障碍物的位置
                     */
                    int position2 = nextObstacle(position, 3, obstacles);

                    if (position1 >= position2) {
                        lane = 2;
                        position = position1 - 1;
                    } else {
                        lane = 3;
                        position = position2 - 1;
                    }
                } else if (lane == 2) {
                    /**
                     * 第1条跑道position位置之后的下一个障碍物的位置
                     */
                    int position1 = nextObstacle(position, 1, obstacles);
                    /**
                     * 第3条跑道position位置之后的下一个障碍物的位置
                     */
                    int position2 = nextObstacle(position, 3, obstacles);

                    if (position1 >= position2) {
                        lane = 1;
                        position = position1 - 1;
                    } else {
                        lane = 3;
                        position = position2 - 1;
                    }
                } else if (lane == 3) {
                    /**
                     * 第1条跑道position位置之后的下一个障碍物的位置
                     */
                    int position1 = nextObstacle(position, 1, obstacles);
                    /**
                     * 第2条跑道position位置之后的下一个障碍物的位置
                     */
                    int position2 = nextObstacle(position, 2, obstacles);

                    if (position1 >= position2) {
                        lane = 1;
                        position = position1 - 1;
                    } else {
                        lane = 2;
                        position = position2 - 1;
                    }
                }
                result++;
            }
        }
        return result;
    }

    /**
     * 从position位置开始，找到第lane条跑道的下一个障碍物的位置
     *
     * @param position
     * @param lane
     * @param obstacles
     * @return
     */
    public static int nextObstacle(int position, int lane, int[] obstacles) {
        while (position < obstacles.length && obstacles[position] != lane) {
            position++;
        }
        return position;
    }
}
