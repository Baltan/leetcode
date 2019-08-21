package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 998. Maximum Binary Tree II
 *
 * @author Baltan
 * @date 2019-08-21 09:24
 */
public class InsertIntoMaxTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 1, 3, null, null, 2}, 0);
        TreeNode node1 = insertIntoMaxTree(root1, 5);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(node1));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(node1));

        System.out.println("------------------------------------");

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 2, 4, null, 1}, 0);
        TreeNode node2 = insertIntoMaxTree(root2, 3);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(node2));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(node2));


        System.out.println("------------------------------------");

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 2, 3, null, 1}, 0);
        TreeNode node3 = insertIntoMaxTree(root3, 4);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(node3));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(node3));
    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        /**
         * 如果原来是一棵空树，附加val后，节点val单独构成一棵树
         */
        if (root == null) {
            return new TreeNode(val);
        }
        /**
         * 如果原来的树只有一个节点，比较根节点的值和val，
         * 如果根节点的值大于val，val节点成为根节点的右子树，例如：
         * root=[2]，val=1，则表A为[2]，[2,1]构成的树为
         * <pre>
         *     2
         *      \
         *       1
         * </pre>
         * 如果根节点的值小于val，val节点成为新的根节点，原根节点成为val节点的左子树，例如：
         * root=[2]，val=3，则表A为[2]，则[2,3]构成的树为
         * <pre>
         *       3
         *      /
         *     2
         * </pre>
         */
        if (root.left == null && root.right == null) {
            if (root.val > val) {
                root.right = new TreeNode(val);
                return root;
            } else {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            }
        }
        /**
         * 如果根节点的值小于val，val节点成为新的根节点，原根节点成为val节点的左子树，例如：
         * root=[4,1,3,null,null,2]，val=5，则表A为[1,4,2,3]，则[1,4,2,3,5]构成的树为
         * <pre>
         *           5
         *          /
         *        4
         *       / \
         *     1    3
         *         /
         *        2
         * </pre>
         */
        if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        /**
         * 如果根节点没有右子树，且根节点的值大于val，val节点成为根节点的右子树，例如：
         * root=[3,2]，val=1，则表A为[2,3]，则[2,3,1]构成的树为
         * <pre>
         *       3
         *      / \
         *    2    1
         * </pre>
         */
        if (root.right == null) {
            root.right = new TreeNode(val);
            return root;
        }
        /**
         * 其他情况，对根节点的右子树进行递归操作，获得的新树作为根节点新的右子树
         */
        TreeNode right = root.right;
        root.right = insertIntoMaxTree(right, val);
        return root;
    }
}
