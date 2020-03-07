package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1202. Smallest String With Swaps
 *
 * @author Baltan
 * @date 2020-03-06 13:54
 */
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        List<List<Integer>> pairs1 = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2));
        System.out.println(smallestStringWithSwaps("dcab", pairs1));

        List<List<Integer>> pairs2 = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0
                , 2));
        System.out.println(smallestStringWithSwaps("dcab", pairs2));

        List<List<Integer>> pairs3 = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2));
        System.out.println(smallestStringWithSwaps("cba", pairs3));
    }

    /**
     * 并查集
     * 参考：
     * <a href="https://leetcode-cn.com/problems/smallest-string-with-swaps/solution/bing-cha-ji-python-by-fa-kuang-de-jie-zi/"></a>
     *
     * @param s
     * @param pairs
     * @return
     */
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        char[] charArray = new char[length];
        /**
         * parent[i]是节点i的父节点，节点i的值代表字符串s的某个索引位置
         */
        int[] parent = new int[length];
        /**
         * 根节点->这个根节点的所有后继节点（包括根节点）代表的索引位置的升序排列
         */
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();
        /**
         * 根节点->这个根节点的所有后继节点（包括根节点）代表的索引位置对应s中的字符的升序排列
         */
        Map<Integer, Queue<Character>> charMap = new HashMap<>();
        /**
         * 初始化每个节点的父节点就是自己
         */
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
        /**
         * 建立集合
         */
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        /**
         * 将parent[i]修改为节点i的根节点
         */
        for (int i = 0; i < length; i++) {
            parent[i] = getRoot(parent, parent[i]);
        }

        for (int i = 0; i < length; i++) {
            int root = parent[i];
            indexMap.putIfAbsent(root, new PriorityQueue<>());
            charMap.putIfAbsent(root, new PriorityQueue<>());
            indexMap.get(root).offer(i);
            charMap.get(root).offer(s.charAt(i));
        }
        /**
         * 将每个集合中的字符都按照升序排列后放回该集合中升序排列后的索引位置。例如：
         * s="dcab"，pairs=[[0,3],[1,2],[0,2]]，节点0、1、2、3是同一个集合的，他们的根
         * 节点都为0，可以得到indexMap={0,[0,1,2,3]}，charMap={0,['a','b','c','d']}，
         * 将'a','b','c','d'逐一放到0、1、2、3四个索引位置即可
         */
        for (Map.Entry<Integer, Queue<Integer>> entry : indexMap.entrySet()) {
            int root = entry.getKey();
            Queue<Integer> indexQueue = indexMap.get(root);
            Queue<Character> charQueue = charMap.get(root);

            while (!indexQueue.isEmpty()) {
                int index = indexQueue.poll();
                char c = charQueue.poll();
                charArray[index] = c;
            }
        }
        return new String(charArray);
    }

    /**
     * 查找节点value的根节点
     *
     * @param parent
     * @param value
     * @return
     */
    public static int getRoot(int[] parent, int value) {
        while (parent[value] != value) {
            value = parent[value];
        }
        return value;
    }

    /**
     * 将value1所在的集合和value2所在的集合合并
     *
     * @param parent
     * @param value1
     * @param value2
     */
    public static void union(int[] parent, int value1, int value2) {
        int root1 = getRoot(parent, value1);
        int root2 = getRoot(parent, value2);
        /**
         * 总是将更小的值作为父节点
         */
        if (root1 < root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }
}
