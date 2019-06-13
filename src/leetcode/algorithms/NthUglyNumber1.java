package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 264. Ugly Number II
 *
 * @author Baltan
 * @date 2019-06-13 10:39
 */
public class NthUglyNumber1 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(2));
        System.out.println(nthUglyNumber(4));
        System.out.println(nthUglyNumber(5));
        System.out.println(nthUglyNumber(6));
        System.out.println(nthUglyNumber(7));
        System.out.println(nthUglyNumber(8));
        System.out.println(nthUglyNumber(9));
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(11));
        System.out.println(nthUglyNumber(1689));
    }

    public static int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        list.add(1);

        while (list.size() < n) {
            int i1 = list.get(index1) * 2;
            int i2 = list.get(index2) * 3;
            int i3 = list.get(index3) * 5;
            int min = Math.min(i1, Math.min(i2, i3));
            list.add(min);
            index1 = i1 == min ? index1 + 1 : index1;
            index2 = i2 == min ? index2 + 1 : index2;
            index3 = i3 == min ? index3 + 1 : index3;
        }
        return list.get(n - 1);
    }
}
