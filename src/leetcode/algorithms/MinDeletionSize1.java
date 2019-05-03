package leetcode.algorithms;

/**
 * Description: Delete Columns to Make Sorted II
 *
 * @author Baltan
 * @date 2019-05-03 11:09
 */
public class MinDeletionSize1 {
    public static void main(String[] args) {
        String[] A1 = {"ca", "bb", "ac"};
        System.out.println(minDeletionSize(A1));
        String[] A2 = {"xc", "yb", "za"};
        System.out.println(minDeletionSize(A2));
        String[] A3 = {"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize(A3));
        String[] A4 = {"xga", "xfb", "yfa"};
        System.out.println(minDeletionSize(A4));
    }

    public static int minDeletionSize(String[] A) {
        int result = 0;
        int length = A.length;
        int wordLength = A[0].length();
        String[] array = new String[length];

        for (int j = 0; j < wordLength; j++) {
            String[] temp = array.clone();

            for (int i = 0; i < length; i++) {
                temp[i] = temp[i] + A[i].charAt(j);
            }

            if (isSorted(temp)) {
                array = temp;
            } else {
                result++;
            }
        }
        return result;
    }

    public static boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i].compareTo(A[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}