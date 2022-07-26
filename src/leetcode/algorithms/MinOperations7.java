package leetcode.algorithms;

/**
 * Description: 1758. Minimum Changes To Make Alternating Binary String
 *
 * @author Baltan
 * @date 2022/7/23 14:55
 */
public class MinOperations7 {
    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
    }

    public static int minOperations(String s) {
        char[] charArray = s.toCharArray();
        /**
         * 假设最终的交替二进制字符串为"010101……"，则s的第一个字符应为"0"
         */
        char target1 = '0';
        /**
         * 假设最终的交替二进制字符串为"101010……"，则s的第一个字符应为"1"
         */
        char target2 = '1';
        /**
         * 假设最终的交替二进制字符串为"010101……"，需要对s进行的操作数
         */
        int operations1 = 0;
        /**
         * 假设最终的交替二进制字符串为"101010……"，需要对s进行的操作数
         */
        int operations2 = 0;

        for (char c : charArray) {
            if (c != target1) {
                operations1++;
            }

            if (c != target2) {
                operations2++;
            }
            /**
             * 如果当前目标字符为"0"，则下一个目标字符为"1"；反之，如果当前目标字符为"1"，则下一个目标字符为"0"
             */
            target1 = target1 == '0' ? '1' : '0';
            target2 = target2 == '0' ? '1' : '0';
        }
        return Math.min(operations1, operations2);
    }
}
