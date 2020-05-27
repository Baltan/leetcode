package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 1457. Pseudo-Palindromic Paths in a Binary Tree
 *
 * @author Baltan
 * @date 2020-05-26 14:11
 */
public class PseudoPalindromicPaths {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 3, 1, 3, 1, null, 1}, 0);
        System.out.println(pseudoPalindromicPaths(root1));

        TreeNode root2 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1}, 0);
        System.out.println(pseudoPalindromicPaths(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{9}, 0);
        System.out.println(pseudoPalindromicPaths(root3));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        int result = 0;
        List<String> paths = dfs(root);

        for (String str : paths) {
            if (isPseudoPalindrome(str)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取从root的根节点到所有叶节点的路径集合
     *
     * @param root
     * @return
     */
    public static List<String> dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }

        List<String> paths = new LinkedList<>();

        if (root.left != null) {
            /**
             * root的左子节点到所有叶节点的路径集合
             */
            List<String> leftPaths = dfs(root.left);

            for (String leftPath : leftPaths) {
                paths.add(root.val + leftPath);
            }
        }

        if (root.right != null) {
            /**
             * root的右子节点到所有叶节点的路径集合
             */
            List<String> rightPaths = dfs(root.right);

            for (String rightPath : rightPaths) {
                paths.add(root.val + rightPath);
            }
        }
        return paths;
    }

    /**
     * 判断一个字符串是否是伪回文字符串
     *
     * @param str
     * @return
     */
    public static boolean isPseudoPalindrome(String str) {
        /**
         * count[i]计算字符'0'-'9'各自出现的次数
         */
        int[] count = new int[10];
        /**
         * 出现奇数次的字符的个数
         */
        int oddCount = 0;

        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }

        for (int value : count) {
            if ((value & 1) == 1) {
                oddCount++;
            }
        }
        /**
         * 如果字符串str是伪回文字符串，则str中出现奇数次的字母至多只有一个
         */
        return oddCount <= 1;
    }
}
