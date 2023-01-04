package leetcode.algorithms;

/**
 * Description: 2380. Time Needed to Rearrange a Binary String
 *
 * @author Baltan
 * @date 2023/1/4 09:26
 */
public class SecondsToRemoveOccurrences {
    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences("0"));
        System.out.println(secondsToRemoveOccurrences("0110101"));
        System.out.println(secondsToRemoveOccurrences("11100"));
    }

    public static int secondsToRemoveOccurrences(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        while (true) {
            /**
             * 当前轮次的遍历是否存在把"01"替换成"10"的操作
             */
            boolean flag = false;
            /**
             * 遍历字符串中是否存在子串"01"
             */
            for (int i = 1; i < length; ) {
                if (charArray[i - 1] == '0' && charArray[i] == '1') {
                    charArray[i - 1] = '1';
                    charArray[i] = '0';
                    i += 2;
                    flag = true;
                } else {
                    i += 1;
                }
            }

            if (flag) {
                result++;
            } else {
                /**
                 * 如果字符串中不存在子串"01"，就结束替换操作
                 */
                break;
            }
        }
        return result;
    }
}
