package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2076. Process Restricted Friend Requests
 *
 * @author baltan
 * @date 2024/6/25 16:09
 */
public class FriendRequests {
    public static void main(String[] args) {
        int[][] restrictions1 = {{0, 1}};
        int[][] requests1 = {{0, 2}, {2, 1}};
        OutputUtils.print1DBooleanArray(friendRequests(3, restrictions1, requests1));

        int[][] restrictions2 = {{0, 1}};
        int[][] requests2 = {{1, 2}, {0, 2}};
        OutputUtils.print1DBooleanArray(friendRequests(3, restrictions2, requests2));

        int[][] restrictions3 = {{0, 1}, {1, 2}, {2, 3}};
        int[][] requests3 = {{0, 4}, {1, 2}, {3, 1}, {3, 4}};
        OutputUtils.print1DBooleanArray(friendRequests(5, restrictions3, requests3));
    }

    public static boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] result = new boolean[requests.length];
        /**
         * parents[i]表示节点i的父节点
         */
        int[] parents = new int[n];
        /**
         * heights[i]表示以节点i为根节点的多叉树的高度
         */
        int[] heights = new int[n];
        /**
         * 初始化每个节点的父节点就是自己，即parents[i]=i
         */
        Arrays.setAll(parents, i -> i);
        /**
         * 初始化每个节点单独作为一棵多叉树，所以高度都为1
         */
        Arrays.fill(heights, 1);
        outer:
        for (int i = 0; i < requests.length; i++) {
            int x = requests[i][0];
            int y = requests[i][1];
            int xRoot = getRoot(parents, x);
            int yRoot = getRoot(parents, y);
            int xHeight = heights[xRoot];
            int yHeight = heights[yRoot];
            /**
             * 留下较高的多叉树，将较低多叉树的根节点指向较高多叉树的根节点
             */
            if (xHeight <= yHeight) {
                parents[xRoot] = yRoot;
                /**
                 * 当xRoot为根节点的多叉树和yRoot为根节点的多叉树高度相等时，两棵树结合后，yRoot为根节点的多叉树高度变为xHeight+1，否则
                 * yRoot为根节点的多叉树高度不变
                 */
                heights[yRoot] = Math.max(heights[yRoot], xHeight + 1);
            } else {
                /**
                 * 因为yRoot为根节点的多叉树高度小于xRoot为根节点的多叉树，所以两棵树组合后，xRoot为根节点的多叉树高度仍为xHeight
                 */
                parents[yRoot] = xRoot;
            }
            /**
             * 通过并查集判断如果x和y成为好友后，是否会使得禁止成为朋友的w和v也间接成为了朋友
             */
            for (int[] restriction : restrictions) {
                int w = restriction[0];
                int v = restriction[1];
                int wRoot = getRoot(parents, w);
                int vRoot = getRoot(parents, v);

                if (wRoot == vRoot) {
                    result[i] = false;
                    /**
                     * x和y不能成为好友，还原两人成为好友前的情况
                     */
                    if (xHeight <= yHeight) {
                        parents[xRoot] = xRoot;
                        heights[yRoot] = yHeight;
                    } else {
                        parents[yRoot] = yRoot;
                        heights[xRoot] = xHeight;
                    }
                    continue outer;
                }
            }
            result[i] = true;
        }
        return result;
    }

    /**
     * 查找节点x的根节点
     *
     * @param parents
     * @param x
     * @return
     */
    public static int getRoot(int[] parents, int x) {
        while (parents[x] != x) {
            x = parents[x];
        }
        return x;
    }
}
