package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 *
 * @author Baltan
 * @date 2020-06-03 21:40
 */
public class MaxArea1 {
    public static void main(String[] args) {
        int[] horizontalCuts1 = {1, 2, 4};
        int[] verticalCuts1 = {1, 3};
        System.out.println(maxArea(5, 4, horizontalCuts1, verticalCuts1));

        int[] horizontalCuts2 = {3, 1};
        int[] verticalCuts2 = {1};
        System.out.println(maxArea(5, 4, horizontalCuts2, verticalCuts2));

        int[] horizontalCuts3 = {3, 3};
        int[] verticalCuts3 = {1};
        System.out.println(maxArea(5, 4, horizontalCuts3, verticalCuts3));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        /**
         * 垂直方向上的最大宽度，初始化为垂直方向上最上面一段和最下面一段的较大值
         */
        int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        /**
         * 水平方向上的最大宽度，初始化为水平方向上最左边一段和最右边一段的较大值
         */
        int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) (1L * maxHeight * maxWidth % mod);
    }
}
