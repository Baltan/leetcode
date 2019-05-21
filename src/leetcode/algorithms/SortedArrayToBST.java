package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 108. Convert Sorted Array to Binary Search Tree
 *
 * @author Baltan
 * @date 2019-02-26 09:57
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr1 = {-10, -3, 0, 5, 9};
        TreeNode node1 = sortedArrayToBST(arr1);
        OutputUtils.printPreOrderBinaryTree(node1);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int length = nums.length;
        int midIndex = length / 2;

        TreeNode root = new TreeNode(nums[midIndex]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, length));

        return root;
    }
}
