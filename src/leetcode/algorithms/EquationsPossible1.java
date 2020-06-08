package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 990. Satisfiability of Equality Equations
 *
 * @author Baltan
 * @date 2020-06-08 09:58
 * @see EquationsPossible
 */
public class EquationsPossible1 {
    public static void main(String[] args) {
        String[] equations1 = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations1));

        String[] equations2 = {"b==a", "a==b"};
        System.out.println(equationsPossible(equations2));

        String[] equations3 = {"a==b", "b==c", "a==c"};
        System.out.println(equationsPossible(equations3));

        String[] equations4 = {"a==b", "b!=c", "c==a"};
        System.out.println(equationsPossible(equations4));

        String[] equations5 = {"c==c", "b==d", "x!=z"};
        System.out.println(equationsPossible(equations5));

        String[] equations6 = {"c==c", "f!=a", "f==b", "b==c"};
        System.out.println(equationsPossible(equations6));

        String[] equations7 = {"a==b", "e==c", "b==c", "a!=e"};
        System.out.println(equationsPossible(equations7));

        String[] equations8 = {"a!=b", "b!=c", "c!=a"};
        System.out.println(equationsPossible(equations8));
    }

    /**
     * 并查集
     *
     * @param equations
     * @return
     */
    public static boolean equationsPossible(String[] equations) {
        /**
         * parents[i]为节点i沿着路径向上查找到的根节点
         */
        int[] parents = new int[26];
        /**
         * 初始化每个节点的父节点就是自己
         */
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        /**
         * 将所有等式两端的变量做合并处理
         */
        for (String equation : equations) {
            if (Objects.equals(equation.charAt(1), '=')) {
                union(parents, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        /**
         * 将所有不等式两端的变量做合并处理
         */
        for (String equation : equations) {
            if (Objects.equals(equation.charAt(1), '!')) {
                int xRoot = getRoot(parents, equation.charAt(0) - 'a');
                int yRoot = getRoot(parents, equation.charAt(3) - 'a');
                /**
                 * 如果两个变量向上查找到的根节点相等，说明这两个变量本身就在同一个集合中，即这两个变量的值
                 * 相等，与不等式矛盾，直接返回false
                 */
                if (xRoot == yRoot) {
                    return false;
                }
            }
        }
        return true;
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
     * 将节点x和节点y所在的集合合并，如果无法合并，说明x和y本身就在同一集合中，即x和y的值相等
     *
     * @param parents
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parents, int x, int y) {
        int xRoot = getRoot(parents, x);
        int yRoot = getRoot(parents, y);

        if (xRoot != yRoot) {
            parents[yRoot] = xRoot;
            return true;
        }
        return false;
    }
}
