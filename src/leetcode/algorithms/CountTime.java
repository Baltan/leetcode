package leetcode.algorithms;

/**
 * Description: 2437. Number of Valid Clock Times
 *
 * @author Baltan
 * @date 2023/2/9 10:04
 */
public class CountTime {
    public static void main(String[] args) {
        System.out.println(countTime("21:08"));
        System.out.println(countTime("?5:00"));
        System.out.println(countTime("0?:0?"));
        System.out.println(countTime("??:??"));
    }

    public static int countTime(String time) {
        if (!time.contains("?")) {
            return 1;
        }
        int result = 1;
        char[] charArray = time.toCharArray();

        if (charArray[0] == '?' && charArray[1] == '?') {
            /**
             * "??"可以为00-23，共24种可能
             */
            result *= 24;
        } else if (charArray[0] == '?') {
            /**
             * "?0"-"?3"中"?"可以为0-2，共3种可能；"?4"-"?9"中"?"可以为0-1，共2种可能
             */
            result *= (charArray[1] - '0' < 4 ? 3 : 2);
        } else if (charArray[1] == '?') {
            /**
             * "0?"-"1?"中"?"可以为0-9，共10种可能；"2?"中"?"可以为0-3，共4种可能
             */
            result *= (charArray[0] - '0' < 2 ? 10 : 4);
        }

        if (charArray[3] == '?' && charArray[4] == '?') {
            /**
             * ??"可以为00-59，共60种可能
             */
            result *= 60;
        } else if (charArray[3] == '?') {
            /**
             * "?0"-"?9"中"?"可以为0-5，共6种可能；
             */
            result *= 6;
        } else if (charArray[4] == '?') {
            /**
             * "0?"-"5?"中"?"可以为0-9，共10种可能；
             */
            result *= 10;
        }
        return result;
    }
}
