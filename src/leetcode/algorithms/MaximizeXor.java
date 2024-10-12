package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1707. Maximum XOR With an Element From Array
 *
 * @author Baltan
 * @date 2024/10/11 23:43
 */
public class MaximizeXor {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4};
        int[][] queries1 = {{3, 1}, {1, 3}, {5, 6}};
        OutputUtils.print1DIntegerArray(maximizeXor(nums1, queries1));

        int[] nums2 = {5, 2, 4, 6, 6, 3};
        int[][] queries2 = {{12, 4}, {8, 1}, {6, 3}};
        OutputUtils.print1DIntegerArray(maximizeXor(nums2, queries2));

        int[] nums3 = {536870912, 0, 534710168, 330218644, 142254206};
        int[][] queries3 = {{558240772, 1000000000}, {307628050, 1000000000}, {3319300, 1000000000}, {2751604, 683297522}, {214004, 404207941}};
        OutputUtils.print1DIntegerArray(maximizeXor(nums3, queries3));
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        /**
         * 二进制字典树根节点
         */
        Node root = new Node(new Node[2]);
        Arrays.sort(nums);
        /**
         * 将数组nums中所有数字的二进制值构建为一棵层高为32的二进制字典树
         */
        for (int num : nums) {
            buildTree(root, num);
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * 数组nums中不存在小于等于max的值可以和x进行按位异或计算，查询结果为-1
             */
            if (nums[0] > queries[i][1]) {
                result[i] = -1;
                continue;
            }
            /**
             * 递归计算queries[queryIndex]的查询结果
             */
            dfs(result, i, root, queries[i][0], queries[i][1], 31, 0);
        }
        return result;
    }

    /**
     * 递归计算queries[queryIndex]的查询结果
     *
     * @param result
     * @param queryIndex
     * @param root
     * @param x          即queries[queryIndex][0]
     * @param max        即queries[queryIndex][1]
     * @param bitIndex   当前判断x的二进制值由低到高第bitIndex位
     * @param value      从数组nums中查找要和x进行按位异或计算，使得结果最大的数字当前的值
     * @return
     */
    public static boolean dfs(int[] result, int queryIndex, Node root, int x, int max, int bitIndex, int value) {
        /**
         * 已完成x的二进制值每一位的判断，结束递归计算
         */
        if (bitIndex < 0) {
            return true;
        }
        /**
         * x的二进制值由低到高第bitIndex位上的值
         */
        int bit = x >> bitIndex & 1;
        boolean res;
        /**
         * 为了使得查询结果最大，则应该使得x和num按位异或的二进制值低到高第i位上尽可能为1，因为x的二进制值在该位上为bit，则num的二进制值在
         * 该位上为1-bit
         */
        if (root.children[1 - bit] != null && value + ((1 - bit) << bitIndex) <= max) {
            /**
             * 查询结果的二进制值在该位上为1
             */
            result[queryIndex] += (1 << bitIndex);
            /**
             * 递归判断x的二进制值由低到高第bitIndex-1位
             */
            res = dfs(result, queryIndex, root.children[1 - bit], x, max, bitIndex - 1, value + ((1 - bit) << bitIndex));
            /**
             * 当递归结果为true时，说明num的二进制值由低到高第bitIndex位可以为1-bit，即查询结果的二进制值由低到高第bitIndex位可以为1。
             * 否则需要判断num的二进制值由低到高第bitIndex位为bit时的情况
             */
            if (res) {
                return true;
            } else {
                /**
                 * 查询结果的二进制值由低到高第bitIndex位不可以为1，还原计算前的状态
                 */
                result[queryIndex] -= (1 << bitIndex);
            }
        }
        /**
         * 判断num的二进制值由低到高第bitIndex位能否为bit
         */
        if (root.children[bit] != null && value + (bit << bitIndex) <= max) {
            /**
             * 当num的二进制值由低到高第bitIndex位为bit时，递归判断x的二进制值由低到高第bitIndex-1位
             */
            return dfs(result, queryIndex, root.children[bit], x, max, bitIndex - 1, value + (bit << bitIndex));
        } else {
            return false;
        }
    }

    /**
     * 构建二进制字典树
     *
     * @param root
     * @param num
     */
    public static void buildTree(Node root, int num) {
        /**
         * 从num的二进制值的高位向低位遍历
         */
        for (int i = 31; i >= 0; i--) {
            /**
             * num的二进制值由低到高第i位上的值
             */
            int bit = num >> i & 1;

            if (root.children[bit] == null) {
                root.children[bit] = new Node(new Node[2]);
            }
            root = root.children[bit];
        }
    }

    /**
     * 二进制字典树节点
     */
    public static class Node {
        /**
         * 当前节点的所有子节点，children[i]不为null表示二进制值在该位上为i的数字存在
         */
        private final Node[] children;

        public Node(Node[] children) {
            this.children = children;
        }
    }
}
