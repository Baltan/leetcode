package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 199. Binary Tree Right Side View
 *
 * @author Baltan
 * @date 2019-09-25 10:53
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4}, 0);
        System.out.println(rightSideView(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4, null,
                null, 6}, 0);
        System.out.println(rightSideView(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(rightSideView(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(rightSideView(root4));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        /**
         * 依次加入根节点的值和除去根节点以外部分的右视图结果
         */
        result.add(root.val);
        result.addAll(rightSideView(root.left, root.right));
        return result;
    }

    public static List<Integer> rightSideView(TreeNode left, TreeNode right) {
        /**
         * 两棵根节点在相同深度的子树的右视图结果
         */
        if (left == null && right == null) {
            return new ArrayList<>();
        } else if (left == null) {
            return rightSideView(right);
        } else if (right == null) {
            return rightSideView(left);
        } else {
            List<Integer> leftResult = rightSideView(left);
            List<Integer> rightResult = rightSideView(right);
            /**
             * 如果左子树的高度大于右子树，要在右子树的右视图后面追加左子树超出的那部分右视图内容，例如：
             * 下方左子树右视图为[1,3,5]，右子树右视图为[6,8]，两棵树并列的右视图为[6,8,5]
             * <pre>
             *          1                 6
             *        /   \             /   \
             *      2      3          7      8
             *    /      /
             *  4       5
             * </pre>
             */
            if (leftResult.size() > rightResult.size()) {
                for (int i = rightResult.size(); i < leftResult.size(); i++) {
                    rightResult.add(leftResult.get(i));
                }
            }
            return rightResult;
        }
    }
}
