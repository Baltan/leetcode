package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 面试题 17.18. 最短超串
 *
 * @author Baltan
 * @date 2022/1/6 16:25
 * @see leetcode.algorithms.MinWindow
 */
public class ShortestSeq {
    public static void main(String[] args) {
        int[] big1 = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small1 = {1, 5, 9};
        OutputUtils.print1DIntegerArray(shortestSeq(big1, small1));

        int[] big2 = {1, 2, 3};
        int[] small2 = {4};
        OutputUtils.print1DIntegerArray(shortestSeq(big2, small2));
    }

    public static int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length) {
            return new int[0];
        }

        int[] result = new int[2];
        /**
         * 对子数组中每个元素出现的次数计数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(big[0], 1);
        /**
         * 子数组起始索引
         */
        int lo = 0;
        /**
         * 子数组结束索引
         */
        int hi = 0;
        /**
         * 子数组起始索引至多为big.length-small.length，否则该子数组的长度小于数组small的长度，必定不符合条件
         */
        int maxLo = big.length - small.length;
        /**
         * 符合条件的子数组的最小长度
         */
        int subArrayLength = Integer.MAX_VALUE;

        while (lo <= maxLo) {
            /**
             * 如果当前子数组符合条件，则右移lo指针，缩小窗口，判断子数组是否仍旧符合条件
             */
            if (contains(small, countMap)) {
                /**
                 * 如果当前得到的子数组比之前得到的子数组更小，更新最小子数组的起始索引和结束索引
                 */
                if (hi - lo + 1 < subArrayLength) {
                    result[0] = lo;
                    result[1] = hi;
                    subArrayLength = hi - lo + 1;
                }
                int deleteInt = big[lo];
                countMap.put(deleteInt, countMap.get(deleteInt) - 1);
                lo++;
            } else {
                /**
                 * 如果当前子数组不符合条件，则右移hi指针，扩大窗口
                 */
                hi++;
                /**
                 * 当hi指针仍在字符串s范围内时，可以继续判断子数组是否符合条件，否则可以结束判断
                 */
                if (hi < big.length) {
                    int addInt = big[hi];
                    countMap.put(addInt, countMap.getOrDefault(addInt, 0) + 1);
                } else {
                    break;
                }
            }
        }
        /**
         * 判断是否存在符合条件的子数组
         */
        if (subArrayLength == Integer.MAX_VALUE) {
            return new int[0];
        } else {
            return result;
        }
    }

    /**
     * 判断countMap中是否包含small中所有元素
     *
     * @param small
     * @param countMap
     * @return
     */
    public static boolean contains(int[] small, Map<Integer, Integer> countMap) {
        for (int num : small) {
            if (countMap.getOrDefault(num, 0) == 0) {
                return false;
            }
        }
        return true;
    }
}
