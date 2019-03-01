package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;
import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Find Mode in Binary Search Tree
 *
 * @author Baltan
 * @date 2019-03-01 09:54
 */
public class FindMode {
    public static void main(String[] args) {
        Integer[] arr1 = {1, null, 2, null, null, 2};
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(arr1, 0);
        OutputUtils.print1DIntegerArray(findMode(root1));

        Integer[] arr2 = {1, null, 2};
        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(arr2, 0);
        OutputUtils.print1DIntegerArray(findMode(root2));
    }

    public static int[] findMode(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> list = inOrder(root);
        int maxFrequency = 0;
        int currentFrequency = 0;
        int currentNum = 0;
        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            if (i == 0) {
                currentNum = list.get(0);
                currentFrequency++;
            } else {
                if (list.get(i).equals(list.get(i - 1))) {
                    currentFrequency++;
                } else {
                    currentNum = list.get(i);
                    currentFrequency = 1;
                }
            }

            if (currentFrequency == maxFrequency) {
                resultList.add(currentNum);
            } else if (currentFrequency > maxFrequency) {
                resultList.clear();
                resultList.add(currentNum);
                maxFrequency = currentFrequency;
            }
        }

        int size = resultList.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(inOrder(root.left));
        list.add(root.val);
        list.addAll(inOrder(root.right));

        return list;
    }
}
