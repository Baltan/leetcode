package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 面试题 17.12. BiNode
 *
 * @author Baltan
 * @date 2022/2/22 22:07
 */
public class ConvertBiNode {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, 5, 1, 3, null, 6, 0}, 0);
        System.out.println(convertBiNode(root1));
    }

    public static TreeNode convertBiNode(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode head;
        /**
         * 递归将左子树转化为BiNode
         */
        TreeNode leftBiNode = convertBiNode(root.left);
        /**
         * 递归将右子树转化为BiNode
         */
        TreeNode rightBiNode = convertBiNode(root.right);
        /**
         * 如果左子树不为空，则最终BiNode为"leftBiNode-rootNode-rightBiNode"，否则为"rootNode-rightBiNode"
         */
        if (leftBiNode != null) {
            head = leftBiNode;
            TreeNode currNode = leftBiNode;
            /**
             * 遍历到leftBiNode的最后一个节点，后面将要连接rootNode
             */
            while (currNode.right != null) {
                currNode = currNode.right;
            }
            /**
             * 拼接rootNode后，指针移到rootNode上，将该节点的左子节点设为null，后面再继续拼接rightBiNode
             */
            currNode.right = root;
            currNode = currNode.right;
            currNode.left = null;
            currNode.right = rightBiNode;
        } else {
            head = root;
            /**
             * 将rootNode的左子节点设为null，后面再继续拼接rightBiNode
             */
            head.left = null;
            root.right = rightBiNode;
        }
        return head;
    }
}
