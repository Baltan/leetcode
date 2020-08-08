package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 99. Recover Binary Search Tree
 *
 * @author Baltan
 * @date 2020-08-08 00:45
 */
public class RecoverTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, null, null, 2}, 0);
        recoverTree(root1);
        System.out.println(root1);

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 1, 4, null, null, 2}, 0);
        recoverTree(root2);
        System.out.println(root2);
    }

    public static void recoverTree(TreeNode root) {
        /**
         * 中序遍历二叉搜索树root
         */
        List<Integer> inorderList = inorder(root);
        /**
         * 二叉搜索树root中序遍历中的逆序对集合
         */
        List<int[]> reversePairList = findReversePair(inorderList);
        /**
         * 被交换的节点的值
         */
        int x;
        /**
         * 被交换的节点的值
         */
        int y;
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 已经还原节点值的次数
         */
        int modifyCount = 0;
        /**
         * 二叉搜索树的中序遍历应当是递增的，如果二叉树中交换了节点就可能在中序遍历中出现逆序对。如果中序遍历中只有
         * 一个逆序对，则就是交换了这个逆序对的两个节点的值，例如：[1,2,3,4,5,6]->[1,2,4,3,5,6]，交换了3和4。如
         * 果中序遍历中有两个逆序对，则就是交换了第一个逆序对第一个节点和第二个逆序对第二个节点的值，例如：[1,2,3,
         * 4,5,6]->[1,5,3,4,2,6]中有两个逆序对(5,3)和(4,2)，交换了5和2
         */
        if (reversePairList.size() == 1) {
            int[] pair = reversePairList.get(0);
            x = pair[0];
            y = pair[1];
        } else {
            int[] pair1 = reversePairList.get(0);
            int[] pair2 = reversePairList.get(1);
            x = pair1[0];
            y = pair2[1];
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            /**
             * 找到值为x的节点，还原为y，找到值为y的节点，还原为x
             */
            if (node.val == x) {
                node.val = y;
                modifyCount++;
            } else if (node.val == y) {
                node.val = x;
                modifyCount++;
            }
            /**
             * 如果已经将两个节点的值还原了，则已经复原了二叉搜索树，结束操作
             */
            if (modifyCount == 2) {
                break;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> inorderList = inorder(root.left);
        inorderList.add(root.val);
        inorderList.addAll(inorder(root.right));
        return inorderList;
    }

    /**
     * 查找二叉搜索树中序遍历中的逆序对（相邻两个元素顺序降序排列的）
     *
     * @param inorderList
     * @return
     */
    public static List<int[]> findReversePair(List<Integer> inorderList) {
        List<int[]> reversePairList = new ArrayList<>();
        int size = inorderList.size();

        for (int i = 1; i < size; i++) {
            if (inorderList.get(i) < inorderList.get(i - 1)) {
                reversePairList.add(new int[]{inorderList.get(i - 1), inorderList.get(i)});
            }
        }
        return reversePairList;
    }
}
