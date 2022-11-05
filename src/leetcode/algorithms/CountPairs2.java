package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1530. Number of Good Leaf Nodes Pairs
 *
 * @author Baltan
 * @date 2022/10/30 12:34
 */
public class CountPairs2 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 4}, 0);
        System.out.println(countPairs(root1, 3));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        System.out.println(countPairs(root2, 3));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2}, 0);
        System.out.println(countPairs(root3, 3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{100}, 0);
        System.out.println(countPairs(root4, 1));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1, 1}, 0);
        System.out.println(countPairs(root5, 2));

        TreeNode root6 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{78, 15, 81, 73, 98, 36, null, 30, null, 63, 32}, 0);
        System.out.println(countPairs(root6, 6));

        TreeNode root7 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 84, null, 80, 61}, 0);
        System.out.println(countPairs(root7, 2));
    }

    private static int result = 0;

    public static int countPairs(TreeNode root, int distance) {
        result = 0;
        /**
         * 节点node -> {左子树的叶节点i -> 节点node和叶节点i之间的最短路径长度}
         */
        Map<TreeNode, Map<TreeNode, Integer>> root2LeafdistanceMap = new HashMap<>();
        getRoot2LeafDistance(root, root2LeafdistanceMap);
        getLeaf2LeafDistance(root, root2LeafdistanceMap, distance);
        return result;
    }

    /**
     * 计算两个叶节点之间的最短路径长度是否小于等于distance
     *
     * @param root
     * @param root2LeafDistanceMap
     * @param distance
     */
    public static void getLeaf2LeafDistance(TreeNode root, Map<TreeNode, Map<TreeNode, Integer>> root2LeafDistanceMap, int distance) {
        if (root.left != null && root.right != null) {
            Map<TreeNode, Integer> leftDistanceMap = root2LeafDistanceMap.get(root.left);
            Map<TreeNode, Integer> rightDistanceMap = root2LeafDistanceMap.get(root.right);
            /**
             * root节点左子树上的叶节点和右子树上的叶节点两两配对可以找到一条两个叶节点之间的最短路径长度
             */
            for (int leftDistance : leftDistanceMap.values()) {
                for (int rightDistance : rightDistanceMap.values()) {
                    if (leftDistance + rightDistance + 2 <= distance) {
                        result++;
                    }
                }
            }
            getLeaf2LeafDistance(root.left, root2LeafDistanceMap, distance);
            getLeaf2LeafDistance(root.right, root2LeafDistanceMap, distance);
        } else if (root.left != null) {
            getLeaf2LeafDistance(root.left, root2LeafDistanceMap, distance);
        } else if (root.right != null) {
            getLeaf2LeafDistance(root.right, root2LeafDistanceMap, distance);
        }
    }

    /**
     * 递归计算节点root到各个叶节点最短路径长度
     *
     * @param root
     * @param root2LeafDistanceMap
     */
    public static void getRoot2LeafDistance(TreeNode root, Map<TreeNode, Map<TreeNode, Integer>> root2LeafDistanceMap) {
        Map<TreeNode, Integer> rootDistanceMap = root2LeafDistanceMap.computeIfAbsent(root, x -> new HashMap<>());
        /**
         * root本身就是叶节点，不需要继续递归，直接返回
         */
        if (root.left == null && root.right == null) {
            rootDistanceMap.put(root, 0);
            return;
        }

        if (root.left != null) {
            if (!root2LeafDistanceMap.containsKey(root.left)) {
                getRoot2LeafDistance(root.left, root2LeafDistanceMap);
            }
            /**
             * root节点到左子树上叶节点的距离为root节点的左子节点到叶节点的距离加1
             */
            root2LeafDistanceMap.get(root.left).entrySet().forEach(x -> rootDistanceMap.put(x.getKey(), x.getValue() + 1));
        }

        if (root.right != null) {
            if (!root2LeafDistanceMap.containsKey(root.right)) {
                getRoot2LeafDistance(root.right, root2LeafDistanceMap);
            }
            /**
             * root节点到右子树上叶节点的距离为root节点的右子节点到叶节点的距离加1
             */
            root2LeafDistanceMap.get(root.right).entrySet().forEach(x -> rootDistanceMap.put(x.getKey(), x.getValue() + 1));
        }
    }
}
