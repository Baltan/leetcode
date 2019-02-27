package leetcode.algorithms;

import leetcode.entity.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: N-ary Tree Preorder Traversal
 *
 * @author Baltan
 * @date 2018/8/5 10:41
 */
public class Preorder {
    public static void main(String[] args) {
        Node node1 = new Node(5, new ArrayList<>());
        Node node2 = new Node(6, new ArrayList<>());
        List<Node> list1 = Arrays.asList(node1, node2);
        Node node3 = new Node(3, list1);
        Node node4 = new Node(2, new ArrayList<>());
        Node node5 = new Node(4, new ArrayList<>());
        List<Node> list2 = Arrays.asList(node3, node4, node5);
        Node root = new Node(1, list2);

        System.out.println(preorder(root));
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.add(root.val);

        if (root.children.size() == 0 || root.children == null) {
            return res;
        } else {
            for (Node node : root.children) {
                List<Integer> list = preorder(node);
                res.addAll(list);
            }
        }
        return res;
    }
}
