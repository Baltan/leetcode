package leetcode.algorithms;


import leetcode.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Maximum Depth of N-ary Tree
 *
 * @author Baltan
 * @date 2018/8/1 14:32
 */
public class MaxDepth1 {
    public static void main(String[] args) {
        Node node1 = new Node(5, null);
        Node node2 = new Node(6, null);
        List<Node> list1 = new ArrayList<>();
        list1.add(node1);
        list1.add(node2);
        Node node3 = new Node(3, list1);
        Node node4 = new Node(2, null);
        Node node5 = new Node(4, null);
        List<Node> list2 = new ArrayList<>();
        list2.add(node3);
        list2.add(node4);
        list2.add(node5);
        Node root = new Node(1, list2);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        List<Node> list = root.children;
        if (list != null) {
            for (Node node : list) {
                depth = Math.max(depth, 1 + maxDepth(node));
            }
        }
        return depth;
    }
}
