package leetcode.algorithms;

import java.util.*;

/**
 * Description: 218. The Skyline Problem
 *
 * @author Baltan
 * @date 2019-06-09 11:46
 */
public class GetSkyline {
    public static void main(String[] args) {
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings1));

        int[][] buildings2 = {{0, 2147483647, 2147483647}};
        System.out.println(getSkyline(buildings2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/the-skyline-problem/solutions/873171/gong-shui-san-xie-sao-miao-xian-suan-fa-0z6xc/"></a>
     *
     * @param buildings
     * @return
     */
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 保存所有左右端点的坐标
         */
        List<int[]> points = new ArrayList<>();

        for (int[] building : buildings) {
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        /**
         * 将所有左右端点按照横坐标升序排列，如果横坐标相同则按照纵坐标升序排列（此时，因为所有左端点的高度都取了负值，所以都排在了右端点前面）
         */
        Collections.sort(points, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        /**
         * 前一个矩形的高度
         */
        int prevY = 0;
        queue.offer(prevY);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (y < 0) {
                /**
                 * 如果是左端点，说明存在一条往右延伸的顶边，将高度入队
                 */
                queue.offer(-y);
            } else {
                /**
                 * 如果是右端点，说明往右延伸的顶边结束了，将高度出队
                 */
                queue.remove(y);
            }

            if (!queue.isEmpty()) {
                /**
                 * 如果当前矩形的高度不与队列中矩形的最高高度相等，说明两个矩形的顶边向右延伸不会重合，当前矩形的高度需要入队保存
                 */
                int currY = queue.peek();

                if (currY != prevY) {
                    result.add(Arrays.asList(x, currY));
                    prevY = currY;
                }
            }
        }
        return result;
    }
}
