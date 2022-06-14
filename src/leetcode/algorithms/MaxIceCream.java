package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1833. Maximum Ice Cream Bars
 *
 * @author Baltan
 * @date 2022/6/12 14:48
 */
public class MaxIceCream {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        /**
         * 从价格最低的冰淇淋开始购买，购买尽可能多的冰淇淋
         */
        for (int cost : costs) {
            if (cost > coins) {
                break;
            } else {
                result++;
                coins -= cost;
            }
        }
        return result;
    }
}
