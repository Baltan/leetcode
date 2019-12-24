package leetcode.algorithms;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 1296. Divide Array in Sets of K Consecutive Numbers
 *
 * @author Baltan
 * @date 2019-12-24 12:30
 */
public class IsPossibleDivide {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5, 6};
        System.out.println(isPossibleDivide(nums1, 4));

        int[] nums2 = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        System.out.println(isPossibleDivide(nums2, 3));

        int[] nums3 = {3, 3, 2, 2, 1, 1};
        System.out.println(isPossibleDivide(nums3, 3));

        int[] nums4 = {1, 2, 3, 4};
        System.out.println(isPossibleDivide(nums4, 3));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        /**
         * 统计数组中每个数字出现的次数
         */
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /**
         * 每次循环都找到map中剩下的最小的key，判断以这个key开头，能不能形成若干由k个连续数字组成的集
         * 合
         */
        while (!map.isEmpty()) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            Map.Entry<Integer, Integer> firstEntry = it.next();
            /**
             * 当前map中最小的key，一定有一个连续数字的集合以这个key开头
             */
            int num = firstEntry.getKey();
            /**
             * 最小key出现的次数
             */
            int count = firstEntry.getValue();
            /**
             * 逐一检查数组中[key,key+k-1]出现的次数，如果有某个数出现的次数不足count次，则一定无法
             * 划分成一些由k个连续数字组成的集合，返回false；如果某个数出现的次数刚好是count次，将这
             * 个key从map中移除；否则就将这个key出现的次数减掉count次
             */
            for (int i = num; i < num + k; i++) {
                int value = map.getOrDefault(i, 0);

                if (value < count) {
                    return false;
                } else if (value == count) {
                    map.remove(i);
                } else {
                    map.put(i, value - count);
                }
            }
        }
        return true;
    }
}
