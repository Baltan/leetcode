package leetcode.algorithms;

/**
 * Description: 1361. Validate Binary Tree Nodes
 *
 * @author Baltan
 * @date 2020-03-15 11:51
 */
public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int[] leftChild1 = {1, -1, 3, -1};
        int[] rightChild1 = {2, -1, -1, -1};
        System.out.println(validateBinaryTreeNodes(4, leftChild1, rightChild1));

        int[] leftChild2 = {1, -1, 3, -1};
        int[] rightChild2 = {2, 3, -1, -1};
        System.out.println(validateBinaryTreeNodes(4, leftChild2, rightChild2));

        int[] leftChild3 = {1, 0};
        int[] rightChild3 = {-1, -1};
        System.out.println(validateBinaryTreeNodes(2, leftChild3, rightChild3));

        int[] leftChild4 = {1, -1, -1, 4, -1, -1};
        int[] rightChild4 = {2, -1, -1, 5, -1, -1};
        System.out.println(validateBinaryTreeNodes(6, leftChild4, rightChild4));
    }

    /**
     * 并查集
     *
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        /**
         * parent[i]为节点i沿着路径向上查找到的根节点
         */
        int[] parent = new int[n];
        /**
         * 初始化每个节点的父节点就是自己
         */
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            /**
             * 如果无法合并，说明存在环路，不是有效的二叉树
             */
            if (!union(parent, i, leftChild[i]) || !union(parent, i, rightChild[i])) {
                return false;
            }
        }
        /**
         * 如果存在多个根节点，说明所有节点不在一棵二叉树中，不是有效的二叉树
         */
        for (int i = 1; i < n; i++) {
            if (parent[i] != parent[0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查找节点x的根节点
     *
     * @param parent
     * @param x
     * @return
     */
    public static int getRoot(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    /**
     * 将节点x和节点y所在的集合合并，如果无法合并，说明x和y本身就在同一集合中，再连接x和y构成环路
     *
     * @param parent
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parent, int x, int y) {
        /**
         * 如果y为-1，说明x无法走到其他节点
         */
        if (y == -1) {
            return true;
        }

        int xRoot = getRoot(parent, x);
        int yRoot = getRoot(parent, y);

        if (xRoot != yRoot) {
            /**
             * 因为如果y不为-1的话，y是x的子节点，所以总是将xRoot作为合并后的根节点
             */
            parent[yRoot] = xRoot;
            return true;
        }
        return false;
    }
}
