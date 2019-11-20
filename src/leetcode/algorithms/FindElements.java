package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1261. Find Elements in a Contaminated Binary Tree
 *
 * @author Baltan
 * @date 2019-11-20 09:23
 */
public class FindElements {
    /**
     * 保存二叉树中节点的值
     */
    private Set<Integer> nodeValues;

    public FindElements(TreeNode root) {
        this.nodeValues = new HashSet<>();
        recoverRootNode(root);
        System.out.println(root);
    }

    public void recoverRootNode(TreeNode root) {
        if (root == null) {
            return;
        }
        /**
         * 将二叉树的根节点的值修改为0
         */
        root.val = 0;
        nodeValues.add(root.val);
        /**
         * 递归处理二叉树除根节点以外的节点
         */
        recoverChildNodes(root);
    }

    public void recoverChildNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            /**
             * 将二叉树父节点的左节点的值修改为父节点的值×2+1
             */
            root.left.val = root.val * 2 + 1;
            nodeValues.add(root.left.val);
            /**
             * 递归处理父节点的左子树
             */
            recoverChildNodes(root.left);
        }

        if (root.right != null) {
            /**
             * 将二叉树父节点的右节点的值修改为父节点的值×2+2
             */
            root.right.val = root.val * 2 + 2;
            nodeValues.add(root.right.val);
            /**
             * 递归处理父节点的右子树
             */
            recoverChildNodes(root.right);
        }
    }

    public boolean find(int target) {
        return nodeValues.contains(target);
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{-1, null, -1}, 0);
        FindElements findElements1 = new FindElements(root1);
        System.out.println(findElements1.find(1));
        System.out.println(findElements1.find(2));

        System.out.println("---------------------------------");

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{-1, -1, -1, -1, -1}, 0);
        FindElements findElements2 = new FindElements(root2);
        System.out.println(findElements2.find(1));
        System.out.println(findElements2.find(3));
        System.out.println(findElements2.find(5));

        System.out.println("---------------------------------");

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{-1, null, -1, null, null, -1, null, null, null, null, null, -1}, 0);
        FindElements findElements3 = new FindElements(root3);
        System.out.println(findElements3.find(2));
        System.out.println(findElements3.find(3));
        System.out.println(findElements3.find(4));
        System.out.println(findElements3.find(5));
    }
}
