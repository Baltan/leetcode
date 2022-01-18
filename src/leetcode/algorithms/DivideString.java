package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2138. Divide a String Into Groups of Size k
 *
 * @author Baltan
 * @date 2022/1/18 09:51
 */
public class DivideString {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(divideString("abcdefghi", 3, 'x'));
        OutputUtils.print1DStringArray(divideString("abcdefghij", 3, 'x'));
    }

    public static String[] divideString(String s, int k, char fill) {
        int length = s.length();
        /**
         * 最后需要补充字符fill的个数
         */
        int fillCount = k - length % k;
        /**
         * 如果字符串s刚好可以被分成若干个长度为k的子串，则不用补充字符fill
         */
        fillCount = fillCount == k ? 0 : fillCount;
        StringBuilder builder = new StringBuilder(length + fill);
        builder.append(s);

        for (int i = 0; i < fillCount; i++) {
            builder.append(fill);
        }
        /**
         * 子串的数量
         */
        int groups = builder.length() / k;
        String[] result = new String[groups];
        /**
         * 分割若干个长度为k的子串
         */
        for (int i = 0; i < groups; i++) {
            result[i] = builder.substring(i * k, (i + 1) * k);
        }
        return result;
    }
}
