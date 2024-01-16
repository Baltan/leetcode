package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 765. Couples Holding Hands
 *
 * @author Baltan
 * @date 2024/1/14 18:14
 */
public class MinSwapsCouples {
    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0, 2, 4, 6, 7, 1, 3, 5}));
        System.out.println(minSwapsCouples(new int[]{5, 4, 2, 6, 3, 1, 0, 7}));
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(minSwapsCouples(new int[]{3, 2, 0, 1}));
    }

    public static int minSwapsCouples(int[] row) {
        int result = 0;
        int n = row.length / 2;
        /**
         * 假设索引为0和1的座位为第0对情侣座，索引为2和3的座位为第1对情侣座，……，索引为2n-2和2n-1的座位为第n-1对情侣座。isVisited[i]表示
         * 第i对情侣座上是否已安排一对情侣入座
         */
        boolean[] isVisited = new boolean[n];
        /**
         * positions[i]表示id为i的人一开始所在座位的索引值
         */
        int[] positions = new int[row.length];
        /**
         * 记录每个人一开始所在座位的索引值
         */
        for (int i = 0; i < row.length; i++) {
            positions[row[i]] = i;
        }
        /**
         * 为n对情侣座安排情侣入座
         */
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            /**
             * 第i对情侣座，即索引为i*2和i*2+1的两个座位已经坐着一对情侣，则不需要交换
             */
            if (row[i * 2] / 2 == row[i * 2 + 1] / 2) {
                isVisited[i] = true;
                continue;
            }
            /**
             * 记录需要进行相互交换的情侣座的索引
             */
            Queue<Integer> queue = new LinkedList<>();
            /**
             * 需要进行相互交换的情侣座的对数
             */
            int groupCount = 1;
            queue.offer(i);
            isVisited[i] = true;

            while (!queue.isEmpty()) {
                int groupIndex = queue.poll();
                /**
                 * 第groupIndex对情侣座中索引为groupIndex*2的座位上的人的id
                 */
                int x = row[groupIndex * 2];
                /**
                 * id为x的人的情侣的id
                 */
                int xx = x % 2 == 0 ? x + 1 : x - 1;
                /**
                 * id为xx的人目前在第xxGroupIndex对情侣座上
                 */
                int xxGroupIndex = positions[xx] / 2;
                /**
                 * 如果第xxGroupIndex对情侣座还没有安排情侣入座，则会和第groupIndex对情侣座在同一个交换的小组中
                 */
                if (!isVisited[xxGroupIndex]) {
                    queue.offer(xxGroupIndex);
                    isVisited[xxGroupIndex] = true;
                    groupCount++;
                }
                /**
                 * 第groupIndex对情侣座中索引为groupIndex*2+1的座位上的人的id
                 */
                int y = row[groupIndex * 2 + 1];
                /**
                 * id为y的人的情侣的id
                 */
                int yy = y % 2 == 0 ? y + 1 : y - 1;
                /**
                 * id为yy的人目前在第yyGroupIndex对情侣座上
                 */
                int yyGroupIndex = positions[yy] / 2;
                /**
                 * 如果第yyGroupIndex对情侣座还没有安排一对情侣入座，则会和第groupIndex对情侣座在同一个交换的小组中
                 */
                if (!isVisited[yyGroupIndex]) {
                    queue.offer(yyGroupIndex);
                    isVisited[yyGroupIndex] = true;
                    groupCount++;
                }
            }
            /**
             * 如果共有 groupCount对需要进行相互交换的情侣座，每一次交换可以令一对情侣入座，最后一次交换使得最后两对情侣都入座
             */
            result += groupCount - 1;
        }
        return result;
    }
}
