package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 901. Online Stock Span
 *
 * @author Baltan
 * @date 2019-08-14 10:55
 */
public class StockSpanner {
    /**
     * 记录每一天的股票价格
     */
    private List<Integer> priceList;
    /**
     * 记录每一天股票价格小于或等于当天价格的最大连续天数区间
     */
    private List<int[]> intervalList;

    public StockSpanner() {
        priceList = new ArrayList<>();
        intervalList = new ArrayList<>();
    }

    public int next(int price) {
        if (priceList.isEmpty()) {
            priceList.add(price);
            intervalList.add(new int[]{0, 0});
        } else {
            /**
             * 将当天的股票价格加入priceList
             */
            priceList.add(price);
            int days = priceList.size();
            /**
             * 假设当天的最大连续天数区间为第0天开始，到当天结束
             */
            intervalList.add(new int[]{0, days - 1});
            /**
             * 从倒数第二天向前一次判断每一个天数区间中的价格是否都低于最后一天
             */
            for (int i = days - 2; i >= 0; i--) {
                /**
                 * 第i天的最大连续天数区间
                 */
                int[] interval = intervalList.get(i);
                int startDay = interval[0];
                int endDay = interval[1];
                /**
                 * 如果第i天的最大连续天数区间的最后一天endDay的股票价格也小于或等于最后一天的股票价格，
                 * 那么第i天的最大连续天数区间的第一天startDay的股票价格一定也不大于最后一天的股票价格，
                 * 可以令i=startDay，从而下一轮循环从第(startDay-1)天开始比较那天的股票价格；
                 *
                 * 如果第i天的最大连续天数区间的最后一天endDay的股票价格大于最后一天的股票价格，那么由于
                 * 前一轮循环已经判断过第(i+1)天的最大连续天数区间的每一天的股票价格都小于或等于最后一天
                 * 的股票价格，所以最后一天的最大连续天数区间是从第(i+1)天的最大连续天数区间的第一天，即
                 * 第i天的最大连续天数区间的最后一天的下一天开始的。
                 */
                if (priceList.get(endDay) <= price) {
                    i = startDay;
                } else {
                    intervalList.get(days - 1)[0] = endDay + 1;
                    break;
                }
            }
        }
        /**
         * 最后一天的最大连续天数区间
         */
        int[] interval = intervalList.get(intervalList.size() - 1);
        return interval[1] - interval[0] + 1;
    }

    public static void main(String[] args) {
        StockSpanner s1 = new StockSpanner();
        System.out.println(s1.next(100));
        System.out.println(s1.next(80));
        System.out.println(s1.next(60));
        System.out.println(s1.next(70));
        System.out.println(s1.next(60));
        System.out.println(s1.next(75));
        System.out.println(s1.next(85));

        System.out.println("------------");

        StockSpanner s2 = new StockSpanner();
        System.out.println(s2.next(10));
        System.out.println(s2.next(20));
        System.out.println(s2.next(30));
        System.out.println(s2.next(40));
        System.out.println(s2.next(50));
        System.out.println(s2.next(60));
        System.out.println(s2.next(70));
        System.out.println(s2.next(80));
        System.out.println(s2.next(90));

        System.out.println("------------");

        StockSpanner s3 = new StockSpanner();
        System.out.println(s3.next(90));
        System.out.println(s3.next(80));
        System.out.println(s3.next(70));
        System.out.println(s3.next(60));
        System.out.println(s3.next(50));
        System.out.println(s3.next(40));
        System.out.println(s3.next(30));
        System.out.println(s3.next(20));
        System.out.println(s3.next(10));
    }
}
