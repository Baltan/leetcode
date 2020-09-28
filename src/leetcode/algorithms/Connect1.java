package leetcode.algorithms;

import leetcode.entity.LinkedNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 117. Populating Next Right Pointers in Each Node II
 *
 * @author Baltan
 * @date 2019-05-25 18:21
 */
public class Connect1 {
    public static void main(String[] args) {
        LinkedNode node17 = new LinkedNode(7, null, null, null);
        LinkedNode node15 = new LinkedNode(5, null, null, null);
        LinkedNode node14 = new LinkedNode(4, null, null, null);
        LinkedNode node13 = new LinkedNode(3, null, node17, null);
        LinkedNode node12 = new LinkedNode(2, node14, node15, null);
        LinkedNode node11 = new LinkedNode(1, node12, node13, null);
        LinkedNode root1 = connect(node11);
        System.out.println(root1.next);
        System.out.println(root1.left.next);
        System.out.println(root1.right.next);
        System.out.println(root1.left.left.next);
        System.out.println(root1.left.right.next);
        System.out.println(root1.right.right.next);

        System.out.println("---------------------------------------------");

        LinkedNode node215 = new LinkedNode(15, null, null, null);
        LinkedNode node214 = new LinkedNode(14, null, null, null);
        LinkedNode node212 = new LinkedNode(12, null, null, null);
        LinkedNode node29 = new LinkedNode(9, null, null, null);
        LinkedNode node28 = new LinkedNode(8, null, null, null);
        LinkedNode node27 = new LinkedNode(7, node214, node215, null);
        LinkedNode node26 = new LinkedNode(6, node212, null, null);
        LinkedNode node25 = new LinkedNode(5, null, null, null);
        LinkedNode node24 = new LinkedNode(4, node28, node29, null);
        LinkedNode node23 = new LinkedNode(3, node26, node27, null);
        LinkedNode node22 = new LinkedNode(2, node24, node25, null);
        LinkedNode node21 = new LinkedNode(1, node22, node23, null);
        LinkedNode root2 = connect(node21);
        System.out.println(root2.next);
        System.out.println(root2.left.next);
        System.out.println(root2.right.next);
        System.out.println(root2.left.left.next);
        System.out.println(root2.left.right.next);
        System.out.println(root2.right.left.next);
        System.out.println(root2.right.right.next);
        System.out.println(root2.left.left.left.next);
        System.out.println(root2.left.left.right.next);
        System.out.println(root2.right.left.left.next);
        System.out.println(root2.right.right.left.next);
        System.out.println(root2.right.right.right.next);
    }

    public static LinkedNode connect(LinkedNode root) {
        if (root == null) {
            return null;
        }
        /**
         * 逐行将二叉树中的节点加入queue中
         */
        Queue<LinkedNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            /**
             * 该行节点的个数
             */
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                LinkedNode node = queue.poll();
                /**
                 * 如果是这行最后一个节点，next指针指向null，否则指向该行的下一个节点
                 */
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}