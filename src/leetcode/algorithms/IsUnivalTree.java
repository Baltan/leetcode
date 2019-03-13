package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Univalued Binary Tree
 *
 * @author Baltan
 * @date 2019-03-13 13:56
 */
public class IsUnivalTree {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(1);
        TreeNode node14 = new TreeNode(1);
        TreeNode node15 = new TreeNode(1);
        TreeNode node16 = new TreeNode(1);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;
        node13.right = node16;
        System.out.println(isUnivalTree(node11));

        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(2);
        TreeNode node24 = new TreeNode(5);
        TreeNode node25 = new TreeNode(2);

        node21.left = node22;
        node21.right = node23;
        node22.left = node24;
        node22.right = node25;
        System.out.println(isUnivalTree(node21));
    }

    public static boolean isUnivalTree(TreeNode root) {
        return preOrder(root).size() == 1;
    }

    public static Set<Integer> preOrder(TreeNode root) {
        Set<Integer> set = new HashSet<>();

        if (root == null) {
            return set;
        }
        set.add(root.val);
        set.addAll(preOrder(root.left));
        set.addAll(preOrder(root.right));
        return set;
    }
}
