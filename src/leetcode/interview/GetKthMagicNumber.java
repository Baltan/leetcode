package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 面试题 17.09. 第 k 个数
 *
 * @author Baltan
 * @date 2022/2/22 18:16
 * @see leetcode.algorithms.NthUglyNumber
 * @see leetcode.algorithms.NthSuperUglyNumber
 */
public class GetKthMagicNumber {
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(1));
        System.out.println(getKthMagicNumber(2));
        System.out.println(getKthMagicNumber(3));
        System.out.println(getKthMagicNumber(4));
        System.out.println(getKthMagicNumber(5));
        System.out.println(getKthMagicNumber(6));
        System.out.println(getKthMagicNumber(7));
        System.out.println(getKthMagicNumber(8));
        System.out.println(getKthMagicNumber(9));
        System.out.println(getKthMagicNumber(10));
    }

    public static int getKthMagicNumber(int k) {
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int value = 1;
        list.add(1);

        while (list.size() < k) {
            /**
             * 沿着丑数序列，将每个丑数乘以3，直到找到不小于value的丑数
             */
            while (list.get(index1) * 3 < value) {
                index1++;
            }
            /**
             * 沿着丑数序列，将每个丑数乘以5，直到找到不小于value的丑数
             */
            while (list.get(index2) * 5 < value) {
                index2++;
            }
            /**
             * 沿着丑数序列，将每个丑数乘以7，直到找到不小于value的丑数
             */
            while (list.get(index3) * 7 < value) {
                index3++;
            }
            /**
             * 将以上三个不小于value的丑数的最小值加入到丑数序列中
             */
            int num = Math.min(list.get(index1) * 3, Math.min(list.get(index2) * 5, list.get(index3) * 7));
            list.add(num);
            /**
             * 将value改为新找到的丑数加1，查找的下一个丑数必然不小于这个值
             */
            value = num + 1;
        }
        return list.get(k - 1);
    }
}
