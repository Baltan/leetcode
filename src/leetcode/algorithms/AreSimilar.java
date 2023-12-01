package leetcode.algorithms;

/**
 * Description: 2946. Matrix Similarity After Cyclic Shifts
 *
 * @author baltan
 * @date 2023/11/30 09:27
 */
public class AreSimilar {
    public static void main(String[] args) {
        System.out.println(areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2));
        System.out.println(areSimilar(new int[][]{{2, 2}, {2, 2}}, 3));
        System.out.println(areSimilar(new int[][]{{1, 2}}, 1));
        System.out.println(areSimilar(new int[][]{{8, 1, 10, 5, 2, 8}}, 1));
    }

    public static boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        k = k % cols;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (j % 2 == 0) {
                    /**
                     * 索引为偶数的行每个元素和其左侧相隔k个位置的元素比较
                     */
                    if (mat[j][i] != mat[j][(i - k + cols) % cols]) {
                        return false;
                    }
                } else {
                    /**
                     * 索引为奇数的行每个元素和其右侧相隔k个位置的元素比较
                     */
                    if (mat[j][i] != mat[j][(i + k) % cols]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
