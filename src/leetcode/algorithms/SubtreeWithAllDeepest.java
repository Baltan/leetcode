package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 865. Smallest Subtree with all the Deepest Nodes
 *
 * @author Baltan
 * @date 2020-02-21 12:15
 * @see LcaDeepestLeaves
 */
public class SubtreeWithAllDeepest {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 0);
        System.out.println(subtreeWithAllDeepest(root1));
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
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
