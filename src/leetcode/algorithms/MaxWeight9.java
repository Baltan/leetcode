package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3457. Eat Pizzas!
 *
 * @author Baltan
 * @date 2025/2/20 22:45
 */
public class MaxWeight9 {
    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{2, 5, 2, 3}));
        System.out.println(maxWeight(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(maxWeight(new int[]{2, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static long maxWeight(int[] pizzas) {
        long result = 0L;
        int days = pizzas.length / 4;
        /**
         * 奇数天天数
         */
        int oddDays = (days + 1) / 2;
        /**
         * 偶数天天数
         */
        int evenDays = days / 2;
        Arrays.sort(pizzas);
        /**
         * 贪心思想，把所有披萨中最重的oddDays块披萨都放在奇数天吃，evenDays个偶数天中，每天食用剩余披萨中最重的两块和最轻的两块。
         */
        for (int i = pizzas.length - 1; i >= 0 && (oddDays > 0 || evenDays > 0); ) {
            if (oddDays > 0) {
                result += pizzas[i];
                oddDays--;
                i--;
            } else {
                result += pizzas[i - 1];
                evenDays--;
                i -= 2;
            }
        }
        return result;
    }
}
