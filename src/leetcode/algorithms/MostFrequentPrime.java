package leetcode.algorithms;

/**
 * Description: 3044. Most Frequent Prime
 *
 * @author Baltan
 * @date 2024/2/25 17:38
 */
public class MostFrequentPrime {
    public static void main(String[] args) {
        System.out.println(mostFrequentPrime(new int[][]{{1, 1}, {9, 9}, {1, 1}}));
        System.out.println(mostFrequentPrime(new int[][]{{7}}));
        System.out.println(mostFrequentPrime(new int[][]{{9, 7, 8}, {4, 6, 5}, {2, 8, 6}}));
    }

    public static int mostFrequentPrime(int[][] mat) {
        int result = -1;
        /**
         * 矩阵mat构建的大于10的质数中，出现次数最多的数字的频数
         */
        int maxCount = 1;
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * 矩阵mat构建的数字的最大位数
         */
        int bits = Math.max(rows, cols);
        /**
         * counts[i]表示矩阵mat构建出数字i的次数
         */
        int[] counts = new int[(int) Math.pow(10, bits)];
        /**
         * 可以在8个方向上继续构建数字
         */
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] direction : directions) {
                    /**
                     * 以数字mat[row][col]作为最高位构建数字
                     */
                    int num = mat[row][col];
                    int x = row;
                    int y = col;
                    /**
                     * 继续向数字num的低位追加direction方向上的数字
                     */
                    while (x + direction[0] >= 0 && x + direction[0] < rows && y + direction[1] >= 0 && y + direction[1] < cols) {
                        num = num * 10 + mat[x + direction[0]][y + direction[1]];
                        counts[num]++;
                        x += direction[0];
                        y += direction[1];
                    }
                }
            }
        }
        /**
         * 判断数字i是否是能被矩阵mat构建出的数字，且出现次数最多
         */
        for (int i = 10; i < counts.length; i++) {
            if (counts[i] >= maxCount && isPrime(i)) {
                maxCount = counts[i];
                result = i;
            }
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
