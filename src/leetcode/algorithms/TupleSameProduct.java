package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1726. Tuple with Same Product
 *
 * @author Baltan
 * @date 2022/8/7 13:43
 */
public class TupleSameProduct {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6}));
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
    }

    public static int tupleSameProduct(int[] nums) {
        int result = 0;
        /**
         * 正整数对的乘积i -> 乘积为i的正整数对的数量
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        int length = nums.length;
        /**
         * 统计所有可能的正整数对的乘积
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int product = nums[i] * nums[j];
                countMap.put(product, countMap.getOrDefault(product, 0) + 1);
            }
        }

        for (int count : countMap.values()) {
            /**
             * 当乘积相同正整数对为count对时，则共有count*(count-1)/2种配对方式，此外两个正整数对可以交换位置，每个正整数对内
             * 部的两个数也可以交换位置，共可以产生count*(count-1)/2*2*2*2种元组(a,b,c,d)
             */
            result += count * (count - 1) * 2 * 2;
        }
        return result;
    }
}
