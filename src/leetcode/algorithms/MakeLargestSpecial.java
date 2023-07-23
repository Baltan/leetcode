package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 761. Special Binary String
 *
 * @author Baltan
 * @date 2023/4/13 16:36
 */
public class MakeLargestSpecial {
    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/special-binary-string/solutions/1730861/te-shu-de-er-jin-zhi-xu-lie-by-capital-w-81ht/"></a>
     *
     * @param s
     * @return
     */
    public static String makeLargestSpecial(String s) {
        /**
         * 如果字符串s的长度不大于2，则s可能为""或"10"，无法对s进行交换操作，直接返回
         */
        if (s.length() <= 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        /**
         * 字符串s中可以进行交换操作的所有特殊子串
         */
        List<String> substrings = new ArrayList<>();
        /**
         * 字符串s中，如果将"1"看做"("，将"0"看做")"，则字符串s就是个有效括号字符串。遍历字符串s。每当遇到"1"，将count加1，遇到"0"，将
         * count减1
         */
        int count = 0;
        /**
         * 一个特殊子串的起始索引
         */
        int start = 0;

        for (int i = 0; i < charArray.length; i++) {
            count += charArray[i] == '1' ? 1 : -1;
            /**
             * 当count等于0时，此时就得到了一个特殊字串s.substring(start,i+1)
             */
            if (count == 0) {
                /**
                 * 当前特殊子串substring是一个无法再拆分成多个连续特殊字串的字符串，对于这样的字符串，首位的"1"和末尾的"0"一定是相互配对的，
                 * 不会出现在进行交换的特殊字串中（否则substring就不是一个无法再拆分成多个连续特殊字串的字符串）。对当前得到的特殊字串掐头去
                 * 尾后的中间部分子串进行递归操作得到当前特殊子串substring交换操作后的最大字典顺序子串
                 */
                String substring = "1" + makeLargestSpecial(s.substring(start + 1, i)) + "0";
                substrings.add(substring);
                /**
                 * 下一个特殊子串的起始索引
                 */
                start = i + 1;
            }
        }
        /**
         * 将所有特殊字串按照字典顺序倒序排列
         */
        Collections.sort(substrings, Collections.reverseOrder());
        return String.join("", substrings);
    }
}
