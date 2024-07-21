package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 839. Similar String Groups
 *
 * @author Baltan
 * @date 2024/7/14 19:48
 */
public class NumSimilarGroups {
    public static void main(String[] args) {
        System.out.println(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        System.out.println(numSimilarGroups(new String[]{"omv", "ovm"}));
    }

    public static int numSimilarGroups(String[] strs) {
        int result = 0;
        int length = strs.length;
        /**
         * parents[i]表示节点i的父节点
         */
        int[] parents = new int[length];
        /**
         * 初始化每个节点的父节点就是自己，即parents[i]=i
         */
        Arrays.setAll(parents, i -> i);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 如果字符串str1和str2是相似字符串，则在并查集中，它们应该在同一个连通分量中
                 */
                if (isSimilar(strs[i], strs[j])) {
                    int rootI = getRoot(parents, i);
                    int rootJ = getRoot(parents, j);
                    parents[rootI] = rootJ;
                }
            }
        }
        /**
         * 根据根节点数计算连通分量的个数
         */
        for (int i = 0; i < length; i++) {
            if (parents[i] == i) {
                result++;
            }
        }
        return result;
    }

    /**
     * 查找节点x的根节点
     *
     * @param parents
     * @param x
     * @return
     */
    public static int getRoot(int[] parents, int x) {
        while (parents[x] != x) {
            x = parents[x];
        }
        return x;
    }

    /**
     * 比较字符串str1和str2是否是相似字符串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isSimilar(String str1, String str2) {
        /**
         * 字符串str1和str2在相同索引位置上出现不同字符的次数
         */
        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
                /**
                 * 如果字符串str1和str2是相似字符串，则最多只能交换一次str1中的某两个字符的位置，所以str1和str2最多只有两个索引位置上的
                 * 字符不同
                 */
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
