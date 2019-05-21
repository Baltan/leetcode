package leetcode.algorithms;

/**
 * Description: 962. Maximum Width Ramp
 *
 * @author Baltan
 * @date 2019-04-11 11:16
 */
public class MaxWidthRamp {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    public static int maxWidthRamp(int[] A) {
        int maxWidth = 0;

        for (int i = 0, len = A.length; i < len && i + maxWidth < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (A[j] >= A[i] && j - i > maxWidth) {
                    maxWidth = j - i;
                }
            }
        }
        return maxWidth;
    }
}
