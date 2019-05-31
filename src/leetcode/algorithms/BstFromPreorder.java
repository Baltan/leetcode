package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Arrays;

/**
 * Description: 1008. Construct Binary Search Tree from Preorder Traversal
 *
 * @author Baltan
 * @date 2019-03-18 14:31
 */
public class BstFromPreorder {
    public static void main(String[] args) {
        TreeNode root1 = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root1));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        int length = preorder.length;

        if (length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        if (length == 1) {
            return root;
        } else if (preorder[1] > preorder[0]) {
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, 1, length));
            return root;
        } else if (preorder[length - 1] < preorder[0]) {
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, length));
            return root;
        } else {
            int boundIndex = 0;
            for (int i = 1; i < length; i++) {
                if (preorder[i] > preorder[0]) {
                    boundIndex = i;
                    break;
                }
            }
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, boundIndex));
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, boundIndex, length));
            return root;
        }
    }
}
