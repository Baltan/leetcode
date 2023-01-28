package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1943. Describe the Painting
 *
 * @author Baltan
 * @date 2023/1/27 15:49
 */
public class SplitPainting {
    public static void main(String[] args) {
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));
        System.out.println(splitPainting(new int[][]{{1, 7, 9}, {6, 8, 15}, {8, 10, 7}}));
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}}));
    }

    public static List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        /**
         * 保存所有线段，优先按照线段的左端点坐标升序排列，左端点坐标相同时按照右端点坐标升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        /**
         * 保存所有线段的端点坐标，并且按照升序排列
         */
        TreeSet<Integer> splits = new TreeSet<>();

        for (int[] segment : segments) {
            pq.offer(segment);
            splits.add(segment[0]);
            splits.add(segment[1]);
        }
        /**
         * 遍历splits分割出的每一个分段
         */
        while (splits.size() >= 2) {
            /**
             * 当前分段的左端点坐标
             */
            int start = splits.first();
            splits.remove(start);
            /**
             * 当前分段的右端点坐标
             */
            int end = splits.first();
            long color = 0L;

            while (!pq.isEmpty()) {
                /**
                 * 说明所有能覆盖当前分段的线段都已计算过
                 */
                if (pq.peek()[0] > start) {
                    break;
                }
                int[] segment = pq.poll();

                if (segment[1] == end) {
                    color += segment[2];
                } else if (segment[1] > end) {
                    color += segment[2];
                    /**
                     * 当前线段缩短为[end,segment[1],segment[2]]，重新加入队列参与后续分段的计算
                     */
                    segment[0] = end;
                    pq.offer(segment);
                }
            }
            /**
             * 当前分段有线段覆盖，被涂了颜色
             */
            if (color != 0L) {
                result.add(Arrays.asList(Long.valueOf(start), Long.valueOf(end), color));
            }
            splits.add(end);
        }
        return result;
    }
}
