package leetcode.algorithms;

/**
 * Description: 2222. Number of Ways to Select Buildings
 *
 * @author Baltan
 * @date 2022/4/10 11:39
 */
public class NumberOfWays {
    public static void main(String[] args) {
        System.out.println(numberOfWays("001101"));
        System.out.println(numberOfWays("11100"));
    }

    public static long numberOfWays(String s) {
        long result = 0L;
        /**
         * 字符串s中"0"的个数
         */
        int total0 = 0;
        /**
         * 字符串s中"1"的个数
         */
        int total1 = 0;
        char[] charArray = s.toCharArray();
        /**
         * 计算字符串s中"0"和"1"的个数
         */
        for (char c : charArray) {
            if (c == '0') {
                total0++;
            } else {
                total1++;
            }
        }
        /**
         * 当前已遍历过的"0"的个数
         */
        int count0 = charArray[s.length() - 1] == '0' ? 1 : 0;
        /**
         * 当前已遍历过的"1"的个数
         */
        int count1 = charArray[s.length() - 1] == '1' ? 1 : 0;
        /**
         * 先确定中间建筑的位置可能为s[1]到s[s.length-2]
         */
        for (int i = s.length() - 2; i >= 1; i--) {
            /**
             * 如果中间建筑为"0"，查找两边"1"的个数各为多少，反之则查找两边"0"的个数各为多少
             */
            if (charArray[i] == '0') {
                result += count1 * (total1 - count1);
                count0++;
            } else {
                result += count0 * (total0 - count0);
                count1++;
            }
        }
        return result;
    }
}
