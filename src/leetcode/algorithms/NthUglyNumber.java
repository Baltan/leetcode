package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 264. Ugly Number II
 *
 * @author Baltan
 * @date 2019-06-13 10:39
 * @see NthSuperUglyNumber
 */
public class NthUglyNumber {
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
        int value = 1;
        list.add(1);

        while (list.size() < n) {
            /**
             * 沿着丑数序列，将每个丑数乘以2，直到找到不小于value的丑数
             */
            while (list.get(index1) * 2 < value) {
                index1++;
            }
            /**
             * 沿着丑数序列，将每个丑数乘以3，直到找到不小于value的丑数
             */
            while (list.get(index2) * 3 < value) {
                index2++;
            }
            /**
             * 沿着丑数序列，将每个丑数乘以5，直到找到不小于value的丑数
             */
            while (list.get(index3) * 5 < value) {
                index3++;
            }
            /**
             * 将以上三个不小于value的丑数的最小值加入到丑数序列中
             */
            int num = Math.min(list.get(index1) * 2, Math.min(list.get(index2) * 3, list.get(index3) * 5));
            list.add(num);
            /**
             * 将value改为新找到的丑数加1，查找的下一个丑数必然不小于这个值
             */
            value = num + 1;
        }
        return list.get(n - 1);
    }
}
