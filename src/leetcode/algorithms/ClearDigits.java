package leetcode.algorithms;

/**
 * Description: 3174. Clear Digits
 *
 * @author Baltan
 * @date 2024/6/11 22:38
 */
public class ClearDigits {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
        System.out.println(clearDigits("hg2jgu24hi2u4l1giug424j2gj2gj24ghk"));
    }

    public static String clearDigits(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * 从右向左遍历字符串s的每个字符，累计未匹配到非数字字符的数字字符的个数
         */
        int digitCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitCount++;
            } else if (digitCount > 0) {
                /**
                 * 当前非数字字符会和右边的一个数字字符一起被删除
                 */
                digitCount--;
            } else {
                /**
                 * 当前非数字字符的右边没有未被匹配过的数字字符，所以这个字符会被留下
                 */
                builder.append(c);
            }
        }
        /**
         * 因为是倒序遍历，所以要反转字符串
         */
        return builder.reverse().toString();
    }
}
