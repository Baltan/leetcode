package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Objects;

/**
 * Description: 1028. Recover a Tree From Preorder Traversal
 *
 * @author Baltan
 * @date 2019-04-18 09:45
 */
public class RecoverFromPreorder {
    public static void main(String[] args) {
        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(recoverFromPreorder("1-401--349---90--88"));
        System.out.println(recoverFromPreorder("3"));
    }

    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || Objects.equals(S, "")) {
            return null;
        }
        /**
         * levels[i]表示最近遍历到的第i层的节点
         */
        TreeNode[] levels = new TreeNode[1000];
        /**
         * hasChild[i]表示最近遍历到的第i层的节点是否已经找到子节点
         */
        boolean[] hasChild = new boolean[1000];
        /**
         * 当前遍历到的节点的值
         */
        int value = 0;
        /**
         * 当前遍历的到的连续"-"的个数，即当前处理到的节点的层数（0-based）
         */
        int dashCount;
        int length = S.length();
        char[] charArray = S.toCharArray();
        /**
         * 当前遍历到的S中的字符的索引位置
         */
        int index = 0;
        /**
         * 查找根节点的值
         */
        while (index < length && charArray[index] != '-') {
            value = value * 10 + (charArray[index] - '0');
            index++;
        }

        levels[0] = new TreeNode(value);

        while (index < length) {
            /**
             * 还原dashCount和value的初始值
             */
            dashCount = 0;
            value = 0;
            /**
             * 查找下一个节点前连续的"-"的个数，确定下一个节点的层数
             */
            while (index < length && charArray[index] == '-') {
                dashCount++;
                index++;
            }
            /**
             * 查找下一个节点的值
             */
            while (index < length && charArray[index] != '-') {
                value = value * 10 + (charArray[index] - '0');
                index++;
            }
            /**
             * 创建下一个节点对象
             */
            TreeNode node = new TreeNode(value);
            /**
             * 更新第dashCount层的节点，接下去如果还有第dashCount+1层的节点，只可能为该节点的子节点
             */
            levels[dashCount] = node;
            /**
             * 标记当前第dashCount层的节点没有子节点
             */
            hasChild[dashCount] = false;
            /**
             * 如果第dashCount-1层的节点已经有了子节点（即左子节点），则当前第dashCount层的节点为上层节
             * 点的右子节点，否则为左子节点
             */
            if (!hasChild[dashCount - 1]) {
                levels[dashCount - 1].left = node;
                /**
                 * 标记第dashCount-1层的节点已经有了子节点
                 */
                hasChild[dashCount - 1] = true;
            } else {
                levels[dashCount - 1].right = node;
            }
        }
        return levels[0];
    }
}
