package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1569. Number of Ways to Reorder Array to Get Same BST
 *
 * @author baltan
 * @date 2024/8/30 13:31
 */
public class NumOfWays1 {
    public static void main(String[] args) {
        System.out.println(numOfWays(new int[]{69, 54, 19, 8, 50, 62, 71, 7, 49, 42, 58, 14, 79, 41, 45, 43, 26, 9, 25, 60, 39, 46, 74, 76, 13, 47, 35, 15, 30, 61, 3, 33, 51, 24, 10, 66, 6, 52, 55, 16, 31, 22, 5, 12, 34, 40, 17, 75, 21, 36, 2, 78, 28, 68, 57, 80, 32, 29, 67, 48, 73, 59, 72, 23, 1, 27, 11, 70, 4, 18, 56, 63, 38, 81, 44, 37, 20, 65, 64, 77, 53}));
        System.out.println(numOfWays(new int[]{1, 5, 3, 4, 2, 7, 6}));
        System.out.println(numOfWays(new int[]{11, 1, 5, 8, 3, 15, 18, 4, 9, 2, 10, 7, 16, 12, 14, 6, 17, 13}));
        System.out.println(numOfWays(new int[]{30, 11, 46, 3, 29, 22, 37, 32, 13, 49, 48, 16, 40, 8, 24, 44, 9, 39, 25, 21, 41, 26, 43, 19, 47, 7, 10, 31, 45, 4, 35, 14, 20, 23, 15, 17, 38, 2, 6, 18, 5, 33, 27, 36, 42, 28, 12, 34, 1}));
        System.out.println(numOfWays(new int[]{31, 23, 14, 24, 15, 12, 25, 28, 5, 35, 17, 6, 9, 11, 1, 27, 18, 20, 2, 3, 33, 10, 13, 4, 7, 36, 32, 29, 8, 30, 26, 19, 34, 22, 21, 16}));
        System.out.println(numOfWays(new int[]{2, 1, 3}));
        System.out.println(numOfWays(new int[]{3, 4, 5, 1, 2}));
        System.out.println(numOfWays(new int[]{1, 2, 3}));
    }

    public static int numOfWays(int[] nums) {
        int mod = 1000000007;
        List<Integer> values = Arrays.stream(nums).boxed().toList();
        /**
         * leftCounts[i]表示二叉搜索树中值为i的节点的左子树中节点的总数
         */
        int[] leftCounts = new int[nums.length + 1];
        /**
         * rightCounts[i]表示二叉搜索树中值为i的节点的右子树中节点的总数
         */
        int[] rightCounts = new int[nums.length + 1];
        /**
         * combinations[i][j]表示从i个中取j个组合数，即C(i,j)
         */
        int[][] combinations = getCombinations(nums.length, mod);
        TreeNode root = buildTree(values, leftCounts, rightCounts);
        return (int) (numOfWays(root, leftCounts, rightCounts, combinations, mod) + mod - 1) % mod;
    }

    /**
     * 计算各种不同情况的组合数
     *
     * @param total
     * @param mod
     * @return
     */
    public static int[][] getCombinations(int total, int mod) {
        int[][] combinations = new int[total + 1][total + 1];
        /**
         * 不论总数是多少，一个都不取的组合数都为1
         */
        for (int i = 0; i <= total; i++) {
            combinations[i][0] = 1;
        }

        for (int i = 1; i <= total; i++) {
            for (int j = 1; j <= i; j++) {
                /**
                 * 组合数递推式：C(i,j)=C(i,j-1)+C(i-1,j-1)
                 * 参考：<a href="https://leetcode.cn/problems/number-of-ways-to-reorder-array-to-get-same-bst/solutions/403712/jiang-zi-shu-zu-zhong-xin-pai-xu-de-dao-tong-yi-2/"></a>
                 */
                combinations[i][j] = (combinations[i - 1][j] + combinations[i - 1][j - 1]) % mod;
            }
        }
        return combinations;
    }

    /**
     * 按照数组values中元素的顺序构建出一棵二叉搜索树，同时记录下每个节点的左右子树中节点的总数
     *
     * @param values
     * @param leftCounts
     * @param rightCounts
     * @return
     */
    public static TreeNode buildTree(List<Integer> values, int[] leftCounts, int[] rightCounts) {
        if (values.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(values.getFirst());
        /**
         * 节点root的左子树中所有节点的值，这些节点的值都小于root的值
         */
        List<Integer> leftValues = new ArrayList<>();
        /**
         * 节点root的右子树中所有节点的值，这些节点的值都大于root的值
         */
        List<Integer> rightValues = new ArrayList<>();

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < values.getFirst()) {
                leftValues.add(values.get(i));
            } else {
                rightValues.add(values.get(i));
            }
        }
        leftCounts[values.getFirst()] = leftValues.size();
        rightCounts[values.getFirst()] = rightValues.size();
        /**
         * 递归构建节点root的左子树
         */
        root.left = buildTree(leftValues, leftCounts, rightCounts);
        /**
         * 递归构建节点root的右子树
         */
        root.right = buildTree(rightValues, leftCounts, rightCounts);
        return root;
    }

    /**
     * 计算按照题目要求可以构建出二叉搜索树root的数组的个数
     *
     * @param root
     * @param leftCounts
     * @param rightCounts
     * @param combinations
     * @param mod
     * @return
     */
    public static long numOfWays(TreeNode root, int[] leftCounts, int[] rightCounts, int[][] combinations, int mod) {
        if (root == null) {
            return 1L;
        }
        /**
         * 根节点root的左右子树中节点的总数
         */
        int total = leftCounts[root.val] + rightCounts[root.val];
        /**
         * 数组的第一个元素必为二叉搜索树的根节点的值，剩下的元素可以构建出根节点的左子树和右子树。显然左子树中的节点值在数组中出现的顺序是不
         * 影响右子树的构建的，反之亦然。所以只需从数组剩余total个位置中选出leftCounts[root.val]个用于安排左子树中的节点值，剩余位置安排
         * 右子树中的节点值即可。其中左右子树各自的构建可以递归处理
         */
        long combination = combinations[total][leftCounts[root.val]];
        long leftNumOfWays = numOfWays(root.left, leftCounts, rightCounts, combinations, mod);
        long rightNumOfWays = numOfWays(root.right, leftCounts, rightCounts, combinations, mod);
        return ((combination * leftNumOfWays % mod) * rightNumOfWays) % mod;
    }
}
