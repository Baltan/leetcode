package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2683. Neighboring Bitwise XOR
 *
 * @author Baltan
 * @date 2023/5/16 23:14
 */
public class DoesValidArrayExist {
    public static void main(String[] args) {
        System.out.println(doesValidArrayExist(new int[]{1, 1, 0}));
        System.out.println(doesValidArrayExist(new int[]{1, 1}));
        System.out.println(doesValidArrayExist(new int[]{1, 0}));
    }

    public static boolean doesValidArrayExist(int[] derived) {
        /**
         * derived[0]^derived[1]^derived[2]^……^derived[i]
         * =(original[0]^original[1])^(original[1]^original[2])^(original[2]^original[3])^……^(original[i]^original[0])
         * =(original[0]^original[0])^(original[1]^original[1])^(original[2]^original[2])^……^(original[i]^original[i])
         * =0^0^0^……^0（共i+1个0）
         * =0
         * 所以，如果derived中所有数字按位异或为0，则original[0]不论为0或1都能逆推计算出完整的数组original
         */
        return Arrays.stream(derived).reduce(0, (x, y) -> x ^ y) == 0;
    }
}
