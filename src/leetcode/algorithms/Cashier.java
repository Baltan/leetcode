package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1357. Apply Discount Every n Orders
 *
 * @author Baltan
 * @date 2020-02-23 14:41
 */
public class Cashier {
    /**
     * 每隔interval个人会获得打折
     */
    private int interval;
    /**
     * 当前已经消费的总人数
     */
    private int number;
    /**
     * 打折的人需要支付的金额占总价的比例
     */
    private double proportion;
    /**
     * 商品编号及其价格的映射
     */
    private Map<Integer, Integer> map = new HashMap<>();

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.interval = n;
        this.number = 0;
        this.proportion = 1 - 0.01 * discount;

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        number++;
        int totalPrice = 0;

        for (int i = 0; i < product.length; i++) {
            totalPrice += map.get(product[i]) * amount[i];
        }
        return number % interval == 0 ? totalPrice * proportion : totalPrice;
    }

    public static void main(String[] args) {
        int[] products1 = {1, 2, 3, 4, 5, 6, 7};
        int[] prices1 = {100, 200, 300, 400, 300, 200, 100};
        Cashier cashier1 = new Cashier(3, 50, products1, prices1);
        System.out.println(cashier1.getBill(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(cashier1.getBill(new int[]{3, 7}, new int[]{10, 10}));
        System.out.println(cashier1.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(cashier1.getBill(new int[]{4}, new int[]{10}));
        System.out.println(cashier1.getBill(new int[]{7, 3}, new int[]{10, 10}));
        System.out
                .println(cashier1.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}));
        System.out.println(cashier1.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2}));
    }
}
