package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Description: 1110. Delete Nodes And Return Forest
 *
 * @author Baltan
 * @date 2019-08-10 12:17
 */
public class DelNodes {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        int[] to_delete1 = {3, 5};
        System.out.println(delNodes(root1, to_delete1));
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        if (to_delete == null || to_delete.length == 0) {
            result.add(root);
            return result;
        }

        Set<Integer> toDeleteSet = new HashSet<>();

        for (int value : to_delete) {
            toDeleteSet.add(value);
        }

        return helpDelNodes(root, toDeleteSet);
    }

    public static List<TreeNode> helpDelNodes(TreeNode root, Set<Integer> toDeleteSet) {
        List<TreeNode> result = new LinkedList<>();

        if (root == null) {
            return result;
        } else {
            /**
             * 如果root是要被删除的节点，递归root的左子树和右子树，加入结果集合
             */
            if (toDeleteSet.contains(root.val)) {
                result.addAll(helpDelNodes(root.left, toDeleteSet));
                result.addAll(helpDelNodes(root.right, toDeleteSet));
            } else {
                /**
                 * 如果root没有左子树和右子树，如果root要被删除，就返回空集合，否则返回集合中只有root一棵树
                 */
                if (root.left == null && root.right == null) {
                    if (!toDeleteSet.contains(root.val)) {
                        result.add(root);
                    }
                    return result;
                } else if (root.left == null) {
                    /**
                     * 如果root的右子树的根节点要被删除，递归该根节点的左子树和右子树，加入结果集合，并且root的右子树为空
                     */
                    if (toDeleteSet.contains(root.right.val)) {
                        result.addAll(helpDelNodes(root.right.left, toDeleteSet));
                        result.addAll(helpDelNodes(root.right.right, toDeleteSet));
                        root.right = null;
                    } else {
                        /**
                         * 递归root的右子树，获得的结果集合中，有一棵是root的删除节点后的右子树，需要重新对root的右子树赋值，
                         * 其余加入结果集合
                         */
                        List<TreeNode> rightResult = helpDelNodes(root.right, toDeleteSet);

                        for (TreeNode node : rightResult) {
                            if (node.val == root.right.val) {
                                root.right = node;
                            } else {
                                result.add(node);
                            }
                        }
                    }
                    /**
                     * 将删除节点后的root加入节点集合
                     */
                    result.add(root);
                } else if (root.right == null) {
                    /**
                     * 如果root的左子树的根节点要被删除，递归该根节点的左子树和右子树，加入结果集合，并且root的左子树为空
                     */
                    if (toDeleteSet.contains(root.left.val)) {
                        result.addAll(helpDelNodes(root.left.left, toDeleteSet));
                        result.addAll(helpDelNodes(root.left.right, toDeleteSet));
                        root.left = null;
                    } else {
                        /**
                         * 递归root的左子树，获得的结果集合中，有一棵是root的删除节点后的左子树，需要重新对root的左子树赋值，
                         * 其余加入结果集合
                         */
                        List<TreeNode> leftResult = helpDelNodes(root.left, toDeleteSet);

                        for (TreeNode node : leftResult) {
                            if (node.val == root.left.val) {
                                root.left = node;
                            } else {
                                result.add(node);
                            }
                        }
                    }
                    /**
                     * 将删除节点后的root加入节点集合
                     */
                    result.add(root);
                } else {
                    /**
                     * 如果root的右子树的根节点要被删除，递归该根节点的左子树和右子树，加入结果集合，并且root的右子树为空
                     */
                    if (toDeleteSet.contains(root.right.val)) {
                        result.addAll(helpDelNodes(root.right.left, toDeleteSet));
                        result.addAll(helpDelNodes(root.right.right, toDeleteSet));
                        root.right = null;
                    } else {
                        /**
                         * 递归root的右子树，获得的结果集合中，有一棵是root的删除节点后的右子树，需要重新对root的右子树赋值，
                         * 其余加入结果集合
                         */
                        List<TreeNode> rightResult = helpDelNodes(root.right, toDeleteSet);

                        for (TreeNode node : rightResult) {
                            if (node.val == root.right.val) {
                                root.right = node;
                            } else {
                                result.add(node);
                            }
                        }
                    }
                    /**
                     * 如果root的左子树的根节点要被删除，递归该根节点的左子树和右子树，加入结果集合，并且root的左子树为空
                     */
                    if (toDeleteSet.contains(root.left.val)) {
                        result.addAll(helpDelNodes(root.left.left, toDeleteSet));
                        result.addAll(helpDelNodes(root.left.right, toDeleteSet));
                        root.left = null;
                    } else {
                        /**
                         * 递归root的左子树，获得的结果集合中，有一棵是root的删除节点后的左子树，需要重新对root的左子树赋值，
                         * 其余加入结果集合
                         */
                        List<TreeNode> leftResult = helpDelNodes(root.left, toDeleteSet);

                        for (TreeNode node : leftResult) {
                            if (node.val == root.left.val) {
                                root.left = node;
                            } else {
                                result.add(node);
                            }
                        }
                    }
                    /**
                     * 将删除节点后的root加入节点集合
                     */
                    result.add(root);
                }
            }
        }
        return result;
    }
}
