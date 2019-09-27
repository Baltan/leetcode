package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 869. Reordered Power of 2
 *
 * @author Baltan
 * @date 2019-09-27 10:57
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
        System.out.println(reorderedPowerOf2(368407186));
        System.out.println(reorderedPowerOf2(679213508));
        System.out.println(reorderedPowerOf2(850239671));
    }

    public static boolean reorderedPowerOf2(int N) {
        /**
         * 将N的每一位数字按照升序排列保存在数组charArray中
         */
        char[] charArray = String.valueOf(N).toCharArray();
        Arrays.sort(charArray);
        /**
         * 对于整型范围内2的幂，如果幂值的长度和N的长度相等，将幂值的每一位数字按照升序排列保存在数组
         * powerOf2CharArray中，如果charArray和powerOf2CharArray相等，直接返回true
         */
        for (int i = 0; i < 32; i++) {
            String powerOf2String = String.valueOf(1 << i);

            if (powerOf2String.length() == charArray.length) {
                char[] powerOf2CharArray = powerOf2String.toCharArray();
                Arrays.sort(powerOf2CharArray);

                if (Arrays.equals(charArray, powerOf2CharArray)) {
                    return true;
                }
            }
        }
        return false;
    }
}
