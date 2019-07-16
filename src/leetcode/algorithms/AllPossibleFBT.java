package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 894. All Possible Full Binary Trees
 *
 * @author Baltan
 * @date 2019-07-16 09:31
 */
public class AllPossibleFBT {
    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7).size());
    }

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new LinkedList<>();
        /**
         * 如果节点总数为偶数，无法组成满二叉树，返回空集合
         */
        if ((N & 1) == 0) {
            return result;
            /**
             *如果节点总数为1，只有一种情况，即单独一个根节点
             */
        } else if (N == 1) {
            TreeNode root = new TreeNode(0);
            result.add(root);
            return result;
        } else {
            /**
             * 除去根节点后将剩余N-1个节点拆分成奇数对（1/N-2、3/N-4、5/N-6……）作为左子树和右子树的节点总数，
             * 递归计算左子树和右子树可能的满二叉树的可能，两两组合到根节点上即可
             */
            for (int leftNodeCount = 1; leftNodeCount < N - 1; leftNodeCount++) {
                int rightNodeCount = N - 1 - leftNodeCount;

                List<TreeNode> leftList = allPossibleFBT(leftNodeCount);
                List<TreeNode> rightList = allPossibleFBT(rightNodeCount);

                for (TreeNode leftTree : leftList) {
                    for (TreeNode rightTree : rightList) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }
}
