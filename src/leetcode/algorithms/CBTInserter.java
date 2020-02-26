package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 919. Complete Binary Tree Inserter
 *
 * @author Baltan
 * @date 2020-02-26 11:12
 */
public class CBTInserter {
    private Queue<TreeNode> queue;
    /**
     * 逐层从左至右添加二叉树中的节点
     */
    private List<TreeNode> nodeList;

    public CBTInserter(TreeNode root) {
        this.queue = new LinkedList<>();
        this.nodeList = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodeList.add(node);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        nodeList.add(node);
        /**
         * 当前nodeList的长度为length，则刚插入的节点的索引为length-1，其父节点的索引为
         * (length-1-1)/2=length/2-1
         */
        int length = nodeList.size();
        TreeNode parent = nodeList.get(length / 2 - 1);
        /**
         * 如果插入节点的索引为偶数，就是父节点的右节点，否则就是父节点的左节点
         */
        if ((length & 1) == 1) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        CBTInserter inserter1 = new CBTInserter(root1);
        System.out.println(inserter1.insert(2));
        System.out.println(inserter1.get_root());

        System.out.println("------------------------------------");

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6}, 0);
        CBTInserter inserter2 = new CBTInserter(root2);
        System.out.println(inserter2.insert(7));
        System.out.println(inserter2.insert(8));
        System.out.println(inserter2.get_root());
    }
}
