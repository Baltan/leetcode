package leetcode.algorithms;

/**
 * Description: Valid Mountain Array
 *
 * @author Baltan
 * @date 2019-03-16 23:46
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 7}));
    }

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int maxIndex = 0;
        int length = A.length;

        while (maxIndex < length - 1 && A[maxIndex + 1] > A[maxIndex]) {
            maxIndex++;
        }

        if (maxIndex == 0 || maxIndex >= length - 1) {
            return false;
        }

        for (int i = maxIndex + 1; i < length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
