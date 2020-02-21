package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 1123. Lowest Common Ancestor of Deepest Leaves
 *
 * @author Baltan
 * @date 2019-09-24 09:27
 * @see SubtreeWithAllDeepest
 */
public class LcaDeepestLeaves {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(lcaDeepestLeaves(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4}, 0);
        System.out.println(lcaDeepestLeaves(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5}, 0);
        System.out.println(lcaDeepestLeaves(root3));
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        getHeight(root, heightMap);
        /**
         * 从树的根节点开始依次向下遍历节点，如果当前节点的左子树和右子树一样高，当前节点即为所求，否则
         * 所求节点一定在高度较高的那棵子树中，继续向下判定
         */
        while (true) {
            int leftHeight = heightMap.getOrDefault(root.left, 0);
            int rightHeight = heightMap.getOrDefault(root.right, 0);

            if (leftHeight == rightHeight) {
                return root;
            }
            root = leftHeight > rightHeight ? root.left : root.right;
        }
    }

    public static int getHeight(TreeNode root, Map<TreeNode, Integer> heightMap) {
        /**
         * 计算每个节点作为根节点的树的高度，并保存在heightMap中
         */
        if (root == null) {
            return 0;
        } else {
            int height = 1 + Math.max(getHeight(root.left, heightMap), getHeight(root.right, heightMap));
            heightMap.put(root, height);
            return height;
        }
    }
}
