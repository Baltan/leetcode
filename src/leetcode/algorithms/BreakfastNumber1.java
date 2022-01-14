package leetcode.algorithms;

/**
 * Description: LCP 18. 早餐组合
 *
 * @author Baltan
 * @date 2022/1/14 13:53
 * @see BreakfastNumber
 */
public class BreakfastNumber1 {
    public static void main(String[] args) {
        System.out.println(
                breakfastNumber(new int[]{4, 6, 4, 4, 7, 5, 9}, new int[]{9, 5, 2, 4, 1, 4, 1, 9, 6, 3}, 2));
        System.out.println(breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * staplePriceCount[i]表示staple中价格i出现次数
         */
        int[] staplePriceCount = new int[100001];
        /**
         * staple中不超过x的最贵的价格
         */
        int maxPrice = Integer.MIN_VALUE;

        for (int price : staple) {
            if (price < x) {
                staplePriceCount[price]++;
                maxPrice = Math.max(maxPrice, price);
            }
        }
        /**
         * 说明staple中所有价格都不小于x，没有满足条件的主食和饮料的搭配，直接返回0
         */
        if (maxPrice == Integer.MIN_VALUE) {
            return 0;
        }
        /**
         * 数组staplePriceCount的前缀和，prefixSumArray[i]表示staple中价格不超过i的主食的数量
         */
        int[] prefixSumArray = new int[maxPrice + 1];

        for (int price = 1; price <= maxPrice; price++) {
            prefixSumArray[price] = prefixSumArray[price - 1] + staplePriceCount[price];
        }

        for (int price : drinks) {
            if (price < x) {
                /**
                 * 主食价格的上限
                 */
                int otherPrice = Math.min(x - price, maxPrice);
                result += 1L * prefixSumArray[otherPrice];
            }
        }
        return (int) (result % mod);
    }
}
