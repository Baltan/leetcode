package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 623. Add One Row to Tree
 *
 * @author Baltan
 * @date 2020-01-29 11:09
 */
public class AddOneRow {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, 6, 3, 1, 5}, 0);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(addOneRow(root1, 1, 2)));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, null, 3, 1}, 0);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(addOneRow(root2, 1, 3)));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(addOneRow(root3, 4, 3)));
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        /**
         * 如果d为1，则创建一个新的根节点v，原先的整棵树将作为v的左子树
         */
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /**
         * 找到原来第d-1层的所有节点。第i轮循环结束后队列中保存的就是原来二叉树第i层的所有节点，所以
         * 最后队列中保存的就是原来二叉树第d-1层的所有节点
         */
        for (int i = 2; i < d; i++) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        /**
         * 在原来二叉树第d-1层的所有节点下面插入一层值为v的节点
         */
        for (TreeNode node : queue) {
            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;
            TreeNode newLeftNode = new TreeNode(v);
            TreeNode newRightNode = new TreeNode(v);

            node.left = newLeftNode;
            newLeftNode.left = leftNode;
            node.right = newRightNode;
            newRightNode.right = rightNode;
        }
        return root;
    }
}
