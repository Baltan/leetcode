package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2440. Create Components With Same Value
 *
 * @author Baltan
 * @date 2024/10/7 14:11
 */
public class ComponentValue {
    public static void main(String[] args) {
        System.out.println(componentValue(new int[]{2, 2, 1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2}, new int[][]{{0, 10}, {0, 5}, {1, 11}, {1, 12}, {1, 5}, {1, 18}, {2, 17}, {3, 6}, {3, 12}, {4, 8}, {5, 15}, {7, 13}, {7, 18}, {7, 9}, {8, 12}, {9, 19}, {10, 14}, {16, 17}, {17, 18}}));
        System.out.println(componentValue(new int[]{1, 2, 1, 1, 1}, new int[][]{{0, 1}, {1, 3}, {3, 4}, {4, 2}}));
        System.out.println(componentValue(new int[]{6, 2, 2, 2, 6}, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}}));
        System.out.println(componentValue(new int[]{2}, new int[][]{}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/create-components-with-same-value/solutions/1895302/by-endlesscheng-u03q/"></a>
     *
     * @param nums
     * @param edges
     * @return
     */
    public static int componentValue(int[] nums, int[][] edges) {
        int length = nums.length;
        /**
         * 无向图中所有节点值的和
         */
        int sum = 0;
        /**
         * 无向图中所有节点的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[length];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        /**
         * 操作后各个连通块的价值不小于max，且不大于sum，并且应该可以整数sum，遍历所有可能的连通块的价值
         */
        for (int i = max; i <= sum; i++) {
            if (sum % i != 0) {
                continue;
            }

            if (dfs(graph, nums, i, -1, 0) == 0) {
                /**
                 * 最终剩余sum/i个连通块，所以需要删除初始时连接这部分连通块的sum/i-1条边
                 */
                return sum / i - 1;
            }
        }
        return 0;
    }

    /**
     * 递归计算多叉树中所有节点值的和。当所有节点值的和大于target时，返回-1，此时连接节点curr和其父节点的边必须删除
     *
     * @param graph
     * @param nums
     * @param target 操作后各个连通块的价值
     * @param prev   当前节点的父节点
     * @param curr   当前节点，也是当前子树的根节点
     * @return
     */
    public static int dfs(List<Integer>[] graph, int[] nums, int target, int prev, int curr) {
        int sum = nums[curr];

        for (int next : graph[curr]) {
            if (next != prev) {
                /**
                 * 以节点next作为根节点的子树中所有节点值的和
                 */
                int res = dfs(graph, nums, target, curr, next);

                if (res == -1) {
                    return -1;
                }
                sum += res;
            }
        }
        /**
         * 当前子树中所有节点值的和大于target，说明当前删除边的方案不成立
         */
        if (sum > target) {
            return -1;
        }
        /**
         * 如果当前子树中所有节点值的和为target，则说明当前子树可以成为一个独立的连通块，否则根节点curr需要和其他节点相连来得到更大的连通块
         * 价值
         */
        return sum < target ? sum : 0;
    }
}
