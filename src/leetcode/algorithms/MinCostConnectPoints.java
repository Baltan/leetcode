package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1584. Min Cost to Connect All Points
 *
 * @author Baltan
 * @date 2022/10/21 10:29
 */
public class MinCostConnectPoints {
    public static void main(String[] args) {
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points1));

        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println(minCostConnectPoints(points2));

        int[][] points3 = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        System.out.println(minCostConnectPoints(points3));

        int[][] points4 = {{-1000000, -1000000}, {1000000, 1000000}};
        System.out.println(minCostConnectPoints(points4));

        int[][] points5 = {{0, 0}};
        System.out.println(minCostConnectPoints(points5));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/min-cost-to-connect-all-points/solutions/565801/lian-jie-suo-you-dian-de-zui-xiao-fei-yo-kcx7/"></a>
     * 并查集&Kruskal算法
     *
     * @param points
     * @return
     */
    public static int minCostConnectPoints(int[][] points) {
        int result = 0;
        int length = points.length;
        /**
         * length个端点一个可以构成length*(length-1)/2条线段
         */
        Path[] paths = new Path[length * (length - 1) / 2];
        int index = 0;
        /**
         * points[parent[i]]是节点points[i]的父节点
         */
        int[] parent = new int[length + 1];
        /**
         * 计算所有可能的线段
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] startPoint = points[i];
                int[] endPoint = points[j];
                int distance = Math.abs(startPoint[0] - endPoint[0]) + Math.abs(startPoint[1] - endPoint[1]);
                paths[index++] = new Path(i + 1, j + 1, distance);
            }
        }
        /**
         * 按照曼哈顿距离将所有线段升序排列
         */
        Arrays.sort(paths, Comparator.comparingInt(Path::getDistance));
        /**
         * 从曼哈顿距离最短的线段开始遍历，如果选择当前线段后和之前已选择过的线段不会构成环，就连接当前线段的两个端点
         */
        for (Path path : paths) {
            if (union(parent, path.getStartIndex(), path.getEndIndex())) {
                result += path.getDistance();
            }
        }
        return result;
    }

    /**
     * 查找节点value的根节点
     *
     * @param parent
     * @param value
     * @return
     */
    public static int getRoot(int[] parent, int value) {
        int root = value;

        while (parent[root] != 0) {
            root = parent[root];
        }
        return root;
    }

    /**
     * 能否将x所在的集合和y所在的集合合并，如果不能合并，说明x和y本来就在就在同一个集合中，此时连
     * 接x和y就构成了一个环
     *
     * @param parent
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parent, int x, int y) {
        int xRoot = getRoot(parent, x);
        int yRoot = getRoot(parent, y);

        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
            return true;
        }
        return false;
    }

    /**
     * 线段对象
     */
    public static class Path {
        /**
         * 线段一个端点在数组points中的索引值+1
         */
        private int startIndex;
        /**
         * 线段另一个端点在数组points中的索引值+1
         */
        private int endIndex;
        /**
         * 线段两个端点的曼哈顿距离
         */
        private int distance;

        public Path(int startPoint, int endPoint, int distance) {
            this.startIndex = startPoint;
            this.endIndex = endPoint;
            this.distance = distance;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public int getDistance() {
            return distance;
        }
    }
}
