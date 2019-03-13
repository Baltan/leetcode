package leetcode.algorithms;

/**
 * Description: Delete Columns to Make Sorted
 *
 * @author Baltan
 * @date 2019-03-13 10:04
 */
public class MinDeletionSize {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    public static int minDeletionSize(String[] A) {
        int arrLength = A.length;
        int strLength = A[0].length();
        int result = 0;

        for (int i = 0; i < strLength; i++) {
            for (int j = 1; j < arrLength; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
