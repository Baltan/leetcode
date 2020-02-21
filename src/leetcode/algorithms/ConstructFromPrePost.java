package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Arrays;

/**
 * Description: 889. Construct Binary Tree from Preorder and Postorder Traversal
 *
 * @author Baltan
 * @date 2020-02-21 14:01
 */
public class ConstructFromPrePost {
    public static void main(String[] args) {
        int[] pre1 = {1, 2, 4, 5, 3, 6, 7};
        int[] post1 = {4, 5, 2, 6, 7, 3, 1};
        System.out.println(constructFromPrePost(pre1, post1));
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;

        if (length == 0) {
            return null;
        } else if (length == 1) {
            return new TreeNode(pre[0]);
        }

        TreeNode root = new TreeNode(pre[0]);
        /**
         * 如果pre[1]==post[length-2]，则root只有左子树或只有右子树，返回任意一种情况即可，假
         * 设root只有左子树。
         */
        if (pre[1] == post[length - 2]) {
            /**
             * root的左子树的前序遍历
             */
            int[] leftTreePre = Arrays.copyOfRange(pre, 1, length);
            /**
             * root的右子树的后序遍历
             */
            int[] leftTreePost = Arrays.copyOfRange(post, 0, length - 1);
            root.left = constructFromPrePost(leftTreePre, leftTreePost);
        } else {
            /**
             * pre[1]在post中的索引位置
             */
            int index = 0;
            /**
             * 当root同时有左子树和右子树时，pre[1]为左子树的根节点值，在post中找到pre[1]所在
             * 的索引位置，则该位置之前的序列就是root的左子树的后序遍历
             */
            while (post[index] != pre[1]) {
                index++;
            }
            /**
             * root的左子树的后序遍历
             */
            int[] leftTreePost = Arrays.copyOfRange(post, 0, index + 1);
            /**
             * root的左子树的前序遍历
             */
            int[] leftTreePre = Arrays.copyOfRange(pre, 1, 1 + leftTreePost.length);
            /**
             * root的右子树的后序遍历
             */
            int[] rightTreePost = Arrays.copyOfRange(post, index + 1, length - 1);
            /**
             * root的右子树的前序遍历
             */
            int[] rightTreePre = Arrays.copyOfRange(pre, 1 + leftTreePost.length, length);
            root.left = constructFromPrePost(leftTreePre, leftTreePost);
            root.right = constructFromPrePost(rightTreePre, rightTreePost);
        }
        return root;
    }
}
