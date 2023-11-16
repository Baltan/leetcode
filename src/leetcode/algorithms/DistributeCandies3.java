package leetcode.algorithms;

/**
 * Description: 2929. Distribute Candies Among Children II
 *
 * @author Baltan
 * @date 2023/11/15 22:59
 * @see DistributeCandies2
 */
public class DistributeCandies3 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(5, 2));
        System.out.println(distributeCandies(3, 3));
    }

    public static long distributeCandies(int n, int limit) {
        /**
         * 如果三个人都拿最多的糖果limit个，仍有剩余的糖果，则不存在分配方案
         */
        if (3 * limit < n) {
            return 0L;
        }
        long result = 0L;
        /**
         * 第一个人至少需要拿的糖果数
         */
        int firstMin = Math.max(0, n - limit * 2);
        /**
         * 第一个人至多可以拿的糖果数
         */
        int firstMax = Math.min(limit, n);

        for (int i = firstMin; i <= firstMax; i++) {
            /**
             * 第二个人至少需要拿的糖果数
             */
            int secondMin = Math.max(0, n - i - limit);
            /**
             * 第二个人至多可以拿的糖果数
             */
            int secondMax = Math.min(limit, n - i);
            result += secondMax - secondMin + 1;
        }
        return result;
    }
}
