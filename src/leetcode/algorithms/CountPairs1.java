package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1711. Count Good Meals
 *
 * @author Baltan
 * @date 2022/8/16 09:31
 */
public class CountPairs1 {
    public static void main(String[] args) {
        System.out.println(countPairs(
                new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246,
                        1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628,
                        1468}));
        System.out.println(countPairs(
                new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22,
                        234}));
        System.out.println(countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    public static int countPairs(int[] deliciousness) {
        /**
         * 如果只有一种餐品，不能做成一顿大餐
         */
        if (deliciousness.length == 1) {
            return 0;
        }
        long result = 0L;
        int mod = 1000000007;
        /**
         * 餐品美味程度 -> 餐品的数量
         */
        Map<Integer, Integer> deliciousnessMap = new HashMap<>();
        deliciousnessMap.put(deliciousness[0], 1);

        for (int i = 1; i < deliciousness.length; i++) {
            int currDeliciousness = deliciousness[i];
            /**
             * 根据题意，餐品美味程度∈[0,2^20]，所以大餐的美味程度最大可能为2^21，最小可能为1
             */
            int totalDeliciousness = 1 << 21;
            /**
             * 循环判断是否可以做成美味程度为2^21、2^20、2^19……的大餐
             */
            while (totalDeliciousness > 0 && totalDeliciousness >= currDeliciousness) {
                int otherDeliciousness = totalDeliciousness - currDeliciousness;

                if (deliciousnessMap.containsKey(otherDeliciousness)) {
                    result = (result + deliciousnessMap.get(otherDeliciousness)) % mod;
                }
                totalDeliciousness >>= 1;
            }
            deliciousnessMap.put(currDeliciousness, deliciousnessMap.getOrDefault(currDeliciousness, 0) + 1);
        }
        return (int) result;
    }
}
