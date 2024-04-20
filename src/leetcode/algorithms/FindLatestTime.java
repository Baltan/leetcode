package leetcode.algorithms;

/**
 * Description: 3114. Latest Time You Can Obtain After Replacing Characters
 *
 * @author Baltan
 * @date 2024/4/20 21:34
 */
public class FindLatestTime {
    public static void main(String[] args) {
        System.out.println(findLatestTime("1?:?4"));
        System.out.println(findLatestTime("0?:5?"));
    }

    public static String findLatestTime(String s) {
        char[] charArray = s.toCharArray();
        /**
         * "??"可以表示的最大小时为"11"，"?0"或"?1"可以表示的最大小时为"10"或"11"，"?2"-"?9"可以表示的最大小时为"02"-"09"
         */
        if (charArray[0] == '?' && charArray[1] == '?') {
            charArray[0] = '1';
            charArray[1] = '1';
        } else if (charArray[0] == '?') {
            charArray[0] = charArray[1] == '0' || charArray[1] == '1' ? '1' : '0';
        } else if (charArray[1] == '?') {
            charArray[1] = charArray[0] == '0' ? '9' : '1';
        }
        /**
         * "??"或"?0"-"?9"可以表示的最大分钟为"59"或"50"-"59"
         */
        if (charArray[3] == '?') {
            charArray[3] = '5';
        }
        /**
         * "??"或"0?"-"5?"可以表示的最大分钟为"59"或"09"-"59"
         */
        if (charArray[4] == '?') {
            charArray[4] = '9';
        }
        return new String(charArray);
    }
}
