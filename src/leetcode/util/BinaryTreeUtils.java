package leetcode.util;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-02-27 10:04
 */
public class BinaryTreeUtils {

    /**
     * 把数组转化成二叉树
     *
     * @param arr
     * @param index
     * @return
     */
    public static TreeNode arrayToBinaryTree(Integer[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = null;

        if (index < arr.length) {
            Integer value = arr[index];

            if (value == null) {
                return null;
            }

            root = new TreeNode(value);
            root.left = arrayToBinaryTree(arr, 2 * index + 1);
            root.right = arrayToBinaryTree(arr, 2 * index + 2);
            return root;
        }
        return root;
    }

    /**
     * 中序遍历二叉树
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> inOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode != null && treeNode.left != null) {
            list.addAll(inOrder(treeNode.left));
        }
        if (treeNode != null) {
            list.add(treeNode.val);
        }
        if (treeNode != null && treeNode.right != null) {
            list.addAll(inOrder(treeNode.right));
        }
        return list;
    }
}
