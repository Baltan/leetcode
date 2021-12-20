package leetcode.algorithms;

/**
 * Description: 2110. Number of Smooth Descent Periods of a Stock
 *
 * @author Baltan
 * @date 2021/12/20 09:20
 */
public class GetDescentPeriods {
    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println(getDescentPeriods(new int[]{8, 6, 7, 7}));
        System.out.println(getDescentPeriods(new int[]{1}));
    }

    public static long getDescentPeriods(int[] prices) {
        long result = 0L;
        /**
         * 库存连续平顺下降的天数
         */
        long count = 1L;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 1;
            }
        }
        /**
         * 处理最后一段库存连续平顺下降的天数
         */
        result += count * (count + 1) / 2;
        return result;
    }
}
