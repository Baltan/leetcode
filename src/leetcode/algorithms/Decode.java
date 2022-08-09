package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1734. Decode XORed Permutation
 *
 * @author Baltan
 * @date 2022/8/3 09:16
 */
public class Decode {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(decode(new int[]{3, 1}));
        OutputUtils.print1DIntegerArray(decode(new int[]{6, 5, 4, 6}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/decode-xored-permutation/solution/gong-shui-san-xie-note-bie-pian-li-yong-zeh6o/"></a>
     *
     * @param encoded
     * @return
     */
    public static int[] decode(int[] encoded) {
        int[] result = new int[encoded.length + 1];
        /**
         * result中所有元素求异或，即1^2^3^……^result.length
         */
        int allXOR = 0;
        /**
         * 从encoded[0]开始，每隔一个元素求异或，即encoded[0]^encoded[2]^encoded[4]^……^encoded[encoded.length-2]
         */
        int separatedXOR = 0;
        /**
         * result[0]^result[1]^result[2]^……^result[result.length-1]
         */
        for (int i = 1; i <= result.length; i++) {
            allXOR ^= i;
        }
        /**
         * encoded[0]^encoded[2]^encoded[4]^……^encoded[encoded.length-2]
         * =(result[0]^result[1])^(result[2]^result[3])^(result[4]^result[5])^……^
         * (result[encoded.length-2]^result[encoded.length-1])
         * =result[0]^result[1]^result[2]^……^result[result.length-2]
         */
        for (int i = 0; i < encoded.length; i += 2) {
            separatedXOR ^= encoded[i];
        }
        /**
         * allXOR^separatedXOR
         * =(result[0]^result[1]^result[2]^……^result[result.length-1])^
         * (result[0]^result[1]^result[2]^……^result[result.length-2])
         * =result[result.length-1]
         */
        result[result.length - 1] = allXOR ^ separatedXOR;

        for (int i = result.length - 2; i >= 0; i--) {
            /**
             * result[i+1]^encoded[i]
             * =result[i+1]^(result[i]^result[i+1])
             * =result[i]
             */
            result[i] = result[i + 1] ^ encoded[i];
        }
        return result;
    }
}
