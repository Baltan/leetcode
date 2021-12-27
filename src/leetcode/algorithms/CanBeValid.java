package leetcode.algorithms;

/**
 * Description: 2116. Check if a Parentheses String Can Be Valid
 *
 * @author Baltan
 * @date 2021/12/27 09:18
 */
public class CanBeValid {
    public static void main(String[] args) {
        System.out.println(canBeValid("())()))()(()(((())(()()))))((((()())(())",
                "1011101100010001001011000000110010100101"));
        System.out.println(canBeValid(
                "(()))()))(()((()()(((()))()()()()()())))()()(()())()(()((()()((()((((((()(()()(()()())((((" +
                        "(())((()))))()(((((((()()())()))())((((((()(())())()((())()()((())((((())(((())(()" +
                        ")()()))(((()()())())))((()))))()()()((()))())(())(((()()((())(())(())())()((()))()" +
                        ")(())()(()())((((()(((())((()()())(((()(((((()))()))))))(()((())())(())))))(())(((" +
                        "())()()(()))())())))(((())))()()))()())))))())()(()()))(())(()())))())()))((((())(" +
                        "()))()(((())())(()(()))()))((()(())()()))))())(()(((((()",
                "110001111001011100000100011110101000100110010010011001110010111111100111000100000000101111101001111111011101001110011001001100100001100000000010100010101101100000100001000110111000111110110010111011010010100011111101110011100010010001111001010001001000111101101111111011001000100111100110101000100011011001001100110011111111111100101000100111111100000100101101000101111101000011110001001011111010011010000100100000000011101011001110000110011000100001110101100101111111110100"));
        System.out.println(canBeValid(")", "0"));
        System.out.println(canBeValid("))()))", "010100"));
        System.out.println(canBeValid("()()", "0000"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/check-if-a-parentheses-string-can-be-valid/solution/qian-hou-ge-bian-li-yi-ci-fen-bie-pan-du-w5nu/"></a>
     *
     * @param s
     * @param locked
     * @return
     */
    public static boolean canBeValid(String s, String locked) {
        int length = s.length();
        /**
         * 从右向左遍历字符串s，不可改变的"("的个数
         */
        int leftCount = 0;
        /**
         * 从左向右遍历字符串s，不可改变的")"的个数
         */
        int rightCount = 0;
        /**
         * 如果字符串s的长度为奇数，则肯定不是有效字符串
         */
        if (length % 2 == 1) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
                rightCount++;
                /**
                 * 从左向右遍历到s[i]为止，最多有i+1-rightCount个"("，如果"("的个数小于")"，则一定不是有效字符串
                 */
                if (i + 1 - rightCount < rightCount) {
                    return false;
                }
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                leftCount++;
                /**
                 * 从右向左遍历到s[i]为止，最多有length-i-leftCount个")"，如果")"的个数小于"("，则一定不是有效字符串
                 */
                if (length - i - leftCount < leftCount) {
                    return false;
                }
            }
        }
        return true;
    }
}
