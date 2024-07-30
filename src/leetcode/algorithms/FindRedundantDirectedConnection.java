package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 685. Redundant Connection II
 *
 * @author baltan
 * @date 2024/7/29 17:33
 * @see FindRedundantConnection
 * @see FindRedundantConnection1
 * @see leetcode.interview.FindRedundantConnection
 */
public class FindRedundantDirectedConnection {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}));
        OutputUtils.print1DIntegerArray(findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/redundant-connection-ii/solutions/416748/rong-yu-lian-jie-ii-by-leetcode-solution/"></a>
     *
     * @param edges
     * @return
     */
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        /**
         * parents[i]是节点i的父节点
         */
        int[] parents = new int[edges.length + 1];
        /**
         * edges[conflict]是造成某个节点有两个父节点的边
         */
        int conflict = 0;
        /**
         * edges[cycle]是造成图中出现环的边
         */
        int cycle = 0;
        /**
         * 初始化每个节点的父节点都是它自己
         */
        Arrays.setAll(parents, i -> i);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];

            if (parents[to] != to) {
                /**
                 * 此前已存在节点parents[to]指向节点to的边，所以当前节点from指向节点to的边edges[i]是造成节点to有两个父节点的边
                 */
                conflict = i;
            } else {
                /**
                 * 将节点from指向节点to的边edges[i]会造成图中出现环
                 */
                if (!union(parents, from, to)) {
                    cycle = i;
                }
            }
        }
        /**
         * 如果不存在造成某个节点有两个父节点的边，则冗余连接使得图中出现环，返回edges中最后出现的环中的边即可。
         *
         *
         *
         * 如果还存在造成图中出现环的边，这条边
         */
        if (conflict == 0) {
            return edges[cycle];
        } else {
            /**
             * 如果存在造成某个节点有两个父节点的边edges[conflict]=[from,to]，则它和边[parents[to],to]中有一条是冗余连接。如果还存在
             * 造成图中出现环的边，因为造成环的边不是[from,to]，所以冗余连接是[parents[to],to]，否则就是后出现的冲突边[from,to]
             */
            int[] conflictEdge = edges[conflict];

            if (cycle != 0) {
                int to = conflictEdge[1];
                return new int[]{parents[to], to};
            } else {
                return conflictEdge;
            }
        }
    }

    /**
     * 查找节点value的根节点
     *
     * @param parents
     * @param value
     * @return
     */
    private static int getRoot(int[] parents, int value) {
        while (parents[value] != value) {
            value = parents[value];
        }
        return value;
    }

    /**
     * 能否将节点from所在的集合和节点to所在的集合合并，如果不能合并，说明节点from和节点to本来就在就在同一个集合中，此时连接将节点from指向节
     * 点to就构成了一个环
     *
     * @param parents
     * @param from
     * @param to
     * @return
     */
    private static boolean union(int[] parents, int from, int to) {
        int fromRoot = getRoot(parents, from);
        int toRoot = getRoot(parents, to);

        if (fromRoot == toRoot) {
            return false;
        }
        parents[to] = from;
        return true;
    }
}
