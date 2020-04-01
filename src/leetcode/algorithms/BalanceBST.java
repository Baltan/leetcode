package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 1382. Balance a Binary Search Tree
 *
 * @author Baltan
 * @date 2020-04-01 11:24
 */
public class BalanceBST {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, null, 3, null,
                        null, null, null, null, null, null, 4}, 0);
        System.out.println(balanceBST(root1));
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = inOrder(root);
        return createAVL(inOrder, 0, inOrder.size());
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }

    /**
     * 构造平衡的二叉搜索树
     *
     * @param inOrder
     * @param start
     * @param end
     * @return
     */
    public static TreeNode createAVL(List<Integer> inOrder, int start, int end) {
        if (start == end) {
            return null;
        }
        /**
         * 将inOrder.sublist(start,end)的中间位置的节点作为AVL的根节点，该节点左边的子列表递归构造
         * 根节点的左子树，右边的子列表递归构造根节点的右子树
         */
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = createAVL(inOrder, start, mid);
        root.right = createAVL(inOrder, mid + 1, end);
        return root;
    }
}
