package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0 || !Character.isDigit(S.charAt(0))) {
            return null;
        }

        if (!S.contains("-")) {
            return new TreeNode(Integer.valueOf(S));
        }

        int length = S.length();
        List<Integer> list = new ArrayList<>(2);
        TreeNode root = new TreeNode(Integer.valueOf(S.substring(0, S.indexOf("-"))));

        for (int i = 1; i < length - 1; i++) {
            if (S.charAt(i) == '-' && S.charAt(i - 1) != '-' && S.charAt(i + 1) != '-') {
                list.add(i);
            }
        }

        if (list.size() == 2) {
            String substr1 = S.substring(list.get(0) + 1, list.get(1));
            String substr2 = S.substring(list.get(1) + 1, length);
            int length1 = substr1.length();
            int length2 = substr2.length();
            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();

            for (int i = 0; i < length1; i++) {
                if (i - 1 >= 0 && substr1.charAt(i) == '-' && substr1.charAt(i - 1) != '-') {
                    continue;
                } else {
                    builder1.append(substr1.charAt(i));
                }
            }

            for (int i = 0; i < length2; i++) {
                if (i - 1 >= 0 && substr2.charAt(i) == '-' && substr2.charAt(i - 1) != '-') {
                    continue;
                } else {
                    builder2.append(substr2.charAt(i));
                }
            }

            root.left = recoverFromPreorder(builder1.toString());
            root.right = recoverFromPreorder(builder2.toString());
        } else if (list.size() == 1) {
            String substr1 = S.substring(list.get(0) + 1, length);
            int length1 = substr1.length();
            StringBuilder builder1 = new StringBuilder();

            for (int i = 0; i < length1; i++) {
                if (i - 1 >= 0 && substr1.charAt(i) == '-' && substr1.charAt(i - 1) != '-') {
                    continue;
                } else {
                    builder1.append(substr1.charAt(i));
                }
            }

            root.left = recoverFromPreorder(builder1.toString());
        }
        return root;
    }
}
