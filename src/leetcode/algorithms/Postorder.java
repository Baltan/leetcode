package leetcode.algorithms;

import leetcode.entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 590. N-ary Tree Postorder Traversal
 *
 * @author Baltan
 * @date 2018/8/1 16:06
 */
public class Postorder {
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
        Node root1 = new Node(1, list2);
        System.out.println(postorder(root1));

        Node root2 = null;
        System.out.println(postorder(root2));
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList();

        if (root == null) {
            return list;
        }
        List<Node> children = root.children;
        if (children != null) {
            for (Node node : root.children) {
                if (node.children == null) {
                    list.add(node.val);
                } else {
                    list.addAll(postorder(node));
                }
            }
            list.add(root.val);
        }
        return list;
    }
}
