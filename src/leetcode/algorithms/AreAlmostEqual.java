package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1790. Check if One String Swap Can Make Strings Equal
 *
 * @author Baltan
 * @date 2022/7/9 12:22
 */
public class AreAlmostEqual {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("caa", "aaz"));
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (Objects.equals(s1, s2)) {
            return true;
        }
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        int length = charArray1.length;
        /**
         * s1和s2第一个字符不同的索引位置，没有则为-1
         */
        int index1 = -1;
        /**
         * s1和s2第二个字符不同的索引位置，没有则为-1
         */
        int index2 = -1;

        for (int i = 0; i < length; i++) {
            if (charArray1[i] != charArray2[i]) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2 = i;
                    /**
                     * 如果已找到s1和s2的两处字符不同的索引位置，不再继续向下查找，交换s1这两个索引位置的字符后和s2比较下是否
                     * 一致即可
                     */
                    break;
                }
            }
        }
        /**
         * 说明s1和s2只有一处字符不同的索引位置，不能通过一次交换使两个字符串相同
         */
        if (index2 == -1) {
            return false;
        }
        /**
         * 交换s1在index1和index2两处索引位置的字符
         */
        char temp = charArray1[index1];
        charArray1[index1] = charArray1[index2];
        charArray1[index2] = temp;
        return Objects.equals(new String(charArray1), s2);
    }
}
