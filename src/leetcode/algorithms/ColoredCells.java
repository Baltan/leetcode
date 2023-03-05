package leetcode.algorithms;

/**
 * Description: 2579. Count Total Number of Colored Cells
 *
 * @author Baltan
 * @date 2023/3/5 10:29
 */
public class ColoredCells {
    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
        System.out.println(coloredCells(100000));
    }

    public static long coloredCells(int n) {
        /**
         * 1+4+8+12+……+4(n-1)
         * =1+4(1+2+3+……+(n-1))
         * =1+4n(n-1)/2
         * =1+2n(n-1)
         */
        return 2L * n * (n - 1) + 1;
    }
}
