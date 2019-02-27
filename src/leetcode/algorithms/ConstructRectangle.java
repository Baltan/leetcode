package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description:Construct the Rectangle
 *
 * @author Baltan
 * @date 2017/12/31 14:36
 */
public class ConstructRectangle {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(constructRectangle(4));
        OutputUtils.print1DIntegerArray(constructRectangle(6));
        OutputUtils.print1DIntegerArray(constructRectangle(9));
    }

    public static int[] constructRectangle(int area) {
        double l = Math.sqrt(area);
        if (l % 1 == 0.0) {
            return new int[]{(int) l, (int) l};
        } else {
            do {
                l = Math.floor(l) + 1;
            } while (area / l % 1 != 0.0);
        }
        return new int[]{(int) l, (int) (area / l)};
    }
}
