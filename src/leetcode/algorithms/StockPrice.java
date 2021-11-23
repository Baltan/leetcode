package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 2034. Stock Price Fluctuation
 *
 * @author Baltan
 * @date 2021/11/23 22:50
 */
public class StockPrice {
    public static void main(String[] args) {
        StockPrice stockPrice1 = new StockPrice();
        stockPrice1.update(1, 10);
        stockPrice1.update(2, 5);
        System.out.println(stockPrice1.current());
        System.out.println(stockPrice1.maximum());
        stockPrice1.update(1, 3);
        System.out.println(stockPrice1.maximum());
        stockPrice1.update(4, 2);
        System.out.println(stockPrice1.minimum());
    }

    /**
     * 时间戳 -> 价格
     */
    private Map<Integer, Integer> timestampMap;
    /**
     * 价格 -> 出现天数
     */
    private TreeMap<Integer, Integer> priceMap;
    /**
     * 最大时间戳
     */
    private int maxTimestamp;

    public StockPrice() {
        timestampMap = new HashMap<>();
        priceMap = new TreeMap<>();
        maxTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (timestampMap.containsKey(timestamp)) {
            int oldPrice = timestampMap.get(timestamp);
            timestampMap.put(timestamp, price);
            /**
             * 如果新价格和旧价格一样，不需要任何操作
             */
            if (price == oldPrice) {
                return;
            }
            /**
             * 更新新价格的出现天数
             */
            priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
            int oldPriceDays = priceMap.get(oldPrice);
            /**
             * 更新旧价格的出现天数
             */
            if (oldPriceDays == 1) {
                priceMap.remove(oldPrice);
            } else {
                priceMap.put(oldPrice, oldPriceDays - 1);
            }
        } else {
            timestampMap.put(timestamp, price);
            /**
             * 更新新价格的出现天数
             */
            priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
            maxTimestamp = Math.max(maxTimestamp, timestamp);
        }
    }

    public int current() {
        return timestampMap.get(maxTimestamp);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}
