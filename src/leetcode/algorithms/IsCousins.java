package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 993. Cousins in Binary Tree
 *
 * @author Baltan
 * @date 2019-03-15 12:40
 */
public class IsCousins {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4}, 0);
        System.out.println(isCousins(root1, 4, 3));
        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 4, null, 5}, 0);
        System.out.println(isCousins(root2, 5, 4));
        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 4}, 0);
        System.out.println(isCousins(root3, 2, 3));
        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, null, 3, 4, null, null, 5}, 0);
        System.out.println(isCousins(root4, 2, 4));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        if (root.left != null && root.right == null) {
            return isCousins(root.left, x, y);
        }
        if (root.left == null && root.right != null) {
            return isCousins(root.right, x, y);
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        int size = list.size();

        while (size >= 2) {
            for (int i = 0; i < size; i++) {
                if ((list.get(i).left != null && list.get(i).left.val == x) ||
                        (list.get(i).right != null && list.get(i).right.val == x)) {
                    for (int j = i + 1; j < size; j++) {
                        if ((list.get(j).left != null && list.get(j).left.val == y) ||
                                (list.get(j).right != null && list.get(j).right.val == y)) {
                            return true;
                        }
                    }
                    return false;
                } else if ((list.get(i).left != null && list.get(i).left.val == y) ||
                        (list.get(i).right != null && list.get(i).right.val == y)) {
                    for (int j = i + 1; j < size; j++) {
                        if ((list.get(j).left != null && list.get(j).left.val == x) ||
                                (list.get(j).right != null && list.get(j).right.val == x)) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            ArrayList temp = new ArrayList();
            for (int i = 0; i < size; i++) {
                if (list.get(i).left != null) {
                    temp.add(list.get(i).left);
                }
                if (list.get(i).right != null) {
                    temp.add(list.get(i).right);
                }
            }
            list = temp;
            size = list.size();
        }
        return false;
    }
}
