package leetcode.algorithms;


import leetcode.entity.TreeNode;

/**
 * Description: Same Tree
 *
 * @author Baltan
 * @date 2018/7/27 14:30
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        node1.left = node11;
        node1.right = node12;

        TreeNode node2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(3);
        node2.left = node21;
        node2.right = node22;

        System.out.println(isSameTree(node1, node2));

        TreeNode node3 = new TreeNode(1);
        TreeNode node31 = new TreeNode(2);
        node3.left = node31;

        TreeNode node4 = new TreeNode(1);
        TreeNode node41 = new TreeNode(2);
        node4.right = node41;

        System.out.println(isSameTree(node3, node4));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (q == null && p != null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}