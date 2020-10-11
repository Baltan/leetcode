//package leetcode.algorithms;
//
//import leetcode.util.OutputUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Description: 685. Redundant Connection II
// *
// * @author Baltan
// * @date 2020-09-17 07:56
// * @see FindRedundantConnection
// * @see FindRedundantConnection1
// */
//public class FindRedundantDirectedConnection {
//    public static void main(String[] args) {
//        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
//        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(edges1));
//
//        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
//        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(edges2));
//
//        int[][] edges3 = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
//        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(edges3));
//    }
//
//    public static int[] findRedundantDirectedConnection(int[][] edges) {
//        /**
//         * 无向图中节点的个数
//         */
//        int count = 0;
//
//        for (int[] edge : edges) {
//            count = Math.max(count, edge[0]);
//            count = Math.max(count, edge[1]);
//        }
//
//        List<Integer>[] entry = new List[count + 1];
//
//        for (int i = 1; i <= count; i++) {
//            entry[i] = new ArrayList<>();
//        }
//        /**
//         * parent[i]是节点i的父节点
//         */
//        int[] parent = new int[count + 1];
//        /**
//         * 依次判断edge这条边是否在环上
//         */
//        for (int[] edge : edges) {
//            int x = edge[0];
//            int y = edge[1];
//
//            if (entry[y].size() == 1) {
//                if (!isloop(parent, y)) {
//                    return new int[]{entry[y].get(0), y};
//                } else {
//                    return edge;
//                }
//            } else {
//                if (!union(parent, edge[0], edge[1])) {
//                    return edge;
//                } else {
//                    union(parent, x, y);
//                    entry[y].add(x);
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 查找节点value的根节点
//     *
//     * @param parent
//     * @param value
//     * @return
//     */
//    public static int getRoot(int[] parent, int value) {
//        int root = value;
//
//        while (parent[root] != 0) {
//            root = parent[root];
//        }
//        return root;
//    }
//
//    /**
//     * 能否将x所在的集合和y所在的集合合并，如果不能合并，说明x和y本来就在就在同一个集合中，此时连
//     * 接x和y就构成了一个环
//     *
//     * @param parent
//     * @param x
//     * @param y
//     * @return
//     */
//    public static boolean union(int[] parent, int x, int y) {
//        int xRoot = getRoot(parent, x);
//        int yRoot = getRoot(parent, y);
//
//        if (xRoot == yRoot) {
//            return false;
//        }
//        parent[y] = x;
//        return true;
//    }
//}
