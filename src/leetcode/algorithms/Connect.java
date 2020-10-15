package leetcode.algorithms;

import leetcode.entity.LinkedNode;

/**
 * Description: 116. Populating Next Right Pointers in Each Node
 *
 * @author Baltan
 * @date 2019-05-24 21:57
 */
public class Connect {
    public static void main(String[] args) {
        LinkedNode node17 = new LinkedNode(7, null, null, null);
        LinkedNode node16 = new LinkedNode(6, null, null, null);
        LinkedNode node15 = new LinkedNode(5, null, null, null);
        LinkedNode node14 = new LinkedNode(4, null, null, null);
        LinkedNode node13 = new LinkedNode(3, node16, node17, null);
        LinkedNode node12 = new LinkedNode(2, node14, node15, null);
        LinkedNode node11 = new LinkedNode(1, node12, node13, null);
        LinkedNode root1 = connect(node11);
        System.out.println(root1.next);
        System.out.println(root1.left.next);
        System.out.println(root1.right.next);
        System.out.println(root1.left.left.next);
        System.out.println(root1.left.right.next);
        System.out.println(root1.right.left.next);
        System.out.println(root1.right.right.next);


        System.out.println("---------------------------------------------");

        LinkedNode node215 = new LinkedNode(15, null, null, null);
        LinkedNode node214 = new LinkedNode(14, null, null, null);
        LinkedNode node213 = new LinkedNode(13, null, null, null);
        LinkedNode node212 = new LinkedNode(12, null, null, null);
        LinkedNode node211 = new LinkedNode(11, null, null, null);
        LinkedNode node210 = new LinkedNode(10, null, null, null);
        LinkedNode node29 = new LinkedNode(9, null, null, null);
        LinkedNode node28 = new LinkedNode(8, null, null, null);
        LinkedNode node27 = new LinkedNode(7, node214, node215, null);
        LinkedNode node26 = new LinkedNode(6, node212, node213, null);
        LinkedNode node25 = new LinkedNode(5, node210, node211, null);
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
        System.out.println(root2.left.right.left.next);
        System.out.println(root2.left.right.right.next);
        System.out.println(root2.right.left.left.next);
        System.out.println(root2.right.left.right.next);
        System.out.println(root2.right.right.left.next);
        System.out.println(root2.right.right.right.next);
    }

    public static LinkedNode connect(LinkedNode root) {
        if (root != null) {
            /**
             * 递归为左子树中的所有节点填充右侧节点指针
             */
            root.left = connect(root.left);
            /**
             * 递归为右子树中的所有节点填充右侧节点指针
             */
            root.right = connect(root.right);
            /**
             * 为根节点的左子节点填充右侧节点指针
             */
            connect(root.left, root.right);
        }
        return root;
    }

    public static void connect(LinkedNode left, LinkedNode right) {
        if (left != null) {
            /**
             * 连接同一个父节点下的两个子节点，即为父节点的左子节点填充右侧节点指针
             */
            left.next = right;

            if (left.right != null) {
                /**
                 * 连接第一个父节点的右子节点和下一个父节点的左子节点，即为父节点的右子节点填充右侧节点指针
                 */
                connect(left.right, right.left);
            }
        }
    }
}
