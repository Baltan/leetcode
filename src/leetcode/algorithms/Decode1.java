package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1720. Decode XORed Array
 *
 * @author Baltan
 * @date 2022/8/10 09:06
 */
public class Decode1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(decode(new int[]{1, 2, 3}, 1));
        OutputUtils.print1DIntegerArray(decode(new int[]{6, 2, 7, 3}, 4));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            /**
             * result[i]^encoded[i]
             * =result[i]^(result[i]^result[i+1])
             * =result[i+1]
             */
            result[i + 1] = result[i] ^ encoded[i];
        }
        return result;
    }
}
