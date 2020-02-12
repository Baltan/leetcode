package leetcode.algorithms;

/**
 * Description: 678. Valid Parenthesis String
 *
 * @author Baltan
 * @date 2020-02-12 16:21
 */
public class CheckValidString {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("((*"));
        System.out.println(checkValidString("((*))"));
        System.out.println(checkValidString("((*)**))"));
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(checkValidString("((**))((())"));
    }

    /**
     * 因为"*"既可以当做"("，也可以当做")"，为了确定某个"*"应该被当做"("还是")"，应该从左向右和
     * 从右向左两次扫描字符串s来确定
     *
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        /**
         * "("的个数
         */
        int leftBracketCount = 0;
        /**
         * "*"的个数
         */
        int starCount = 0;
        int length = s.length();
        /**
         * 从左向右扫描检查字符串是否有效，此时只把"*"当做""或")"
         *
         * 对于"((**))((())"这样的字符串，其实从左向右扫描应该是无效的，但是后半部分"((())"为了
         * 匹配"("，"借用"了前半部分多余的"*"，导致误判字符串有效。这种字符串在从右向左扫描的时候，
         * 因为先扫描"((())"，此时就会出现多余的"("，就会判定字符串是无效的
         */
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftBracketCount++;
            } else if (c == '*') {
                starCount++;
            } else {
                /**
                 * 因为"*"可以当做""，也可以当做")"，所以优先用")"匹配"("，没有")"的情况下用"*"
                 * 匹配"("，如果都没有，则字符串无效
                 */
                if (leftBracketCount > 0) {
                    leftBracketCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            }
        }
        /**
         * ")"的个数
         */
        int rightBracketCount = 0;
        /**
         * "*"的个数
         */
        starCount = 0;
        /**
         * 从右向左扫描检查字符串是否有效，此时只把"*"当做""或"("
         */
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            /**
             * 因为"*"可以当做""，也可以当做"("，所以优先用"("匹配")"，没有"("的情况下用"*"
             * 匹配")"，如果都没有，则字符串无效
             */
            if (c == ')') {
                rightBracketCount++;
            } else if (c == '*') {
                starCount++;
            } else {
                if (rightBracketCount > 0) {
                    rightBracketCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
