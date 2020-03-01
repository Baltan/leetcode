package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 971. Flip Binary Tree To Match Preorder Traversal
 *
 * @author Baltan
 * @date 2020-03-01 12:09
 */
public class FlipMatchVoyage {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        int[] voyage1 = {2, 1};
        System.out.println(flipMatchVoyage(root1, voyage1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        int[] voyage2 = {1, 3, 2};
        System.out.println(flipMatchVoyage(root2, voyage2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        int[] voyage3 = {1, 2, 3};
        System.out.println(flipMatchVoyage(root3, voyage3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        int[] voyage4 = {1, 3, 6, 7, 2, 4, 5};
        System.out.println(flipMatchVoyage(root4, voyage4));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        int[] voyage5 = {1, 3, 6, 7, 2, 5, 4};
        System.out.println(flipMatchVoyage(root5, voyage5));

        TreeNode root6 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        int[] voyage6 = {1, 3, 6, 5, 2, 7, 4};
        System.out.println(flipMatchVoyage(root6, voyage6));

        TreeNode root7 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{30, 26, 11, 1, 13, null, 8, 20, 19, 27, 3, null, null, null, 7, null, null, 29,
                        25, null, 6, 28, null, null, null, null, null, null, null, 17, 18, null, null, null,
                        null, 4, null, 21, 23, null, null, null, null, 12, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, 10, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, null, 9, 5, 16, 2, null
                        , null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, 15, null, 22, null, null, null, 14, 24}, 0);
        int[] voyage7 =
                {30, 13, 8, 7, 17, 10, 18, 26, 11, 3, 28, 12, 27, 6, 1, 19, 29, 4, 25, 21, 5, 15, 14, 9, 23,
                        2, 16, 22, 24, 20};
        System.out.println(flipMatchVoyage(root7, voyage7));
    }

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new LinkedList<>();
        help(result, root, voyage, 0, voyage.length);
        /**
         * 如果result中有-1，说明有一部分行程是无法通过翻转左右节点得到的，则直接返回[-1]
         */
        for (int value : result) {
            if (value == -1) {
                result = Arrays.asList(-1);
                break;
            }
        }
        return result;
    }

    public static void help(List<Integer> result, TreeNode root, int[] voyage, int i, int j) {
        /**
         * 如果当前行程的起始值和root的值不一样，则肯定无法通过翻转左右节点匹配目标行程voyage
         */
        if (root.val != voyage[i]) {
            result.add(-1);
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        } else if (root.left == null) {
            /**
             * 如果根节点只有右子树，则对右子树递归
             */
            help(result, root.right, voyage, i + 1, voyage.length);
        } else if (root.right == null) {
            /**
             * 如果根节点只有左子树，则对左子树递归
             */
            help(result, root.left, voyage, i + 1, voyage.length);
        } else {
            /**
             * 如果目标行程voyage的第2个数字voyage[i+1]和左子树根节点的值相同，说明当前左右
             * 子树不用翻转
             */
            if (voyage[i + 1] == root.left.val) {
                int k = i + 1;
                /**
                 * 找到左子树行程终点的索引k，也就是右子树的根节点的值的索引位置
                 */
                while (k < voyage.length && voyage[k] != root.right.val) {
                    k++;
                }
                /**
                 * 如果在接下来的行程中没能找到k，说明右子树的行程不在目标行程voyage中，肯
                 * 定无法通过翻转左右节点匹配目标行程voyage
                 */
                if (k == voyage.length) {
                    result.add(-1);
                    return;
                }
                /**
                 * 对左子树递归
                 */
                help(result, root.left, voyage, i + 1, k);
                /**
                 * 对右子树递归
                 */
                help(result, root.right, voyage, k, j);
            } else {
                /**
                 * 如果目标行程voyage的第2个数字voyage[i+1]和左子树根节点的值不同，那么不
                 * 交换左右子树肯定无法得到目标行程voyage，即当前进入右子树的行程
                 */
                int k = i + 1;
                /**
                 * 找到右子树行程终点的索引k，也就是左子树的根节点的值的索引位置
                 */
                while (k < voyage.length && voyage[k] != root.left.val) {
                    k++;
                }
                /**
                 * 如果在接下来的行程中没能找到k，说明左子树的行程不在目标行程voyage中，肯
                 * 定无法通过翻转左右节点匹配目标行程voyage
                 */
                if (k == voyage.length) {
                    result.add(-1);
                    return;
                }
                /**
                 * 交换当期啊左右子树，将它们的父节点的值接入result
                 */
                result.add(root.val);
                /**
                 * 对右子树递归
                 */
                help(result, root.right, voyage, i + 1, k);
                /**
                 * 对左子树递归
                 */
                help(result, root.left, voyage, k, j);
            }
        }
    }
}
