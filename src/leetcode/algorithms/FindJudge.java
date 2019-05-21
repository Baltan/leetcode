package leetcode.algorithms;

/**
 * Description: 997. Find the Town Judge
 *
 * @author Baltan
 * @date 2019-03-15 15:21
 */
public class FindJudge {
    public static void main(String[] args) {
        int[][] trust1 = {{1, 2}};
        System.out.println(findJudge(2, trust1));

        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println(findJudge(3, trust2));

        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, trust3));

        int[][] trust4 = {{1, 2}, {2, 3}};
        System.out.println(findJudge(3, trust4));

        int[][] trust5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(4, trust5));
    }

    public static int findJudge(int N, int[][] trust) {
        boolean[] book = new boolean[N + 1];
        int length = trust.length;

        for (int i = 0; i < length; i++) {
            book[trust[i][0]] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!book[i]) {
                int trustNum = 0;
                for (int j = 0; j < length; j++) {
                    if (trust[j][1] == i) {
                        trustNum++;
                    }
                }
                if (trustNum == N - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
