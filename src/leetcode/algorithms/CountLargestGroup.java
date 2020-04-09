package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1399. Count Largest Group
 *
 * @author Baltan
 * @date 2020-04-09 09:11
 */
public class CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
        System.out.println(countLargestGroup(15));
        System.out.println(countLargestGroup(24));
    }

    public static int countLargestGroup(int n) {
        int result = 0;
        /**
         * 数字数目最多的组中数字的个数
         */
        int maxSize = 0;
        /**
         * 数字每位数字之和 -> [1,n]中按位求和值为key的数字的个数
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = bitsSum(i);
            int size = map.getOrDefault(sum, 0) + 1;
            map.put(sum, size);
            maxSize = Math.max(maxSize, size);
        }

        for (int size : map.values()) {
            if (size == maxSize) {
                result++;
            }
        }
        return result;
    }

    /**
     * 计算num每位数字的和
     *
     * @param num
     * @return
     */
    public static int bitsSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
