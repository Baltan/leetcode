package leetcode.util;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树操作
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
     * 把链表转化成二叉树（只有左子树上有节点）
     *
     * @param linkedList
     * @return
     */
    public static TreeNode linkedListToBinaryTree(int[] linkedList) {
        if (linkedList.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(linkedList[0]);
        TreeNode curr = root;

        for (int i = 1; i < linkedList.length; i++) {
            TreeNode node = new TreeNode(linkedList[i]);
            curr.left = node;
            curr = curr.left;
        }
        return root;
    }

    /**
     * 中序遍历二叉树（递归）
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> recursivelyInOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode == null) {
            return list;
        } else {
            list.addAll(recursivelyInOrder(treeNode.left));
            list.add(treeNode.val);
            list.addAll(recursivelyInOrder(treeNode.right));
            return list;
        }
    }

    /**
     * 中序遍历二叉树（迭代）
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> iterativelyInOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                list.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return list;
    }

    /**
     * 前序遍历二叉树（递归）
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> recursivelyPreOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode == null) {
            return list;
        } else {
            list.add(treeNode.val);
            list.addAll(recursivelyPreOrder(treeNode.left));
            list.addAll(recursivelyPreOrder(treeNode.right));
            return list;
        }
    }

    /**
     * 前序遍历二叉树（迭代）
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> iterativelyPreOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (treeNode == null) {
            return list;
        }

        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 后序遍历二叉树（递归）
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> recursivelyPostOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();

        if (treeNode == null) {
            return list;
        } else {
            list.addAll(recursivelyPostOrder(treeNode.left));
            list.addAll(recursivelyPostOrder(treeNode.right));
            list.add(treeNode.val);
            return list;
        }
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

    /**
     * 删除指定数值的节点
     *
     * @param treeNode
     * @param value
     * @return
     */
    public static TreeNode deleteNode(TreeNode treeNode, int value) {
        if (treeNode != null) {
            if (treeNode.val == value) {
                treeNode = null;
            } else {
                treeNode.left = deleteNode(treeNode.left, value);
                treeNode.right = deleteNode(treeNode.right, value);
            }
        }
        return treeNode;
    }
}
