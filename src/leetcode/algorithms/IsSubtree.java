package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 572. Subtree of Another Tree
 *
 * @author Baltan
 * @date 2018/8/8 16:53
 */
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode root2 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);
        root2.left = node5;
        root2.right = node6;

        System.out.println(isSubtree(root1, root2));

        TreeNode root3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(2);
        TreeNode node11 = new TreeNode(0);
        root3.left = node7;
        root3.right = node8;
        node7.left = node9;
        node7.right = node10;
        node10.left = node11;

        System.out.println(isSubtree(root3, root2));

        TreeNode root4 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        root4.left = node12;
        root4.right = node13;

        TreeNode root5 = new TreeNode(1);
        TreeNode node14 = new TreeNode(2);
        root5.left = node14;

        System.out.println(isSubtree(root4, root5));

        TreeNode root6 = new TreeNode(1);

        TreeNode root7 = new TreeNode(1);

        System.out.println(isSubtree(root6, root7));

        TreeNode root8 = new TreeNode(1);
        TreeNode node15 = new TreeNode(1);
        TreeNode node16 = new TreeNode(1);
        TreeNode node17 = new TreeNode(1);
        TreeNode node18 = new TreeNode(1);
        TreeNode node19 = new TreeNode(1);
        TreeNode node20 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(1);
        TreeNode node23 = new TreeNode(1);
        TreeNode node24 = new TreeNode(1);
        TreeNode node25 = new TreeNode(2);
        root8.right = node15;
        node15.right = node16;
        node16.right = node17;
        node17.right = node18;
        node18.right = node19;
        node19.right = node20;
        node20.right = node21;
        node21.right = node22;
        node22.right = node23;
        node23.right = node24;
        node24.left = node25;

        TreeNode root9 = new TreeNode(1);
        TreeNode node26 = new TreeNode(1);
        TreeNode node27 = new TreeNode(1);
        TreeNode node28 = new TreeNode(1);
        TreeNode node29 = new TreeNode(1);
        TreeNode node30 = new TreeNode(1);
        TreeNode node31 = new TreeNode(1);
        TreeNode node32 = new TreeNode(2);
        root9.right = node26;
        node26.right = node27;
        node27.right = node28;
        node28.right = node29;
        node29.right = node30;
        node30.right = node31;
        node31.left = node32;

        System.out.println(isSubtree(root8, root9));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        List<Object> listS = tree2list(s);
        List<Object> listT = tree2list(t);
        System.out.println("listS:" + listS);
        System.out.println("listT:" + listT);
        return listS.toString().contains(listT.toString()) || listS.toString().equals(listT.toString());
    }

    public static List<Object> tree2list(TreeNode t) {
        List<Object> list = new ArrayList<>();

        if (t == null) {
            return list;
        }

        list.add(t.val);

        if (t.left != null) {
            list.add(tree2list(t.left));
        }
        if (t.right != null) {
            list.add(tree2list(t.right));
        }
        return list;
    }
}
