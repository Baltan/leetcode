package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 863. All Nodes Distance K in Binary Tree
 *
 * @author Baltan
 * @date 2019-07-17 11:15
 */
public class DistanceK {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(distanceK(node1, node2, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();

        if (K == 0) {
            result.add(target.val);
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 将和target距离为1的节点都加入队列，可能为其左子节点、右子节点、父节点
         */
        if (target.left != null) {
            queue.offer(target.left);
        }

        if (target.right != null) {
            queue.offer(target.right);
        }

        TreeNode parent = parent(root, target);
        if (parent != null) {
            queue.offer(parent);
        }

        K--;
        /**
         * 因为每个节点的值在[0,500]之间，将其值改为-1，标记该节点已经到达过
         */
        target.val = -1;

        while (!queue.isEmpty() && K > 0) {
            int size = queue.size();
            /**
             * 初始时，队列中的节点和target的距离都为1，再寻找和这些节点的距离为1，
             * 且没有到达过的节点（否则可能会把target错误计算在内）加入队列，这些节点和target的距离即为2，以此类推
             */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /**
                 * 因为每个节点的值在[0,500]之间，将其值改为-1，标记该节点已经到达过
                 */
                node.val = -1;

                if (node.left != null && node.left.val != -1) {
                    queue.offer(node.left);
                }

                if (node.right != null && node.right.val != -1) {
                    queue.offer(node.right);
                }

                TreeNode p = parent(root, node);
                if (p != null && p.val != -1) {
                    queue.offer(p);
                }
            }
            K--;
        }
        /**
         * 最终队列中保存的节点都是和target的距离为K的节点
         */
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    /**
     * 在二叉树root中查找给定节点child的父节点
     */
    public static TreeNode parent(TreeNode root, TreeNode child) {
        if (root == null || child == root) {
            return null;
        }

        if (root.left == child || root.right == child) {
            return root;
        }
        /**
         * 在左子树中查找是否有目标节点的父节点，找到则直接返回
         */
        TreeNode node1 = parent(root.left, child);

        if (node1 != null) {
            return node1;
        } else {
            /**
             * 若左子树中没有找到目标节点的父节点，则在右子树中查找是否有目标节点的父节点，找到则直接返回
             */
            TreeNode node2 = parent(root.right, child);

            if (node2 != null) {
                return node2;
            }
        }
        return null;
    }
}
