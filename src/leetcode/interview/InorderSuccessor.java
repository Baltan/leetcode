package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 面试题 04.06. 后继者
 *
 * @author Baltan
 * @date 2020-03-13 21:34
 */
public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3}, 0);
        TreeNode p1 = new TreeNode(1);
        System.out.println(inorderSuccessor(root1, p1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 0);
        TreeNode p2 = new TreeNode(6);
        System.out.println(inorderSuccessor(root2, p2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 0);
        TreeNode p3 = new TreeNode(2);
        System.out.println(inorderSuccessor(root3, p3));
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        /**
         * 如果p节点的值大于根节点，则p节点在root的右子树中，p的中序后继节点也在root的右子树中，从而在root
         * 的右子树中递归搜索p的中序后继节点
         */
        if (p.val > root.val) {
            return inorderSuccessor(root.right, p);
        } else if (p.val == root.val) {
            /**
             * 如果p节点就是root节点，则p的中序后继节点就是root的右子树中序遍历得到的第一个节点，如果root
             * 的右子树存在，则从右子树的根节点开始迭代搜索左节点即可
             */
            TreeNode node = root.right;

            while (node != null && node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            /**
             * 如果p节点的值小于根节点，则p节点在root的左子树中，在root的左子树中递归搜索p的中序后继节点，
             * 如果没有找到，说明p节点是root的左子树中序遍历得到的最后一个节点，p的中序后继节点就是root
             */
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }
}
