package leetcode.algorithms;

/**
 * Description: Peak Index in a Mountain Array
 *
 * @author Baltan
 * @date 2018/7/30 14:52
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    public static int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                return i;
            }
        }
        return 0;
    }
}
