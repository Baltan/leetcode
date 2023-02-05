package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 2337. Move Pieces to Obtain a String
 *
 * @author Baltan
 * @date 2023/1/17 16:34
 */
public class CanChange {
    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR"));
        System.out.println(canChange("R_L_", "__LR"));
        System.out.println(canChange("_R", "R_"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/move-pieces-to-obtain-a-string/solutions/1658923/nao-jin-ji-zhuan-wan-pythonjavacgo-by-en-9sqt/"></a>
     *
     * @param start
     * @param target
     * @return
     */
    public static boolean canChange(String start, String target) {
        /**
         * 因为"L"和"R"无法互相穿过对方，所以去掉"_"后的剩余字符的顺序应该是相同的
         */
        if (!Objects.equals(start.replace("_", ""), target.replace("_", ""))) {
            return false;
        }
        int length = start.length();
        int startIndex = 0;
        int targetIndex = 0;
        /**
         * 按序比较字符串start和字符串target的每个非"_"字符的位置
         */
        while (startIndex < length) {
            if (start.charAt(startIndex) == '_') {
                startIndex++;
                continue;
            }
            /**
             * 查找字符串target中下一个非"_"字符的索引
             */
            while (target.charAt(targetIndex) == '_') {
                targetIndex++;
            }
            /**
             * 当前字符为"L"，且这个"L"在字符串start中的索引小于"L"在字符串target中的索引，因为"L"只能向左移动，所以不可能从索引startIndex
             * 移动到索引targetIndex，直接返回false
             */
            boolean condition1 = start.charAt(startIndex) == 'L' && startIndex < targetIndex;
            /**
             * 当前字符为"R"，且这个"R"在字符串start中的索引大于"R"在字符串target中的索引，因为"R"只能向右移动，所以不可能从索引startIndex
             * 移动到索引targetIndex，直接返回false
             */
            boolean condition2 = start.charAt(startIndex) == 'R' && startIndex > targetIndex;

            if (condition1 || condition2) {
                return false;
            }
            startIndex++;
            targetIndex++;
        }
        return true;
    }
}
