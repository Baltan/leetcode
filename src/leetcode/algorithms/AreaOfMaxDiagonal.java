package leetcode.algorithms;

/**
 * Description: 3000. Maximum Area of Longest Diagonal Rectangle
 *
 * @author Baltan
 * @date 2024/1/11 22:27
 */
public class AreaOfMaxDiagonal {
    public static void main(String[] args) {
        System.out.println(areaOfMaxDiagonal(new int[][]{{9, 3}, {8, 6}}));
        System.out.println(areaOfMaxDiagonal(new int[][]{{3, 4}, {4, 3}}));
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;
        /**
         * 最长对角线长度的平方
         */
        int maxDiagonal = 0;

        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];
            /**
             * 当前矩形的对角线长度的平方
             */
            int diagonal = length * length + width * width;
            /**
             * 当前矩形的面积
             */
            int area = length * width;

            if (diagonal > maxDiagonal) {
                result = area;
                maxDiagonal = diagonal;
            } else if (diagonal == maxDiagonal) {
                result = Math.max(result, area);
            }
        }
        return result;
    }
}
