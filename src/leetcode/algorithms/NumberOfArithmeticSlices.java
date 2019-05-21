package leetcode.algorithms;

/**
 * Description: 413. Arithmetic Slices
 *
 * @author Baltan
 * @date 2018/1/11 15:52
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 7, 8, 9}));
        System.out.println(numberOfArithmeticSlices(new int[]{1}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2}));
        System.out.println(numberOfArithmeticSlices(new int[]{}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3}));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int sameDifferenceNum = 1;
        int arithmeticNum = 0;
        for (int i = 2; i <= A.length; i++) {
            if (i == A.length || A[i] - A[i - 1] != A[i - 1] - A[i - 2]) {
                if (sameDifferenceNum >= 2) {
                    arithmeticNum += sameDifferenceNum * (sameDifferenceNum - 1) / 2;
                }
                sameDifferenceNum = 1;
            } else if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                sameDifferenceNum++;
            }
        }
        return arithmeticNum;
    }
}
