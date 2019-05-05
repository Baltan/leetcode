package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: Smallest String Starting From Leaf
 *
 * @author Baltan
 * @date 2019-05-05 09:35
 */
public class SmallestFromLeaf {
    private TreeSet<String> set;

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, 1, 2, 3, 4, 3, 4}, 0);
        System.out.println(smallestFromLeaf(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{25, 1, 3, 1, 3, 0, 2}, 0);
        System.out.println(smallestFromLeaf(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 2, 1, null, 1, 0, null, null,
                null, 0}, 0);
        System.out.println(smallestFromLeaf(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, null, 1}, 0);
        System.out.println(smallestFromLeaf(root4));

        TreeNode root5 = BinaryTreeUtils
                .arrayToBinaryTree(
                        new Integer[]{25, 1, null, 0, 0, null, null, 1, null, null, null, null, null, null,
                                null, 0}, 0);
        System.out.println(smallestFromLeaf(root5));
    }

    public static String smallestFromLeaf(TreeNode root) {
        List<String> list = getStrings(root);
        Collections.sort(list);
        return list.get(0);
    }

    public static List<String> getStrings(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(String.valueOf((char) (root.val + 'a')));
        } else if (root.left == null && root.right != null) {
            List<String> rightStrings = getStrings(root.right);

            for (String s : rightStrings) {
                list.add(s + (char) (root.val + 'a'));
            }
        } else if (root.left != null && root.right == null) {
            List<String> leftStrings = getStrings(root.left);

            for (String s : leftStrings) {
                list.add(s + (char) (root.val + 'a'));
            }
        } else {
            List<String> leftStrings = getStrings(root.left);
            List<String> rightStrings = getStrings(root.right);

            for (String s : leftStrings) {
                list.add(s + (char) (root.val + 'a'));
            }

            for (String s : rightStrings) {
                list.add(s + (char) (root.val + 'a'));
            }
        }
        return list;
    }
}
