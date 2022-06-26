package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1814. Count Nice Pairs in an Array
 *
 * @author Baltan
 * @date 2022/6/23 15:38
 */
public class CountNicePairs {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

    public static int countNicePairs(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 每个数和自己翻转后的值的差值 -> 差值的个数
         */
        Map<Integer, Long> differenceMap = new HashMap<>();
        /**
         * i -> i翻转后的值
         */
        Map<Integer, Integer> revMap = new HashMap<>();

        for (int num : nums) {
            int revNum = revMap.computeIfAbsent(num, i -> rev(num));
            int difference = num - revNum;
            differenceMap.put(difference, differenceMap.getOrDefault(difference, 0L) + 1);
        }
        /**
         * 因为num1+rev(num2)==num2+rev(num1)，所以num1-rev(num1)==num2-rev(num2)，因此差值相同的数字可以两两构成数对
         */
        for (long count : differenceMap.values()) {
            result += count * (count - 1) / 2;
        }
        return (int) (result % mod);
    }

    /**
     * 将num后翻转后的值
     *
     * @param num
     * @return
     */
    public static int rev(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        /**
         * 因为翻转后的值没有前导0，所以将num尾巴上的0先去除
         */
        while (num % 10 == 0) {
            num /= 10;
        }

        while (num > 0) {
            /**
             * num个位上的数字
             */
            int bit = num % 10;
            result = result * 10 + bit;
            num /= 10;
        }
        return result;
    }
}
