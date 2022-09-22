package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1652. Defuse the Bomb
 *
 * @author Baltan
 * @date 2022/9/14 10:03
 */
public class Decrypt {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(decrypt(new int[]{5, 7, 1, 4}, 3));
        OutputUtils.print1DIntegerArray(decrypt(new int[]{1, 2, 3, 4}, 0));
        OutputUtils.print1DIntegerArray(decrypt(new int[]{2, 4, 9, 3}, -2));
    }

    public static int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];

        if (k > 0) {
            /**
             * 长度为k的窗口中所有元素的和
             */
            int sum = 0;
            /**
             * 计算code[0]替换之后的值，即code[1]+code[2]+……+code[k]
             */
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            result[0] = sum;
            /**
             * 计算code[1]到code[length-1]替换之后的值，每次循环将窗口向右移动一个位置
             */
            for (int i = 1; i < length; i++) {
                sum -= code[i];
                sum += code[(i + k) % length];
                result[i] = sum;
            }
        } else if (k < 0) {
            /**
             * 长度为k的窗口中所有元素的和
             */
            int sum = 0;
            /**
             * 计算code[length-1]替换之后的值，即code[length-2]+code[length-3]+……+code[length-1+k]
             */
            for (int i = length - 2; i >= length - 1 + k; i--) {
                sum += code[i];
            }
            result[length - 1] = sum;
            /**
             * 计算code[0]到code[length-2]替换之后的值，每次循环将窗口向左移动一个位置
             */
            for (int i = length - 2; i >= 0; i--) {
                sum -= code[i];
                sum += code[(i + k + length) % length];
                result[i] = sum;
            }
        }
        return result;
    }
}
