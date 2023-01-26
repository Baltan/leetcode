package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2049. Count Nodes With the Highest Score
 *
 * @author Baltan
 * @date 2023/1/25 20:11
 */
public class CountHighestScoreNodes {
    public static void main(String[] args) {
        System.out.println(countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        System.out.println(countHighestScoreNodes(new int[]{-1, 2, 0}));
    }

    public static int countHighestScoreNodes(int[] parents) {
        int result = 0;
        /**
         * 节点的最高得分
         */
        long maxProduct = 0L;
        int totalCount = parents.length;
        /**
         * leftCounts[i]表示节点i的左子树中节点的数量
         */
        int[] leftCounts = new int[totalCount];
        /**
         * leftCounts[i]表示节点i的右子树中节点的数量
         */
        int[] rightCounts = new int[totalCount];
        /**
         * childrenArray[i]表示节点i的所有子节点的列表
         */
        List<Integer>[] childrenArray = new List[totalCount];

        for (int i = 0; i < totalCount; i++) {
            /**
             * 将每个节点的左右子树中节点的数量都初始化为-1，用于递归计算每个节点的左右子树中节点的数量时判断节点是否已计算过
             */
            leftCounts[i] = -1;
            rightCounts[i] = -1;
            childrenArray[i] = new ArrayList<>();
        }
        /**
         * 获得每个节点的子节点的列表，因为节点0为二叉树根节点，其父节点表示为-1，所以跳过节点0开始遍历
         */
        for (int i = 1; i < totalCount; i++) {
            childrenArray[parents[i]].add(i);
        }
        dfs(childrenArray, leftCounts, rightCounts, 0);

        for (int i = 0; i < totalCount; i++) {
            /**
             * 节点i左子树中节点的数量
             */
            int leftCount = leftCounts[i];
            /**
             * 节点i右子树中节点的数量
             */
            int rightCount = rightCounts[i];
            /**
             * 节点i向上的节点的数量
             */
            int upCount = totalCount - leftCount - rightCount - 1;
            long product = 1L * (leftCount == 0 ? 1 : leftCount) * (rightCount == 0 ? 1 : rightCount) * (upCount == 0 ? 1 : upCount);

            if (product == maxProduct) {
                result++;
            } else if (product > maxProduct) {
                result = 1;
                maxProduct = product;
            }
        }
        return result;
    }

    /**
     * 递归计算节点root的左右子树中节点的数量
     *
     * @param childrenArray
     * @param leftCounts
     * @param rightCounts
     * @param root
     */
    public static void dfs(List<Integer>[] childrenArray, int[] leftCounts, int[] rightCounts, int root) {
        List<Integer> children = childrenArray[root];

        if (children.isEmpty()) {
            leftCounts[root] = 0;
            rightCounts[root] = 0;
        } else if (children.size() == 1) {
            /**
             * 假设节点left就是节点root的左子树的根节点（不论为左子树还是右子树不影响计算结果）
             */
            int left = children.get(0);
            /**
             * 还没计算过节点left的左右子树中节点的数量，先递归计算
             */
            if (leftCounts[left] == -1) {
                dfs(childrenArray, leftCounts, rightCounts, left);
            }
            /**
             * 节点left的左子树中节点的数量+节点left的右子树中节点的数量+节点left自身
             */
            leftCounts[root] = leftCounts[left] + rightCounts[left] + 1;
            rightCounts[root] = 0;
        } else {
            int left = children.get(0);
            int right = children.get(1);
            /**
             * 还没计算过节点left的左右子树中节点的数量，先递归计算
             */
            if (leftCounts[left] == -1) {
                dfs(childrenArray, leftCounts, rightCounts, left);
            }
            /**
             * 节点left的左子树中节点的数量+节点left的右子树中节点的数量+节点left自身
             */
            leftCounts[root] = leftCounts[left] + rightCounts[left] + 1;
            /**
             * 还没计算过节点right的左右子树中节点的数量，先递归计算
             */
            if (leftCounts[right] == -1) {
                dfs(childrenArray, leftCounts, rightCounts, right);
            }
            /**
             * 节点right的左子树中节点的数量+节点right的右子树中节点的数量+节点right自身
             */
            rightCounts[root] = leftCounts[right] + rightCounts[right] + 1;
        }
    }
}
