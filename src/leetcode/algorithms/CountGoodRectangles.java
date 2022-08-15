package leetcode.algorithms;

/**
 * Description: 1725. Number Of Rectangles That Can Form The Largest Square
 *
 * @author Baltan
 * @date 2022/8/8 09:54
 */
public class CountGoodRectangles {
    public static void main(String[] args) {
        int[][] rectangles1 = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(countGoodRectangles(rectangles1));

        int[][] rectangles2 = {{2, 3}, {3, 7}, {4, 3}, {3, 7}};
        System.out.println(countGoodRectangles(rectangles2));
    }

    public static int countGoodRectangles(int[][] rectangles) {
        int result = 0;
        int maxLen = 0;
        /**
         * 计算可以裁剪得到的最大正方形的边长
         */
        for (int[] rectangle : rectangles) {
            maxLen = Math.max(maxLen, Math.min(rectangle[0], rectangle[1]));
        }

        for (int[] rectangle : rectangles) {
            if (rectangle[0] >= maxLen && rectangle[1] >= maxLen) {
                result++;
            }
        }
        return result;
    }
}
