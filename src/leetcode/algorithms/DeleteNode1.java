package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Delete Node in a BST
 *
 * @author Baltan
 * @date 2019-02-22 10:31
 */
public class DeleteNode1 {
    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode node = searchNode(root, key);
        if (node == null) {
            return root;
        }
        TreeNode parent = searchParentNode(root, key);

        if (node.left == null && node.right == null) {
            if (parent == null) {
                root = null;
            } else {
                if (parent.left != null && parent.left.val == key) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (node.left != null && node.right == null) {
            if (parent == null) {
                root = root.left;
            } else {
                if (parent.left != null && parent.left.val == key) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        } else if (node.right != null && node.left == null) {
            if (parent == null) {
                root = root.right;
            } else {
                if (parent.left != null && parent.left.val == key) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        } else {
            int minValue = deleteMinNode(root, node.right);
            node.val = minValue;
        }
        return root;
    }

    private static int deleteMinNode(TreeNode root, TreeNode subRoot) {
        TreeNode node = subRoot;
        while (node.left != null) {
            node = node.left;
        }
        if (subRoot.val == node.val) {
            TreeNode parent = searchParentNode(root, node.val);
            parent.right = node.right;
        } else {
            deleteNode(subRoot, node.val);
        }
        return node.val;
    }

    private static TreeNode searchParentNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        } else if (key < root.val) {
            if (root.left == null) {
                return null;
            } else {
                if (root.left != null && root.left.val == key) {
                    return root;
                } else {
                    return searchParentNode(root.left, key);
                }
            }
        } else if (key > root.val) {
            if (root.right == null) {
                return null;
            } else {
                if (root.right != null && root.right.val == key) {
                    return root;
                } else {
                    return searchParentNode(root.right, key);
                }
            }
        }
        return null;
    }

    private static TreeNode searchNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return root;
        } else if (root.val < key) {
            return searchNode(root.right, key);
        } else {
            return searchNode(root.left, key);
        }
    }
}