package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1352. Product of the Last K Numbers
 *
 * @author Baltan
 * @date 2020-03-13 12:23
 */
public class ProductOfNumbers {
    /**
     * 保存最后一次添加的0后面一个索引位置开始，到当前所有数字的乘积
     */
    private List<Integer> products;
    /**
     * 最后一次添加的0的索引位置
     */
    private int zeroIndex;

    public ProductOfNumbers() {
        this.products = new ArrayList<>();
        this.zeroIndex = -1;
    }

    public void add(int num) {
        /**
         * 如果products中还没有添加过数字或者数字列表中前一次添加的数字为0，则将当前值加入products，否则就将
         * 当前值乘以products中最后一次得到的乘积后加入products。例如，在数字列表中一次加入3、0、2、5、4，可
         * 以得到products=[3,0,2,10,40]
         */
        if (products.isEmpty() || products.get(products.size() - 1) == 0) {
            products.add(num);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
        /**
         * 更新最后一次添加的0的索引位置
         */
        if (num == 0) {
            zeroIndex = products.size() - 1;
        }
    }

    public int getProduct(int k) {
        int size = products.size();
        /**
         * 如果最后加入数字列表的k个数中含有0，直接返回乘积为0
         */
        if (zeroIndex != -1 && size - k <= zeroIndex) {
            return 0;
        }
        /**
         * 如果products中只有k个数或在数字列表中最后一次加入0后只加入过k个数，则当前products中的最后一个乘积
         * 就是这k个数的乘积，否则将前缀部分的乘积除去即可
         */
        return products.size() == k || products.get(size - 1 - k) == 0 ? products.get(size - 1) :
                products.get(size - 1) / products.get(size - 1 - k);
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers1 = new ProductOfNumbers();
        productOfNumbers1.add(3);
        productOfNumbers1.add(0);
        productOfNumbers1.add(2);
        productOfNumbers1.add(5);
        productOfNumbers1.add(4);
        System.out.println(productOfNumbers1.getProduct(2));
        System.out.println(productOfNumbers1.getProduct(3));
        System.out.println(productOfNumbers1.getProduct(4));
        productOfNumbers1.add(8);
        System.out.println(productOfNumbers1.getProduct(2));

        System.out.println("-------------------");

        ProductOfNumbers productOfNumbers2 = new ProductOfNumbers();
        productOfNumbers2.add(1);
        System.out.println(productOfNumbers2.getProduct(1));
        System.out.println(productOfNumbers2.getProduct(1));
        System.out.println(productOfNumbers2.getProduct(1));
        productOfNumbers2.add(7);
        productOfNumbers2.add(6);
        productOfNumbers2.add(7);
    }
}
