package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 979. Distribute Coins in Binary Tree
 *
 * @author Baltan
 * @date 2019-12-03 09:36
 * <p>
 * 参考：
 * <a href="https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/solution/zai-er-cha-shu-zhong-fen-pei-ying-bi-by-leetcode/"></a>
 */
public class DistributeCoins {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 0, 0}, 0);
        System.out.println(distributeCoins(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, 3, 0}, 0);
        System.out.println(distributeCoins(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 0, 2}, 0);
        System.out.println(distributeCoins(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 0, 0, null, 3}, 0);
        System.out.println(distributeCoins(root4));
    }

    public static int distributeCoins(TreeNode root) {
        /**
         * 数组中的唯一元素保存移动的次数
         */
        int[] arr = new int[1];
        overloadQuantity(root, arr);
        return arr[0];
    }

    /**
     * 某一个节点的过载量
     *
     * @param root
     * @param arr
     * @return
     */
    public static int overloadQuantity(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        /**
         * 左子树的过载量，多的硬币都向父节点移动，不足的硬币从根节点获取
         */
        int leftOverloadQuantity = overloadQuantity(root.left, arr);
        /**
         * 右子树的过载量，多的硬币都向父节点移动，不足的硬币从根节点获取
         */
        int rightOverloadQuantity = overloadQuantity(root.right, arr);
        /**
         * 当前父节点的过载量
         */
        int overloadQuantity = leftOverloadQuantity + rightOverloadQuantity + root.val - 1;
        /**
         * 当前子树的移动总次数
         */
        arr[0] += Math.abs(leftOverloadQuantity) + Math.abs(rightOverloadQuantity);
        return overloadQuantity;
    }
}
