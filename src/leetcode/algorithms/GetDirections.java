package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 2096. Step-By-Step Directions From a Binary Tree Node to Another
 *
 * @author Baltan
 * @date 2023/1/24 14:39
 */
public class GetDirections {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 2, 3, null, 6, 4}, 0);
        System.out.println(getDirections(root1, 3, 6));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1}, 0);
        System.out.println(getDirections(root2, 2, 1));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        int max = 100001;
        List<Integer>[] paths = new List[max];
        List<Character>[] directions = new List[max];
        boolean[] isVisited = new boolean[max];
        Queue<Integer> valueQueue = new LinkedList<>();
        Queue<StringBuilder> directionQueue = new LinkedList<>();
        valueQueue.offer(startValue);
        directionQueue.offer(new StringBuilder());
        isVisited[startValue] = true;

        for (int i = 0; i < max; i++) {
            paths[i] = new ArrayList<>();
            directions[i] = new ArrayList<>();
        }
        getPaths(root, paths, directions);

        while (!valueQueue.isEmpty()) {
            int currValue = valueQueue.poll();
            StringBuilder direction = directionQueue.poll();

            if (currValue == destValue) {
                return direction.toString();
            }

            for (int i = 0; i < paths[currValue].size(); i++) {
                int nextValue = paths[currValue].get(i);

                if (!isVisited[nextValue]) {
                    valueQueue.offer(nextValue);
                    directionQueue.offer(new StringBuilder(direction).append(directions[currValue].get(i)));
                    isVisited[nextValue] = true;
                }
            }
        }
        return null;
    }

    public static void getPaths(TreeNode root, List<Integer>[] paths, List<Character>[] directions) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            paths[root.val].add(root.left.val);
            directions[root.val].add('L');

            paths[root.left.val].add(root.val);
            directions[root.left.val].add('U');
            getPaths(root.left, paths, directions);
        }

        if (root.right != null) {
            paths[root.val].add(root.right.val);
            directions[root.val].add('R');

            paths[root.right.val].add(root.val);
            directions[root.right.val].add('U');
            getPaths(root.right, paths, directions);
        }
    }
}
