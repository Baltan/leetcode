package leetcode.algorithms;

/**
 * Description: 2182. Construct String With Repeat Limit
 *
 * @author Baltan
 * @date 2022/2/20 20:29
 */
public class RepeatLimitedString {
    public static void main(String[] args) {
        System.out.println(
                repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt", 1));
        System.out.println(repeatLimitedString("cczazcc", 3));
        System.out.println(repeatLimitedString("aababab", 2));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder builder = new StringBuilder(s.length());
        int length = 26;
        /**
         * countArray[i]表示字符串s中字符i+'a'出现的次数
         */
        int[] countArray = new int[length];
        /**
         * 新字符串repeatLimitedString当前最后一个字符
         */
        char prevChar = ' ';
        /**
         * 新字符串repeatLimitedString当前最后一个字符在末尾连续出现的次数
         */
        int consecutiveCount = 0;

        for (char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }
        /**
         * 每次循环从字符串s剩余的字符中找到可以继续拼接到新字符串repeatLimitedString末尾的最大的字符
         */
        while (builder.length() < s.length()) {
            /**
             * 是否在这轮查找中，从字符串s中找到可以继续拼接到新字符串repeatLimitedString末尾的字符
             */
            boolean find = false;

            for (int i = length - 1; i >= 0; i--) {
                if (countArray[i] > 0) {
                    char currChar = (char) ('a' + i);
                    /**
                     * 如果当前字符和新字符串repeatLimitedString当前最后一个字符不同或者新字符串repeatLimitedString当前
                     * 最后一个字符连续出现的次数不到repeatLimit次
                     */
                    if (currChar != prevChar) {
                        builder.append(currChar);
                        prevChar = currChar;
                        consecutiveCount = 1;
                        countArray[i]--;
                        find = true;
                        break;
                    } else if (consecutiveCount < repeatLimit) {
                        builder.append(currChar);
                        consecutiveCount++;
                        countArray[i]--;
                        find = true;
                        break;
                    }
                }
            }
            /**
             * 说明字符串s中已经找不到可以继续拼接到新字符串repeatLimitedString末尾的字符
             */
            if (!find) {
                break;
            }
        }
        return builder.toString();
    }
}
