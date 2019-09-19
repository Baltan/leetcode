package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1147. Longest Chunked Palindrome Decomposition
 *
 * @author Baltan
 * @date 2019-09-19 08:55
 */
public class LongestDecomposition {
    public static void main(String[] args) {
        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(longestDecomposition("merchant"));
        System.out.println(longestDecomposition("antaprezatepzapreanta"));
        System.out.println(longestDecomposition("aaa"));
        System.out.println(longestDecomposition("f"));
        System.out.println(longestDecomposition("bb"));
        System.out.println(longestDecomposition("volvo"));
    }

    public static int longestDecomposition(String text) {
        int result = 0;
        /**
         * 维护四个指针，i1指向头段字符串的第一个字符的位置，i2指向头段字符串的最后一个字符的位置，
         * i3指向尾段字符串的第一个字符的位置，i4指向尾段字符串的最后一个字符的位置，例如：
         *
         * ghiabcdefhelloadamhelloabcdefghi
         * |                              |
         * i1                             i3
         * i2                             i4
         */
        int i1 = 0;
        int i2 = 0;
        int i3 = text.length() - 1;
        int i4 = text.length() - 1;
        /**
         * 逐步同步移动头段和尾段的指针：
         * 如果i1>i3（同时一定存在i2>i4），即情况如下，可以退出循环
         *         i1——————i2
         *      i3——————i4
         * 如果i1=i3（同时一定存在i2=i4），即情况如下，这是最中间的段，将结果加1后可以退出循环
         *        i1——————i2
         *        i3——————i4
         * 如果当前头段和尾段一样，将结果加2后，调整头段和尾段的指针位置，将头段指针i1和i2都置位
         * 到原来i2指针位置的后一个位置，将尾段指针i3和i4都置位到原来i3指针位置的前一个位置，继
         * 续下一轮循环判定头段和尾段是否一样
         * 如果当前头段和尾段不一样，将头段i2指针向后移动一个位置，将尾段i3指针向前移动一个位置，
         * 继续下一轮循环判定头段和尾段是否一样
         */
        while (true) {
            if (i1 > i3) {
                break;
            } else if (i1 == i3 && i2 == i4) {
                result++;
                break;
            } else if (Objects.equals(text.substring(i1, i2 + 1), text.substring(i3, i4 + 1))) {
                result += 2;
                i2 = i2 + 1;
                i1 = i2;
                i3 = i3 - 1;
                i4 = i3;
            } else {
                i2++;
                i3--;
            }
        }
        return result;
    }
}
