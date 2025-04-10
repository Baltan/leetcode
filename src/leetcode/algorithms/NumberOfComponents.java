package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3493. Properties Graph
 *
 * @author Baltan
 * @date 2025/4/9 23:02
 */
public class NumberOfComponents {
    public static void main(String[] args) {
        System.out.println(numberOfComponents(new int[][]{{1, 2}, {1, 1}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}, 1));
        System.out.println(numberOfComponents(new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 3, 5}}, 2));
        System.out.println(numberOfComponents(new int[][]{{1, 1}, {1, 1}}, 2));
    }

    public static int numberOfComponents(int[][] properties, int k) {
        int result = 0;
        int length = properties.length;
        /**
         * 二维数组properties中所有元素的最小值
         */
        int min = Integer.MAX_VALUE;
        /**
         * 二维数组properties中所有元素的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * isVisited[i]表示数组properties[i]代表的节点是否在广度优先搜索无向图graph的过程中被访问过
         */
        boolean[] isVisited = new boolean[length];
        /**
         * existence[i][j]表示数组properties[i]中是否存在元素j，根据题意，二维数组properties中的元素∈[1,100]
         */
        boolean[][] existence = new boolean[length][101];
        /**
         * counts[i][j]表示数组properties[i]和properties[j]中共有的不同整数的个数
         */
        int[][] counts = new int[length][length];
        /**
         * 如果数组properties[i]和properties[j]中共有的不同整数的个数不少于k个，则在这两个数组代表的节点之间连接一条无向边，最后二维数组
         * properties中的length个数组代表的length个节点构成无向图graph。其中graph[i]表示与节点i直接相连的所有其他节点的集合
         */
        List<Integer>[] graph = new List[length];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 计算数组properties[i]中存在的元素，并且更新二维数组properties中所有元素的最大值和最小值
         */
        for (int i = 0; i < length; i++) {
            for (int value : properties[i]) {
                existence[i][value] = true;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }
        /**
         * 依次判断数组properties[j]和properties[l]中是否同时存在元素i，计算这两个数组中共有的不同整数的个数
         */
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < length; j++) {
                if (existence[j][i]) {
                    for (int l = j + 1; l < length; l++) {
                        if (existence[l][i]) {
                            counts[j][l]++;
                        }
                    }
                }
            }
        }
        /**
         * 构建无向图，如果数组properties[i]和properties[j]中共有的不同整数的个数不少于k个，则在这两个数组代表的节点之间连接一条无向边
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (counts[i][j] >= k) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        /**
         * 广度优先搜索计算无向图graph中连通分量的数量
         */
        for (int i = 0; i < length; i++) {
            if (isVisited[i]) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            isVisited[i] = true;
            result++;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int next : graph[curr]) {
                    if (!isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
        }
        return result;
    }
}
