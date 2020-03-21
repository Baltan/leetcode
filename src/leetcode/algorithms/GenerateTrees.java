package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 95. Unique Binary Search Trees II
 *
 * @author Baltan
 * @date 2020-03-21 12:49
 */
public class GenerateTrees {
    public static void main(String[] args) {
        System.out.println(generateTrees(0));
        System.out.println(generateTrees(1));
        System.out.println(generateTrees(2));
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Arrays.asList();
        }

        int[] arr = new int[n];
        /**
         * 构造数组[1,2,3,……,n]
         */
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return generateTrees(arr, 0, arr.length);
    }

    /**
     * 用arr.subarray(start,end)这部分数字可以构成的二叉搜索树的集合
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static List<TreeNode> generateTrees(int[] arr, int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        /**
         * 如果start==end，即没有数字可用，只能构成一棵空树
         */
        if (start == end) {
            result.add(null);
            return result;
        }
        /**
         * 分别将arr[i]作为二叉搜索树的根节点
         */
        for (int i = start; i < end; i++) {
            /**
             * arr.subarray(start,i)这部分数字都小于arr[i]，用于构成根节点的左子树
             */
            List<TreeNode> leftList = generateTrees(arr, start, i);
            /**
             * arr.subarray(i+1,end)这部分数字都大于arr[i]，用于构成根节点的右子树
             */
            List<TreeNode> rightList = generateTrees(arr, i + 1, end);
            /**
             * 将所有可能的左子树和右子树进行两两组合
             */
            for (TreeNode leftTree : leftList) {
                for (TreeNode rightTree : rightList) {
                    TreeNode root = new TreeNode(arr[i]);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
