package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3043. Find the Length of the Longest Common Prefix
 *
 * @author baltan
 * @date 2024/2/23 09:01
 */
public class LongestCommonPrefix1 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{8}, new int[]{48}));
        System.out.println(longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000}));
        System.out.println(longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4}));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int result = 0;
        Node root = new Node();
        buildTrie(root, arr1);
        /**
         * 依次将数组arr2中的每一个数字在字典树root中匹配前缀
         */
        for (int num : arr2) {
            List<Integer> digits = getDigits(num);
            Node node = root;
            /**
             * 数字num和字典树root的公共前缀的长度
             */
            int prefixLength = 0;

            for (int i = digits.size() - 1; i >= 0; i--) {
                int digit = digits.get(i);

                if (node.children[digit] == null) {
                    break;
                }
                node = node.children[digit];
                result = Math.max(result, ++prefixLength);
            }
        }
        return result;
    }

    /**
     * 用数组arr中的所有数字构建字典树root
     *
     * @param root
     * @param arr
     */
    public static void buildTrie(Node root, int[] arr) {
        for (int num : arr) {
            Node node = root;
            List<Integer> digits = getDigits(num);

            for (int i = digits.size() - 1; i >= 0; i--) {
                int digit = digits.get(i);

                if (node.children[digit] == null) {
                    node.children[digit] = new Node();
                }
                node = node.children[digit];
            }
        }
    }

    /**
     * 从低位到高位依次得到数字num每一个数位上的数字
     *
     * @param num
     * @return
     */
    public static List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    /**
     * 字典树节点
     */
    public static class Node {
        /**
         * 所有子节点
         */
        private final Node[] children = new Node[10];
    }
}
