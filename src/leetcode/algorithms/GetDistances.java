package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2121. Intervals Between Identical Elements
 *
 * @author Baltan
 * @date 2021/12/30 09:57
 */
public class GetDistances {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(getDistances(new int[]{10, 5, 10, 10})));
    }

    public static long[] getDistances(int[] arr) {
        int length = arr.length;
        long[] result = new long[length];
        /**
         * 数字i -> 数字i在arr中从左向右出现的索引位置的前缀和列表
         */
        Map<Integer, List<Long>> prefixSumMap = new HashMap<>();
        /**
         * 数字i -> 已经遍历到的i的个数
         */
        Map<Integer, Integer> timeMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int value = arr[i];
            /**
             * 数字i在arr中从左向右出现的索引位置的前缀和列表
             */
            List<Long> indexList = prefixSumMap.computeIfAbsent(value, x -> {
                ArrayList<Long> prefixSumList = new ArrayList<>();
                prefixSumList.add(0L);
                return prefixSumList;
            });
            indexList.add(indexList.get(indexList.size() - 1) + i);
        }

        for (int i = 0; i < length; i++) {
            int value = arr[i];
            /**
             * 遍历到arr[i]为止value是第time次出现
             */
            int time = timeMap.getOrDefault(value, 0) + 1;
            timeMap.put(value, time);
            /**
             * 数字value在arr中从左向右出现的索引位置的前缀和列表
             */
            List<Long> prefixSumList = prefixSumMap.get(value);
            /**
             * arr[i]之后value在arr中出现的次数
             */
            int suffixLength = prefixSumList.size() - 1 - time;
            /**
             * arr[i]之前value在arr中出现的次数
             */
            int prefixLength = time - 1;
            /**
             * arr[i]之后value在arr中出现的索引位置和当前这个value的索引位置之差的和，乘法运算中必须乘以1L，否则会向下转型为Integer类型导致精度丢失
             */
            long suffixDiff =
                    prefixSumList.get(prefixSumList.size() - 1) - prefixSumList.get(time) -
                            1L * i * suffixLength;
            /**
             * arr[i]之前value在arr中出现的索引位置和当前这个value的索引位置之差的和，乘法运算中必须乘以1L，否则会向下转型为Integer类型导致精度丢失
             */
            long prefixDiff = 1L * i * prefixLength - prefixSumList.get(prefixLength);
            result[i] = suffixDiff + prefixDiff;
        }
        return result;
    }
}
