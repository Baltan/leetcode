package leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 面试题 08.06. 汉诺塔问题
 *
 * @author Baltan
 * @date 2020-03-15 22:46
 */
public class Hanota {
    public static void main(String[] args) {
        List<Integer> A1 = new ArrayList<>(Arrays.asList(2, 1, 0));
        List<Integer> B1 = new ArrayList<>(Arrays.asList());
        List<Integer> C1 = new ArrayList<>(Arrays.asList());
        hanota(A1, B1, C1);
        System.out.println(C1);

        List<Integer> A2 = new ArrayList<>(Arrays.asList(1, 0));
        List<Integer> B2 = new ArrayList<>(Arrays.asList());
        List<Integer> C2 = new ArrayList<>(Arrays.asList());
        hanota(A2, B2, C2);
        System.out.println(C2);
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        transfer(A.size(), A, B, C);
    }

    /**
     * 将A柱最上面n个圆盘移动到C柱，并且保持盘子的从上到下变大
     *
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void transfer(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            int value = A.remove(A.size() - 1);
            C.add(value);
        } else {
            /**
             * 现将A柱最上面的n-1个圆盘移动到B柱
             */
            transfer(n - 1, A, C, B);
            /**
             * 将A柱最下面最大的圆盘移动到C柱
             */
            int value = A.remove(A.size() - 1);
            C.add(value);
            /**
             * 将B柱上所有n-1个圆盘移动到C柱
             */
            transfer(n - 1, B, A, C);
        }
    }
}
