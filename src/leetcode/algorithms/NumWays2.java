package leetcode.algorithms;

/**
 * Description: 1573. Number of Ways to Split a String
 *
 * @author Baltan
 * @date 2020-09-12 22:02
 */
public class NumWays2 {
    public static void main(String[] args) {
        System.out.println(numWays("10101"));
        System.out.println(numWays("1001"));
        System.out.println(numWays("0000"));
        System.out.println(numWays("100100010100110"));
    }

    public static int numWays(String s) {
        int mod = 1000000007;
        char[] charArray = s.toCharArray();
        int length = s.length();
        /**
         * s中"1"的总个数
         */
        int total = 0;

        for (char c : charArray) {
            if (c == '1') {
                total++;
            }
        }

        if (total % 3 != 0) {
            return 0;
        }

        if (total == 0) {
            /**
             * 中间这部分的长度最长为length-2，只有1种分割办法；长度为length-1时，可以有2种分割办法；以此类推，
             * 长度最短为1，可以有length-2种分割办法，总计1+2+……+(length-2)种分割办法
             */
            return (int) ((1L * (length - 1) * (length - 2) / 2) % mod);
        }
        /**
         * 每一部分中"1"的个数
         */
        int average = total / 3;
        /**
         * 当前遍历到的"1"的个数
         */
        int count = 0;
        /**
         * 第average个"1"出现的索引位置
         */
        int index1 = 0;
        /**
         * 第average+1个"1"出现的索引位置
         */
        int index2 = 0;
        /**
         * 第average*2个"1"出现的索引位置
         */
        int index3 = 0;
        /**
         * 第average*2+1个"1"出现的索引位置
         */
        int index4 = 0;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == '1') {
                count++;

                if (count == average) {
                    index1 = i;
                }

                if (count == average + 1) {
                    index2 = i;
                }

                if (count == average * 2) {
                    index3 = i;
                }

                if (count == average * 2 + 1) {
                    index4 = i;
                }
            }
        }
        /**
         * 在(index1,index2]范围内进行一道分割，左边的部分为第一个子字符串，在(index3,index4]范围内进行一道
         * 分割，左边的部分为第二个子字符串
         */
        return (int) (1L * (index2 - index1) * (index4 - index3) % mod);
    }
}
