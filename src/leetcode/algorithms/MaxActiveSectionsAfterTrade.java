package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3499. Maximize Active Section with Trade I
 * @author Baltan
 * @date 2025/4/16 22:18
 */
public class MaxActiveSectionsAfterTrade {
    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("101"));
        System.out.println(maxActiveSectionsAfterTrade("10"));
        System.out.println(maxActiveSectionsAfterTrade("0"));
        System.out.println(maxActiveSectionsAfterTrade("1"));
        System.out.println(maxActiveSectionsAfterTrade("01"));
        System.out.println(maxActiveSectionsAfterTrade("0100"));
        System.out.println(maxActiveSectionsAfterTrade("1000100"));
        System.out.println(maxActiveSectionsAfterTrade("01010"));
    }

    public static int maxActiveSectionsAfterTrade(String s) {
        int result = 0;
        /**
         * 假设字符串s两侧加上字符1后得到字符串t。zeros依次保存字符串t中出现的连续0的个数，ones依次保存字符串t中出现的连续1的个数
         */
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        /**
         * 遍历字符串t的过程中，当前字符的前一个字符，因为t[0]为字符1，所以从t[1]，即s[0]开始遍历时，前一个字符为1
         */
        char prev = '1';
        /**
         * 遍历字符串t的过程中，连续0和连续1的个数，因为t[0]为字符1，所以从t[1]，即s[0]开始遍历时，已有连续1的个数为1
         */
        int length = 1;
        /**
         * 字符串s中1的个数
         */
        int oneCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;
                /**
                 * 当不做任何操作时，字符串s中原有1的个数即为答案
                 */
                result++;
            }

            if (c == prev) {
                length++;
            } else {
                if (prev == '1') {
                    /**
                     * 当前字符为0，之前连续1的个数为length
                     */
                    ones.add(length);
                    prev = '0';
                } else {
                    /**
                     * 当前字符为1，之前连续0的个数为length
                     */
                    zeros.add(length);
                    prev = '1';
                }
                length = 1;
            }
        }
        /**
         * 字符串t的最后一个字符为1，如果之前是长度为length的连续1，则最后得到长度为length+1的连续1；否则最后得到长度为length的连续0和长
         * 度为1的连续1
         */
        if (prev == '1') {
            ones.add(length + 1);
        } else {
            zeros.add(length);
            ones.add(1);
        }
        /**
         * 因为现将两个0之间的所有1都变为0，再将两个1之间的所有0都变为1，相当于将三段连续1之间的两段连续0都变为1，即
         * 1  0  1  0  1  =>  1  1  0  1  1  =>  1  1  1  1  1
         * 假设两段连续0的长度为zeros[i-1]和zeros[i]，则三段连续1的长度为ones[i-1]、ones[i]和ones[i+1]，最后新增的1的个数为
         * zeros[i-1]+zeros[i]
         */
        for (int i = 1; i < zeros.size(); i++) {
            if (i + 1 < ones.size()) {
                result = Math.max(result, oneCount + zeros.get(i - 1) + zeros.get(i));
            }
        }
        return result;
    }
}
