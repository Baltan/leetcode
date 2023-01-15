package leetcode.algorithms;

/**
 * Description: 2390. Removing Stars From a String
 *
 * @author Baltan
 * @date 2022/12/31 13:09
 */
public class RemoveStars {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }

    public static String removeStars(String s) {
        StringBuilder builder = new StringBuilder(s);
        /**
         * 从右往左遍历字符串s的过程中，可以抵消的"*"的个数
         */
        int startCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            /**
             * 累计一个"*"，用于抵消左侧的第一个字母
             */
            if (builder.charAt(i) == '*') {
                startCount++;
                builder.deleteCharAt(i);
                continue;
            }
            /**
             * 抵消当前字符和右侧的一个"*"
             */
            if (startCount > 0) {
                startCount--;
                builder.deleteCharAt(i);
            }
        }
        return builder.toString();
    }
}
