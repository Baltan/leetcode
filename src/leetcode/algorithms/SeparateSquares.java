package leetcode.algorithms;

/**
 * Description: 3453. Separate Squares I
 *
 * @author Baltan
 * @date 2025/2/17 23:28
 */
public class SeparateSquares {
    public static void main(String[] args) {
        System.out.println(separateSquares(new int[][]{{23, 29, 3}, {28, 29, 4}}));
        System.out.println(separateSquares(new int[][]{{0, 0, 1}, {2, 2, 1}}));
        System.out.println(separateSquares(new int[][]{{0, 0, 2}, {1, 1, 1}}));
    }

    public static double separateSquares(int[][] squares) {
        double lo = Integer.MAX_VALUE;
        double hi = Integer.MIN_VALUE;
        long widthSum = 0L;
        long[] areas = new long[squares.length];

        for (int i = 0; i < squares.length; i++) {
            lo = Math.min(lo, squares[i][1]);
            hi = Math.max(hi, squares[i][1] + squares[i][2]);
            widthSum += squares[i][2];
            areas[i] = (long) squares[i][2] * squares[i][2];
        }
        final double threshold = 10e-10 * widthSum;

        while (lo <= hi) {
            double mid = (lo + hi) / 2;
            double aboveArea = 0;
            double belowArea = 0;

            for (int i = 0; i < squares.length; i++) {
                if (squares[i][1] >= mid) {
                    aboveArea += areas[i];
                } else if (squares[i][1] + squares[i][2] <= mid) {
                    belowArea += areas[i];
                } else {
                    aboveArea += areas[i] * (squares[i][1] + squares[i][2] - mid) / squares[i][2];
                    belowArea += areas[i] * (mid - squares[i][1]) / squares[i][2];
                }
            }

            if (aboveArea == belowArea) {
                int max = 0;

                for (int[] square : squares) {
                    int topY = square[1] + square[2];

                    if (square[1] < mid && topY >= mid) {
                        return mid;
                    }

                    if (topY < mid) {
                        max = Math.max(max, topY);
                    }
                }
                return max;
            } else if (Math.abs(aboveArea - belowArea) < threshold) {
                return mid;
            } else if (aboveArea < belowArea) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
