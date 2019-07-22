package leetcode.algorithms;

/**
 * Description: 1128. Number of Equivalent Domino Pairs
 *
 * @author Baltan
 * @date 2019-07-22 09:10
 */
public class NumEquivDominoPairs {
    public static void main(String[] args) {
        int[][] dominoes1 = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(dominoes1));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        int[][] book = new int[10][10];

        for (int[] dominoe : dominoes) {
            int min = Math.min(dominoe[0], dominoe[1]);
            int max = Math.max(dominoe[0], dominoe[1]);
            book[min][max]++;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result += book[i][j] * (book[i][j] - 1) >> 1;
            }
        }
        return result;
    }
}
