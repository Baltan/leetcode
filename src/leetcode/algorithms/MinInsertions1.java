package leetcode.algorithms;

/**
 * Description: 1541. Minimum Insertions to Balance a Parentheses String
 *
 * @author Baltan
 * @date 2020-08-16 22:40
 * @see MinAddToMakeValid
 */
public class MinInsertions1 {
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("())"));
        System.out.println(minInsertions("))())("));
        System.out.println(minInsertions("(((((("));
        System.out.println(minInsertions(")))))))"));
    }

    public static int minInsertions(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 当前还未匹配的"("的个数
         */
        int leftCount = 0;
        /**
         * 当前还未匹配的")"的个数
         */
        int rightCount = 0;

        for (int i = 0; i < length; ) {
            char c = charArray[i];

            if (c == '(') {
                /**
                 * 如果当前还有未匹配的")"，则先要把")"都匹配完才能继续添加"("。如果此时未匹配的")"个数为奇数个，
                 * 因为")"和"("的个数为2:1，所以需要先增加一个")"，需要匹配的"("的个数为(rightCount+1)/2
                 */
                if (rightCount > 0) {
                    result += (rightCount + 1) / 2;
                    result += rightCount % 2 == 0 ? 0 : 1;
                }
                leftCount++;
                i++;
            } else {
                /**
                 * 如果存在连续两个")"，并且此时存在未匹配的"("，则可以用这两个")"匹配一个"("，否则需要增加一个
                 * "("来匹配这两个")"。如果不存在连续两个")"，并且此时存在未匹配的"("，则需要增加一个")"来匹配
                 * 一个"("，否则需要增加一个"("和一个")"来形成一组匹配
                 */
                if (i + 1 < length && charArray[i + 1] == ')') {
                    if (leftCount > 0) {
                        leftCount--;
                    } else {
                        result++;
                    }
                    /**
                     * 跳过下一个")"
                     */
                    i += 2;
                } else {
                    if (leftCount > 0) {
                        result++;
                        leftCount--;
                    } else {
                        result += 2;
                    }
                    i++;
                }
            }
        }
        /**
         * 匹配最后还未被匹配的"("
         */
        if (leftCount > 0) {
            result += leftCount * 2 - rightCount;
        }
        /**
         * 匹配最后还未被匹配的")"
         */
        if (rightCount > 0) {
            result += (rightCount + 1) / 2;
            result += rightCount % 2 == 0 ? 0 : 1;
        }
        return result;
    }
}
