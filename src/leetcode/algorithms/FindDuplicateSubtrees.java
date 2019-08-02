package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 652. Find Duplicate Subtrees
 *
 * @author Baltan
 * @date 2019-08-02 08:50
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, null, null, 4}, 0);
        System.out.println(findDuplicateSubtrees(root1));

        TreeNode root2 = BinaryTreeUtils
                .arrayToBinaryTree(
                        new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, null, null, null, null, 0},
                        0);
        System.out.println(findDuplicateSubtrees(root2));
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        serialize(root, result, map);
        return result;
    }

    public static String serialize(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();

        if (root == null) {
            return builder.toString();
        } else {
            /**
             * 递归获得左子树和右子树序列化成字符串后的结果
             */
            String leftString = serialize(root.left, result, map);
            String rightString = serialize(root.right, result, map);
            /**
             * 拼接左子树字符串和右子树字符串，结果类似：
             * 0l0l0r0r0r0r0（左子树和右子树都不为空）、
             * 0l0l0（右子树为空）、
             * 0r0r0r0（左子树为空）、
             * 0（左子树和右子树都为空）
             */
            if (!Objects.equals(leftString, "")) {
                builder.append(leftString).append("l");
            }

            builder.append(root.val);

            if (!Objects.equals(rightString, "")) {
                builder.append("r").append(rightString);
            }
            /**
             * 如果左子树不为空，
             * 1、如果当前左子树字符串数量为1，就将左子树加入结果集，并将左子树字符串加1，
             * 2、否则只将左子树字符串加1
             */
            if (root.left != null) {
                Integer count = map.get(leftString);

                if (count != null && count == 1) {
                    result.add(root.left);
                    map.put(leftString, count + 1);
                } else {
                    map.put(leftString, count == null ? 1 : count + 1);
                }
            }
            /**
             * 如果右子树不为空，
             * 1、如果当前右子树字符串数量为1，就将右子树加入结果集，并将右子树字符串加1，
             * 2、否则只将右子树字符串加1
             */
            if (root.right != null) {
                Integer count = map.get(rightString);

                if (count != null && count == 1) {
                    result.add(root.right);
                    map.put(rightString, count + 1);
                } else {
                    map.put(rightString, count == null ? 1 : count + 1);
                }
            }
        }
        return builder.toString();
    }
}
