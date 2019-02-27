package leetcode.algorithms;

/**
 * Description: Toeplitz Matrix
 *
 * @author Baltan
 * @date 2018/7/31 11:45
 */
public class IsToeplitzMatrix {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(arr1));

        int[][] arr2 = {{1, 2}, {2, 2}};
        System.out.println(isToeplitzMatrix(arr2));

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int[] arr1;
        int[] arr2;

        for (int i = 0; i < matrix.length - 1; i++) {
            arr1 = matrix[i];
            arr2 = matrix[i + 1];
            for (int j = 0; j < arr1.length - 1; j++) {
                if (arr1[j] != arr2[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
