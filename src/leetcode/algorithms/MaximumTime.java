package leetcode.algorithms;

/**
 * Description: 1736. Latest Time by Replacing Hidden Digits
 *
 * @author Baltan
 * @date 2022/8/2 09:02
 */
public class MaximumTime {
    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
        System.out.println(maximumTime("0?:3?"));
        System.out.println(maximumTime("1?:22"));
    }

    public static String maximumTime(String time) {
        char[] charArray = time.toCharArray();

        if (charArray[0] == '?' && charArray[1] == '?') {
            /**
             * 小时数最大可能为23
             */
            charArray[0] = '2';
            charArray[1] = '3';
        } else if (charArray[0] == '?') {
            if (charArray[1] >= '0' && charArray[1] <= '3') {
                /**
                 * 小时数最大可能为20-23
                 */
                charArray[0] = '2';
            } else {
                /**
                 * 小时数最大可能为14-19
                 */
                charArray[0] = '1';
            }
        } else if (charArray[1] == '?') {
            if (charArray[0] == '2') {
                /**
                 * 小时数最大可能为23
                 */
                charArray[1] = '3';
            } else {
                /**
                 * 小时数最大可能为09或19
                 */
                charArray[1] = '9';
            }
        }

        if (charArray[3] == '?') {
            /**
             * 分钟数最大可能为50-59
             */
            charArray[3] = '5';
        }

        if (charArray[4] == '?') {
            /**
             * 分钟数最大可能为09、19、29、39、49、59
             */
            charArray[4] = '9';
        }
        return new String(charArray);
    }
}
