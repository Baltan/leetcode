package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 面试题 04.09. 二叉搜索树序列
 *
 * @author Baltan
 * @date 2020-03-14 14:42
 */
public class BSTSequences {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3}, 0);
        System.out.println(BSTSequences(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, 6, 1, 3, 5, 7}, 0);
        System.out.println(BSTSequences(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(BSTSequences(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(BSTSequences(root4));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        System.out.println(BSTSequences(root5));

        TreeNode root6 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{5, 2, null, 1, 4, null, null, null, null, 3}, 0);
        System.out.println(BSTSequences(root6));

        TreeNode root7 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{5, 1, 7, null, 2, 6, null, null, null, null, 4, null, null, null, null, null,
                        null, null, null, null, null, 3}, 0);
        System.out.println(BSTSequences(root7));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/bst-sequences-lcci/solution/c-shi-yong-shuang-duan-dui-lie-di-gui-qiu-jie-16-m/"></a>
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            return Arrays.asList(Arrays.asList());
        }

        List<List<Integer>> result = new LinkedList<>();
        /**
         * 保存数组中的元素
         */
        List<Integer> list = new LinkedList<>();
        /**
         * deque中保存下一步可以添加到二叉树中的节点
         */
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        dfs(result, list, deque);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> list, Deque<TreeNode> deque) {
        if (deque.isEmpty()) {
            result.add(new LinkedList<>(list));
            return;
        }

        int size = deque.size();

        for (int i = 0; i < size; i++) {
            /**
             * 当前一步添加到二叉树中的节点，则下一步可以添加的节点包括：
             * 1、当前节点的左节点
             * 2、当前节点的右节点
             * 3、旁边子树上的节点
             */
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            /**
             * 记录添加到队列中的子节点的个数，递归后需要将入队的子节点都出队，使队列还原到当前状态
             */
            int count = 0;

            if (node.left != null) {
                count++;
                deque.offerLast(node.left);
            }

            if (node.right != null) {
                count++;
                deque.offerLast(node.right);
            }

            dfs(result, list, deque);
            /**
             * 将之前加入队列的子节点都出队
             */
            for (int j = 0; j < count; j++) {
                deque.pollLast();
            }
            /**
             * 将这步添加到二叉树中的节点重新加到队列最后，使得队列中的节点仍然是初始时的那些节点，只是改变
             * 了节点顺序
             */
            deque.offerLast(node);
            list.remove(list.size() - 1);
        }
    }
}
