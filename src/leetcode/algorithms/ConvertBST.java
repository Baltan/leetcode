package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 538. Convert BST to Greater Tree
 *
 * @author Baltan
 * @date 2019-02-25 10:02
 */
public class ConvertBST {
    private static int sum = 0;

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 2, 13}, 0);
        System.out.println(convertBST(root1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-sh-14/"></a>
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
