package leetcode.algorithms;

/**
 * Description: 2924. Find Champion II
 *
 * @author Baltan
 * @date 2023/11/5 14:58
 * @see FindChampion
 */
public class FindChampion1 {
    public static void main(String[] args) {
        System.out.println(findChampion(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(findChampion(4, new int[][]{{0, 2}, {1, 3}, {1, 2}}));
    }

    public static int findChampion(int n, int[][] edges) {
        int result = -1;
        /**
         * losers[i]表示队伍i是否会失败
         */
        boolean[] losers = new boolean[n];

        for (int[] edge : edges) {
            /**
             * 因为队伍edge[0]比队伍edge[1]强，所以队伍edge[1]会失败
             */
            losers[edge[1]] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!losers[i]) {
                /**
                 * 存在至少两支队伍没有失败过，无法确定冠军，返回-1
                 */
                if (result != -1) {
                    return -1;
                }
                result = i;
            }
        }
        return result;
    }
}
