package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 587. Erect the Fence
 *
 * @author Baltan
 * @date 2024/11/23 18:17
 */
public class OuterTrees {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}}));
        System.out.println("---------------------------------------");
        OutputUtils.print2DIntegerArray(outerTrees(new int[][]{{1, 2}, {2, 2}, {4, 2}}));
        System.out.println("---------------------------------------");
        OutputUtils.print2DIntegerArray(outerTrees(new int[][]{{0, 2}, {1, 1}, {2, 2}, {2, 4}, {4, 2}, {3, 3}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/erect-the-fence/solutions/1440879/an-zhuang-zha-lan-by-leetcode-solution-75s3/"></a>
     *
     * @param trees
     * @return
     */
    public static int[][] outerTrees(int[][] trees) {
        /**
         * 如果坐标中的点不超过3个，则这3个点都在凸包上
         */
        if (trees.length <= 3) {
            return trees;
        }
        /**
         * 数组trees表示的所有点中，最左下角的点的坐标，这个点一定在凸包上
         */
        int startIndex = 0;

        for (int i = 1; i < trees.length; i++) {
            if (trees[i][0] < trees[startIndex][0] || (trees[i][0] == trees[startIndex][0] && trees[i][1] < trees[startIndex][1])) {
                startIndex = i;
            }
        }
        /**
         * 保存凸包上所有点的索引
         */
        List<Integer> indexes = new ArrayList<>();
        /**
         * 将点trees[x]作为查找凸包的起点（也是终点）
         */
        int x = startIndex;
        boolean[] isVisited = new boolean[trees.length];

        do {
            /**
             * 凸包上下一个点的索引
             */
            int y = (x + 1) % trees.length;
            /**
             * 以点trees[x]作为极坐标原点，计算顺时针旋转方向上，角度最大的向量xy
             */
            for (int z = 0; z < trees.length; z++) {
                /**
                 * 当向量xy和向量xz的叉积小于0时，向量xy到向量xz的旋转方向为顺时针，说明向量xz的角度比向量xy更大
                 */
                if (cross(trees[x], trees[y], trees[z]) < 0) {
                    y = z;
                }
            }
            /**
             * 查找和向量xy在同一直线上的其他点
             */
            for (int i = 0; i < trees.length; i++) {
                if (isVisited[i] || i == x || i == y) {
                    continue;
                }
                /**
                 * 当向量xy和向量xi的叉积等于0时，向量xy和向量xi在同一直线上，说明这些点i也在凸包上
                 */
                if (cross(trees[x], trees[y], trees[i]) == 0) {
                    indexes.add(i);
                    isVisited[i] = true;
                }
            }

            if (!isVisited[y]) {
                indexes.add(y);
                isVisited[y] = true;
            }
            /**
             * 以点trees[y]作为极坐标原点继续计算
             */
            x = y;
        } while (x != startIndex);
        return indexes.stream()
                .map(i -> trees[i])
                .toArray(int[][]::new);
    }

    /**
     * 计算向量xy和向量xz的叉积
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static int cross(int[] x, int[] y, int[] z) {
        int[] xy = {y[0] - x[0], y[1] - x[1]};
        int[] xz = {z[0] - x[0], z[1] - x[1]};
        /**
         * 向量xy为(y[0]-x[0],y[1]-x[1])，向量yz为(z[0]-y[0], z[1]-y[1])
         */
        return xy[0] * xz[1] - xy[1] * xz[0];
    }
}
