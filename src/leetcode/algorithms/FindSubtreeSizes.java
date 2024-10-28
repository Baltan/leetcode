package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3331. Find Subtree Sizes After Changes
 *
 * @author Baltan
 * @date 2024/10/27 15:37
 */
public class FindSubtreeSizes {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findSubtreeSizes(new int[]{-1, 19, 12, 1, 17, 3, 8, 1, 19, 1, 3, 0, 5, 5, 12, 5, 15, 7, 5, 11}, "acecbebeeeeccabddcad"));
        OutputUtils.print1DIntegerArray(findSubtreeSizes(new int[]{-1, 0, 0, 1, 1, 1}, "abaabc"));
        OutputUtils.print1DIntegerArray(findSubtreeSizes(new int[]{-1, 0, 4, 0, 1}, "abbba"));
    }

    public static int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] result = new int[n];
        /**
         * newParent[i]表示更新后的树中，节点i的父节点
         */
        int[] newParent = parent.clone();

        for (int i = 0; i < n; i++) {
            int child = i;
            char c = s.charAt(i);
            /**
             * 对于节点i，向上查找离它最近且s[i]==s[j]的节点j，如果存在则将节点i的父节点重置为节点j
             */
            while (parent[child] != -1) {
                if (s.charAt(parent[child]) == c) {
                    newParent[i] = parent[child];
                    break;
                }
                child = parent[child];
            }
        }
        /**
         * graph[i]表示更新后的树中，以节点i作为父节点的所有子节点集合
         */
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int i = 0; i < n; i++) {
            if (newParent[i] != -1) {
                graph[newParent[i]].add(i);
            }
        }
        dfs(result, graph, 0);
        return result;
    }

    /**
     * 递归计算以节点node作为根节点的子树中节点的总个数
     *
     * @param result
     * @param graph
     * @param node
     */
    public static void dfs(int[] result, List<Integer>[] graph, int node) {
        for (int child : graph[node]) {
            /**
             * 先计算节点node的所有子树的情况
             */
            if (result[child] == 0) {
                dfs(result, graph, child);
            }
            result[node] += result[child];
        }
        /**
         * 加上节点node自身
         */
        result[node]++;
    }
}
