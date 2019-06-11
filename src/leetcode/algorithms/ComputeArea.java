package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 223. Rectangle Area
 *
 * @author Baltan
 * @date 2019-06-11 17:16
 */
public class ComputeArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(computeArea(-5, -3, 0, 0, -3, -3, 3, 3));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int areaSum = area1 + area2;

        if (F >= D || G <= A || H <= B || E >= C) {
            return areaSum;
        }

        if (A > E && B > F && C < G && D < H) {
            return area2;
        }

        if (E > A && F > B && G < C && H < D) {
            return area1;
        }

        List<Integer> xList = Arrays.asList(A, C, E, G);
        List<Integer> yList = Arrays.asList(B, D, F, H);
        Collections.sort(xList);
        Collections.sort(yList);
        return areaSum - (xList.get(2) - xList.get(1)) * (yList.get(2) - yList.get(1));
    }
}
