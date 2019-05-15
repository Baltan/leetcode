package leetcode.algorithms;

/**
 * Description: Image Overlap
 *
 * @author Baltan
 * @date 2019-05-15 09:01
 */
public class LargestOverlap {
    public static void main(String[] args) {
        int[][] A1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] B1 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        System.out.println(largestOverlap(A1, B1));

        int[][] A2 = {{0, 1}, {1, 1}};
        int[][] B2 = {{1, 1}, {1, 0}};
        System.out.println(largestOverlap(A2, B2));

        int[][] A3 = {{0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 1}};
        int[][] B3 = {{1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}};
        System.out.println(largestOverlap(A3, B3));
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int result = 0;
        int length = A.length;
        /**
         * 将A向右移动i个单位，向下移动j个单位
         * 移动过后，空出来的位置应当用0补全，而不是向右移动后最右边的列放到最左边
         */
        for (int i = -length; i < length; i++) {
            for (int j = -length; j < length; j++) {
                int overlapNum = 0;

                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        if (B[k][l] == 1 && k - i < length && k - i >= 0 && l - j < length && l - j >= 0 &&
                                A[(k - i)][(l - j)] == 1) {
                            overlapNum++;
                        }
                    }
                }
                result = Math.max(result, overlapNum);
            }
        }
        return result;
    }
}
