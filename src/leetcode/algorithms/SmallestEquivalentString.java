package leetcode.algorithms;

/**
 * Description: 1061. Lexicographically Smallest Equivalent String
 *
 * @author Baltan
 * @date 2023/1/30 14:54
 */
public class SmallestEquivalentString {
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker", "morris", "parser"));
        System.out.println(smallestEquivalentString("hello", "world", "hold"));
        System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int length = s1.length();
        int count = 26;
        /**
         * 假设字符a-z对应的索引分别为0-25，将所有等价的字符的索引构建成树结构，parents[i]代表索引i的父索引
         */
        int[] parents = new int[count];
        char[] charArray = baseStr.toCharArray();
        /**
         * 初始化假设所有索引的父索引都是其自身
         */
        for (int i = 0; i < count; i++) {
            parents[i] = i;
        }
        /**
         * 并查集构建多个独立的索引集合
         */
        for (int i = 0; i < length; i++) {
            union(parents, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        /**
         * 将字符串baseStr中的每个字符都替换成该字符的索引所在索引树的根索引对应的字符
         */
        for (int i = 0; i < charArray.length; i++) {
            int root = getRoot(parents, charArray[i] - 'a');
            charArray[i] = (char) (root + 'a');
        }
        return new String(charArray);
    }

    /**
     * 查找索引index的根索引
     *
     * @param parents
     * @param index
     * @return
     */
    public static int getRoot(int[] parents, int index) {
        while (parents[index] != index) {
            index = parents[index];
        }
        return index;
    }

    /**
     * 能否将索引x所在的集合和索引y所在的集合合并
     *
     * @param parents
     * @param index1
     * @param index2
     */
    public static void union(int[] parents, int index1, int index2) {
        int root1 = getRoot(parents, index1);
        int root2 = getRoot(parents, index2);

        if (root1 != root2) {
            int min = Math.min(root1, root2);
            int max = Math.max(root1, root2);
            /**
             * 总是令父索引的值小于子索引，则一个索引集合中根索引的值就是最小的
             */
            parents[max] = min;
        }
    }
}
