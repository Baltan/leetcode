package leetcode.algorithms;

/**
 * Description: 1886. Determine Whether Matrix Can Be Obtained By Rotation
 *
 * @author Baltan
 * @date 2022/4/28 22:38
 */
public class FindRotation {
    public static void main(String[] args) {
        int[][] mat1 = {{0, 1}, {1, 0}};
        int[][] target1 = {{1, 0}, {0, 1}};
        System.out.println(findRotation(mat1, target1));

        int[][] mat2 = {{0, 1}, {1, 1}};
        int[][] target2 = {{1, 0}, {0, 1}};
        System.out.println(findRotation(mat2, target2));

        int[][] mat3 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target3 = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(findRotation(mat3, target3));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean flag = true;
        /**
         * 判断mat和target是否完全一样
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != mat[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            return true;
        }

        flag = true;
        /**
         * 判断mat旋转90°后是否和target一样，旋转90°后，原来mat的第i行变为第n-i-1列，第j列变为第j行
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != mat[j][n - i - 1]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            return true;
        }

        flag = true;
        /**
         * 判断mat旋转180°后是否和target一样，旋转180°后，原来mat的第i行变为第n-i-1行，第j列变为第n-j-1列
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != mat[n - i - 1][n - j - 1]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            return true;
        }

        flag = true;
        /**
         * 判断mat旋转270°后是否和target一样，旋转270°后，原来mat的第i行变为第i列，第j列变为第n-j-1行
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != mat[n - j - 1][i]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
