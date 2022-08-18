package leetcode.algorithms;

/**
 * Description: 1716. Calculate Money in Leetcode Bank
 *
 * @author Baltan
 * @date 2022/8/14 15:49
 */
public class TotalMoney {
    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
        System.out.println(totalMoney(1000));
    }

    public static int totalMoney(int n) {
        int result = 0;
        /**
         * 第一天为周一存了1元，按照计算规律，假设再前一个周一存了0元
         */
        int lastMonday = 0;

        for (int i = 0; i < n; i++) {
            int remainder = i % 7;

            if (remainder == 0) {
                /**
                 * 如果是周一，比上一个周一多存1元
                 */
                int money = lastMonday + 1;
                lastMonday = money;
                result += money;
            } else {
                /**
                 * 如果不是周一，比本周一晚几天，就比本周一多存几元
                 */
                int money = lastMonday + remainder;
                result += money;
            }
        }
        return result;
    }
}
