package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 572. Subtree of Another Tree
 *
 * @author Baltan
 * @date 2018/8/8 16:53
 * @see IsSubtree1
 */
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode s1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 4, 5, 1, 2}, 0);
        TreeNode t1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 1, 2}, 0);
        System.out.println(isSubtree(s1, t1));

        TreeNode s2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0},
                        0);
        TreeNode t2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 1, 2}, 0);
        System.out.println(isSubtree(s2, t2));

        TreeNode s3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        TreeNode t3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        System.out.println(isSubtree(s3, t3));

        TreeNode s4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        TreeNode t4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isSubtree(s4, t4));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        List<Object> listS = tree2list(s);
        List<Object> listT = tree2list(t);
        return listS.toString().contains(listT.toString()) || listS.toString().equals(listT.toString());
    }

    public static List<Object> tree2list(TreeNode t) {
        List<Object> list = new ArrayList<>();

        if (t == null) {
            return list;
        }

        list.add(t.val);

        if (t.left != null) {
            list.add(tree2list(t.left));
        }
        if (t.right != null) {
            list.add(tree2list(t.right));
        }
        return list;
    }
}
