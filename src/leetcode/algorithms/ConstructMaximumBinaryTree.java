package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 654. Maximum Binary Tree
 *
 * @author Baltan
 * @date 2018/8/11 13:04
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int maxNum = Integer.MIN_VALUE;
        int maxIndex = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        int[] leftArray = new int[maxIndex];
        int[] rigthArray = new int[length - 1 - maxIndex];

        for (int i = 0; i < maxIndex; i++) {
            leftArray[i] = nums[i];
        }
        for (int i = maxIndex + 1; i < length; i++) {
            rigthArray[i - maxIndex - 1] = nums[i];
        }

        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rigthArray);
        return root;
    }
}
