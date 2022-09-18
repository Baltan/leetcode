package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1654. Minimum Jumps to Reach Home
 *
 * @author Baltan
 * @date 2022/9/12 13:11
 */
public class MinimumJumps {
    public static void main(String[] args) {
        System.out.println(minimumJumps(
                new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84,
                        184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48,
                        177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98}, 29, 98, 80));
        System.out.println(minimumJumps(new int[]{18, 13, 3, 9, 8, 14}, 3, 8, 6));
        System.out.println(minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
        System.out.println(minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
        System.out.println(minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int result = 0;
        /**
         * 跳蚤不能跳到的最远的位置
         */
        int farthestForbiddenPosition = Arrays.stream(forbidden).max().getAsInt();
        /**
         * 跳蚤最远可能到达的点
         * @see
         * <a href="https://leetcode.cn/problems/minimum-jumps-to-reach-home/solution/dao-jia-de-zui-shao-tiao-yue-ci-shu-zui-duan-lu-zh/"></a>
         */
        int farthest = Math.max(farthestForbiddenPosition + a + b, x + b);
        /**
         * forbiddenPositions[i]为true表示跳蚤不能跳到的i位置，forbiddenPositions包括所有forbidden表示的位置和跳蚤已经
         * 到达过的位置
         */
        boolean[] forbiddenPositions = new boolean[farthest + 1];
        Queue<Bug> queue = new LinkedList<>();
        queue.offer(new Bug(0, false));
        forbiddenPositions[0] = true;

        for (int position : forbidden) {
            if (position <= farthest) {
                forbiddenPositions[position] = true;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Bug bug = queue.poll();

                if (bug.position == x) {
                    return result;
                }
                /**
                 * 如果跳蚤向前跳会到达的位置
                 */
                int forwardPosition = bug.position + a;
                /**
                 * 如果跳蚤向前跳不会越界，也不会跳到不能跳到的位置，则可以完成向前跳的这一步
                 */
                if (forwardPosition <= farthest && !forbiddenPositions[forwardPosition]) {
                    queue.offer(new Bug(forwardPosition, true));
                    forbiddenPositions[forwardPosition] = true;
                }

                if (bug.backward) {
                    /**
                     * 如果跳蚤向后跳会到达的位置
                     */
                    int backwardPosition = bug.position - b;
                    /**
                     * 如果跳蚤向后跳不会越界，也不会跳到不能跳到的位置，则可以完成向后跳的这一步
                     * 此处，向后跳到达的点不能标记已访问，因为根据题意从这点出发不能继续向后跳，但是实际是可能需要到达
                     * backwardPosition-b位置的
                     */
                    if (backwardPosition > 0 && !forbiddenPositions[backwardPosition]) {
                        queue.offer(new Bug(backwardPosition, false));
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static class Bug {
        /**
         * 跳蚤当前所在的位置
         */
        public int position;
        /**
         * 标记某一次跳跃是否允许跳蚤向后跳
         */
        boolean backward;

        public Bug(int position, boolean backward) {
            this.position = position;
            this.backward = backward;
        }
    }
}
