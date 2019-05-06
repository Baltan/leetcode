package leetcode.util;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
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

    /**
     * 前序遍历二叉树
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> preOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode == null) {
            return list;
        } else if (treeNode.left == null && treeNode.right == null) {
            list.add(treeNode.val);
            return list;
        } else {
            list.addAll(preOrder(treeNode.left));
            list.add(treeNode.val);
            list.addAll(preOrder(treeNode.right));
            return list;
        }
    }

    /**
     * 后序遍历二叉树
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> postOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode != null && treeNode.left != null) {
            list.addAll(postOrder(treeNode.left));
        }
        if (treeNode != null && treeNode.right != null) {
            list.addAll(postOrder(treeNode.right));
        }
        if (treeNode != null) {
            list.add(treeNode.val);
        }
        return list;
    }

    /**
     * 逐行遍历二叉树
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> lineByLine(TreeNode treeNode) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.poll();
            if (currentTreeNode != null) {
                list.add(currentTreeNode.val);
                queue.offer(currentTreeNode.left);
                queue.offer(currentTreeNode.right);
            }
        }
        return list;
    }

    /**
     * 前序遍历顺序存储的<em>完全二叉树</em>
     *
     * @param arr
     * @param startIndex
     * @return
     */
    public static List<Integer> preOrderArray(int[] arr, int startIndex) {
        List<Integer> list = new ArrayList<>();

        if (arr == null || arr.length == 0 || startIndex >= arr.length) {
            return list;
        }
        list.add(arr[startIndex]);
        if (startIndex * 2 + 1 < arr.length) {
            list.addAll(preOrderArray(arr, startIndex * 2 + 1));
        }
        if (startIndex * 2 + 2 < arr.length) {
            list.addAll(preOrderArray(arr, startIndex * 2 + 2));
        }
        return list;
    }
}
