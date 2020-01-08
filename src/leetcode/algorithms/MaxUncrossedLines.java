package leetcode.algorithms;

/**
 * Description: 1035. Uncrossed Lines
 *
 * @author Baltan
 * @date 2020-01-07 12:52
 */
public class MaxUncrossedLines {
    public static void main(String[] args) {
        int[] A1 = {1, 4, 2};
        int[] B1 = {1, 2, 4};
        System.out.println(maxUncrossedLines(A1, B1));

        int[] A2 = {2, 5, 1, 2, 5};
        int[] B2 = {10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(A2, B2));

        int[] A3 = {1, 3, 7, 1, 7, 5};
        int[] B3 = {1, 9, 2, 5, 1};
        System.out.println(maxUncrossedLines(A3, B3));
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        /**
         * dp[i][j]表示数组A的最左边i个数和数组B的最左边j个数可以绘制的最大连线数，因此dp[i][0]和
         * dp[0][j]都为0，要求的就是dp[lengthA][lengthB]
         */
        int[][] dp = new int[lengthA + 1][lengthB + 1];
        /**
         * 从数组A的最左边和数组B的最左边一共选取total个数时，数组A至少有countAMin个数，至多有
         * countAMax个数
         */
        for (int total = 2; total <= lengthA + lengthB; total++) {
            int countAMin = Math.max(1, total - lengthB);
            int countAMax = Math.min(lengthA, total - 1);

            for (int countA = countAMin; countA <= countAMax; countA++) {
                int countB = total - countA;
                /**
                 * 当A[i]=B[j]时，可以在dp[i-1][j-1]的基础上将A[i]和B[j]相连，即dp[i][j]=
                 * dp[i-1][j-1]+1；当A[i]!=B[j]时，不可能将A[i]和B[j]都用于连线了，所以从
                 * dp[i][j-1]和dp[i-1][j]中选取较大值
                 */
                dp[countA][countB] = A[countA - 1] == B[countB - 1] ? dp[countA - 1][countB - 1] + 1 :
                        Math.max(dp[countA - 1][countB], dp[countA][countB - 1]);
            }
        }
        return dp[lengthA][lengthB];
    }
}
