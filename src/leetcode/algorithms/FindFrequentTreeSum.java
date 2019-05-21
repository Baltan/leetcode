package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 508. Most Frequent Subtree Sum
 *
 * @author Baltan
 * @date 2018/8/17 15:02
 */
public class FindFrequentTreeSum {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-3);
        root1.left = node1;
        root1.right = node2;
        OutputUtils.print1DIntegerArray(findFrequentTreeSum(root1));

        TreeNode root2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(-5);
        root2.left = node3;
        root2.right = node4;
        OutputUtils.print1DIntegerArray(findFrequentTreeSum(root2));
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new int[res.size()];
        }
        List<Integer> list = new ArrayList<>();
        collectSum(root, list);
        Map<Integer, Integer> map = new HashMap();
        int maxNum = 0;
        for (Integer num : list) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            maxNum = map.get(num) > maxNum ? map.get(num) : maxNum;
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) == maxNum) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static void collectSum(TreeNode root, List<Integer> list) {
        list.add(treeSum(root));
        if (root.left != null) {
            collectSum(root.left, list);
        }
        if (root.right != null) {
            collectSum(root.right, list);
        }
    }
}
