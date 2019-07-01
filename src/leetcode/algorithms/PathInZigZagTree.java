package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1104. Path In Zigzag Labelled Binary Tree
 *
 * @author Baltan
 * @date 2019-07-01 09:49
 */
public class PathInZigZagTree {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(1));
        System.out.println(pathInZigZagTree(4));
        System.out.println(pathInZigZagTree(14));
        System.out.println(pathInZigZagTree(26));
        System.out.println(pathInZigZagTree(32));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<>();

        while (label > 0) {
            result.add(0, label);
            label = prev(label);
        }
        return result;
    }

    /**
     * 获得当前节点的父节点的权值
     *
     * @param label
     * @return
     */
    public static int prev(int label) {
        /**
         * 当前节点所在层数
         */
        int levelNum = (int) (Math.log(label) / Math.log(2)) + 1;
        /**
         * 该层节点最小的权值，为2^(层数-1)
         */
        int levelMin = (int) Math.pow(2, levelNum - 1);
        /**
         * 对于同一层的奇数节点或偶数节点而言，节点的权值+2*父节点的权值是恒定的
         */
        int evenSum = levelMin + 2 * (levelMin - 1);
        int oddSum = levelMin + 1 + 2 * (levelMin - 1);
        return (label & 1) == 1 ? (oddSum - label) >> 1 : (evenSum - label) >> 1;
    }
}
