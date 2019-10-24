package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1145. Binary Tree Coloring Game
 *
 * @author Baltan
 * @date 2019-10-24 08:59
 */
public class BtreeGameWinningMove {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null,
                        null, null, null}, 0);
        System.out.println(btreeGameWinningMove(root1, 11, 3));
    }

    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        /**
         * 如果一号玩家选择了根节点，二号玩家应该从根节点的左节点和右节点中选择一个，并且以选中的节点作为根节点的二叉树
         * 的节点数量就是二号玩家可以获得的最多节点数量；如果一号玩家没有选择根节点，二号玩家应该从该节点的左节点、右节
         * 点和父节点中选择一个，并且被选中的节点隔开的那部分节点数量就是二号玩家可以获得的最多节点数量。最后比较二号玩
         * 家可以获得的最多节点数量是否多余剩余节点数量即可。
         */
        if (root.val == x) {
            int leftCount = getNodeCount(root.left);
            int rightCount = n - 1 - leftCount;
            return Math.abs(leftCount - rightCount) >= 2;
        } else {
            TreeNode node = findNode(root, x);
            int leftCount = getNodeCount(node.left);
            int rightCount = getNodeCount(node.right);
            int parentCount = n - 1 - leftCount - rightCount;
            int max = Math.max(Math.max(leftCount, rightCount), parentCount);
            return max > n - max;
        }
    }

    /**
     * 统计二叉树的节点数量
     *
     * @param root
     * @return
     */
    public static int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }

    /**
     * 在二叉树中查找节点值等于给定值的节点
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode node = findNode(root.left, val);
        /**
         * 如果在左子树中找到了目标节点，直接返回，否则再到右子树中查找目标节点
         */
        if (node != null) {
            return node;
        }
        return findNode(root.right, val);
    }
}
