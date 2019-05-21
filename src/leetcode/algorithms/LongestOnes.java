package leetcode.algorithms;

/**
 * Description: 1004. Max Consecutive Ones III
 *
 * @author Baltan
 * @date 2019-05-10 10:32
 */
public class LongestOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out
                .println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(
                longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0,
                        1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0}, 5));
        System.out.println(
                longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
    }

    public static int longestOnes(int[] A, int K) {
        int result = 0;
        int lo = 0;
        int hi = 0;
        int length = A.length;
        int numOfZero = 0;

        while (length - lo > result) {
            while (hi < length) {
                if (A[hi] == 0) {
                    numOfZero++;
                }
                hi++;
                if (numOfZero > K) {
                    hi--;
                    break;
                }
            }

            result = Math.max(result, hi - lo);
            lo++;

            if (A[lo - 1] == 0) {
                numOfZero--;
            }

            hi++;
        }
        return result;
    }
}
