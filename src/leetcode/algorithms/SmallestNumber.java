package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2165. Smallest Value of the Rearranged Number
 *
 * @author Baltan
 * @date 2022/2/10 09:31
 */
public class SmallestNumber {
    public static void main(String[] args) {
        System.out.println(smallestNumber(95005));
        System.out.println(smallestNumber(63));
        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-7605));
    }

    public static long smallestNumber(long num) {
        if (num == 0) {
            return num;
        }

        if (num > 0) {
            return getMin(num);
        } else {
            return -getMax(-num);
        }
    }

    /**
     * num为一个正数，调整num中每个数字后获得无前导0的最大值
     *
     * @param num
     * @return
     */
    public static long getMax(long num) {
        long result = 0L;
        /**
         * 根据题意，num最长只有15位数字
         */
        List<Long> numList = new ArrayList<>(15);

        while (num > 0) {
            long remainder = num % 10;
            num /= 10;
            numList.add(remainder);
        }

        Collections.sort(numList, Collections.reverseOrder());
        /**
         * 调整num中每个数字后无前导0的最大值为从大到小跟上num中的所有数字
         */
        for (Long value : numList) {
            result = result * 10 + value;
        }
        return result;
    }

    /**
     * num为一个正数，调整num中每个数字后获得无前导0的最小值
     *
     * @param num
     * @return
     */
    public static long getMin(long num) {
        /**
         * num中0的个数
         */
        int zeroCount = 0;
        /**
         * 根据题意，num最长只有15位数字
         */
        List<Long> numList = new ArrayList<>(15);

        while (num > 0) {
            long remainder = num % 10;
            num /= 10;

            if (remainder == 0) {
                zeroCount++;
            } else {
                numList.add(remainder);
            }
        }

        Collections.sort(numList);
        /**
         * 调整num中每个数字后无前导0的最小值最高位为num中的非0最小值，后面先跟上所有0，再后面从小到大跟上num中的剩余数字
         */
        long result = (long) (numList.get(0) * Math.pow(10, zeroCount));

        for (int i = 1; i < numList.size(); i++) {
            result = result * 10 + numList.get(i);
        }
        return result;
    }
}
