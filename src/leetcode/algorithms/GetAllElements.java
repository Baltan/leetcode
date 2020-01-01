package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1305. All Elements in Two Binary Search Trees
 *
 * @author Baltan
 * @date 2020-01-01 09:46
 */
public class GetAllElements {
    public static void main(String[] args) {
        TreeNode root11 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 4}, 0);
        TreeNode root12 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 0, 3}, 0);
        System.out.println(getAllElements(root11, root12));

        TreeNode root21 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, -10, 10}, 0);
        TreeNode root22 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 7, 0, 2}, 0);
        System.out.println(getAllElements(root21, root22));

        TreeNode root31 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        TreeNode root32 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 7, 0, 2}, 0);
        System.out.println(getAllElements(root31, root32));

        TreeNode root41 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, -10, 10}, 0);
        TreeNode root42 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(getAllElements(root41, root42));

        TreeNode root51 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 8}, 0);
        TreeNode root52 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{8, 1}, 0);
        System.out.println(getAllElements(root51, root52));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();
        List<Integer> list1 = inOrder(root1);
        List<Integer> list2 = inOrder(root2);
        int index1 = 0;
        int index2 = 0;
        /**
         * 将两颗二叉搜索树中序遍历得到的列表按从小到大的顺序依次取出加入result
         */
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) <= list2.get(index2)) {
                result.add(list1.get(index1));
                index1++;
            } else {
                result.add(list2.get(index2));
                index2++;
            }
        }

        while (index1 < list1.size()) {
            result.add(list1.get(index1));
            index1++;
        }

        while (index2 < list2.size()) {
            result.add(list2.get(index2));
            index2++;
        }
        return result;
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        } else {
            list.addAll(inOrder(root.left));
            list.add(root.val);
            list.addAll(inOrder(root.right));
            return list;
        }
    }
}
