package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2961. Double Modular Exponentiation
 *
 * @author Baltan
 * @date 2023/12/11 22:16
 */
public class GetGoodIndices {
    public static void main(String[] args) {
        System.out.println(getGoodIndices(new int[][]{{3, 5, 1, 2}, {3, 2, 5, 2}, {4, 4, 3, 2}, {3, 2, 5, 3}, {1, 5, 1, 4}}, 1));
        System.out.println(getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
        System.out.println(getGoodIndices(new int[][]{{39, 3, 1000, 1000}}, 17));
    }

    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            /**
             * 对于a^b%10的结果，只需要计算得到a^b的个位数字即可，所以只用a的个位数计算
             */
            int a = variables[i][0] % 10;
            int r = a;
            /**
             * times个a相乘的积的个位数仍为a
             */
            int times = 1;

            while ((r = r * a % 10) != a) {
                times++;
            }
            /**
             * 因为每times个a相乘的个位数又为a，所以可以把每times个a相乘看做一个循环，a^b%10等同于a^(b%times)%10。但是当b%times=0时，
             * a^b%10等同于a^times%10
             */
            int b = variables[i][1] % times == 0 ? times : variables[i][1] % times;
            /**
             * base为a^b%10的值
             */
            int base = 1;
            /**
             * 计算出a^b%10的值
             */
            for (int j = 0; j < b; j++) {
                base = base * a % 10;
            }
            int c = variables[i][2];
            int m = variables[i][3];
            int remainder = 1;
            /**
             * base^c%m=[(base%m)*(base%m)*……*(base%m)]%m。其中共c个(base%m)自乘
             */
            for (int j = 0; j < c; j++) {
                remainder = remainder * base % m;
            }

            if (remainder == target) {
                result.add(i);
            }
        }
        return result;
    }
}
