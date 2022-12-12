package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 2442. Count Number of Distinct Integers After Reverse Operations
 *
 * @author Baltan
 * @date 2022/11/19 11:37
 */
public class CountDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
        System.out.println(countDistinctIntegers(new int[]{2, 2, 2}));
    }

    public static int countDistinctIntegers(int[] nums) {
        /**
         * 最终数组中所有数的集合
         */
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            int reverseNum = reverseNum(num);
            set.add(reverseNum);
        }
        return set.size();
    }

    /**
     * 计算数字num反转每个数位上的数字后得到的值
     *
     * @param num
     * @return
     */
    public static int reverseNum(int num) {
        int result = 0;

        while (num > 0) {
            int remainder = num % 10;
            num /= 10;
            result = result * 10 + remainder;
        }
        return result;
    }
}
