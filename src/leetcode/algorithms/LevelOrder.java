package leetcode.algorithms;

import leetcode.entity.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 429. N-ary Tree Level Order Traversal
 *
 * @author Baltan
 * @date 2018/8/2 15:32
 */
public class LevelOrder {
    public static void main(String[] args) {
        Node node1 = new Node(5, new ArrayList<>());
        Node node2 = new Node(6, new ArrayList<>());
        List<Node> list1 = Arrays.asList(node1, node2);
        Node node3 = new Node(3, list1);
        Node node4 = new Node(2, new ArrayList<>());
        Node node5 = new Node(4, new ArrayList<>());
        List<Node> list2 = Arrays.asList(node3, node4, node5);
        Node root = new Node(1, list2);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        if (root.children == null || root.children.size() == 0) {
            return res;
        } else {
            res.addAll(childrenLevelOrder(root.children));
            return res;
        }
    }

    public static List<List<Integer>> childrenLevelOrder(List<Node> children) {

        List<List<Integer>> list1 = levelOrder(children.get(0));

        List<List<Integer>> list2;

        for (int i = 1; i < children.size(); i++) {
            list2 = levelOrder(children.get(i));

            if (list1.size() < list2.size()) {
                for (int j = 0; j < list1.size(); j++) {
                    list1.get(j).addAll(list2.get(j));
                }
                for (int j = list1.size(); j < list2.size(); j++) {
                    list1.add(list2.get(j));
                }
            } else {
                for (int j = 0; j < list2.size(); j++) {
                    list1.get(j).addAll(list2.get(j));
                }
            }
        }
        return list1;
    }
}
