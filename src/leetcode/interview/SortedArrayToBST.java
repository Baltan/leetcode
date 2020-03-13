package leetcode.interview;

import leetcode.entity.TreeNode;

/**
 * Description: 面试题 04.02. 最小高度树
 *
 * @author Baltan
 * @date 2019-02-26 09:57
 * @see leetcode.algorithms.SortedArrayToBST
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums1 = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums1));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start > end || start < 0 || end >= nums.length) {
            return null;
        }
        /**
         * 取nums中间的数字作为根节点root的值
         */
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        /**
         * 将nums左半边的数字递归构造二叉搜索树作为root的左子树
         */
        root.left = sortedArrayToBST(nums, start, mid - 1);
        /**
         * 将nums右半边的数字递归构造二叉搜索树作为root的右子树
         */
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
