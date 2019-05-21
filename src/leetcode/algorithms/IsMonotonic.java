package leetcode.algorithms;

/**
 * Description: 896. Monotonic Array
 *
 * @author Baltan
 * @date 2018/9/3 12:38
 */
public class IsMonotonic {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
        System.out.println(isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(isMonotonic(new int[]{1, 1, 1}));
        System.out.println(isMonotonic(new int[]{2, 1}));
    }

    public static boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length < 3) {
            return true;
        }
        boolean isIncreased = false;
        boolean isDecreased = false;

        for (int i = 0; i < length - 1; i++) {
            if (A[i] < A[i + 1]) {
                isIncreased = true;
            } else if (A[i] > A[i + 1]) {
                isDecreased = true;
            }
            if (isIncreased && isDecreased) {
                return false;
            }
        }
        return true;
    }
}
