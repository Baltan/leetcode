package leetcode.algorithms;

/**
 * Description: 1791. Find Center of Star Graph
 *
 * @author Baltan
 * @date 2022/7/4 10:04
 */
public class FindCenter {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges1));

        int[][] edges2 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(findCenter(edges2));
    }

    public static int findCenter(int[][] edges) {
        /**
         * 任意两条边即可确定中心点
         */
        int[] first = edges[0];
        int[] second = edges[1];
        /**
         * first[0]和first[1]中必有一个中心点
         */
        return first[0] == second[0] || first[0] == second[1] ? first[0] : first[1];
    }
}
