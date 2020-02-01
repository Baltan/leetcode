package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Stack;

/**
 * Description: 173. Binary Search Tree Iterator
 *
 * @author Baltan
 * @date 2020-02-01 12:35
 * <p>
 * 参考：
 * <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/javashi-yong-zhan-yi-ci-die-dai-bu-xu-yao-ti-qian-/"></a>
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     * <p>
     * next()方法复杂度为O(1)的分析：
     * <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/nextshi-jian-fu-za-du-wei-o1-by-user5707f/"></a>
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode rightNode = node.right;

        while (rightNode != null) {
            stack.push(rightNode);
            rightNode = rightNode.left;
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{7, 3, 15, null, null, 9, 20}, 0);
        BSTIterator iterator1 = new BSTIterator(root1);
        System.out.println(iterator1.next());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        System.out.println(iterator1.hasNext());
    }
}
