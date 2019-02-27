package leetcode.algorithms;

/**
 * Description:Image Smoother
 * @author Baltan
 *
 * @date 2017/11/7 16:56
 */
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] m = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        int[][] result = imageSmoother(m);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int num = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < rows && l >= 0 && l < cols) {
                            num++;
                            sum += m[k][l];
                        }
                    }
                }
                result[i][j] = (int) Math.floor(sum / num);
            }
        }
        return result;
    }
}
