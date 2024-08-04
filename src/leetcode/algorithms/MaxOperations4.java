package leetcode.algorithms;

/**
 * Description: 3228. Maximum Number of Operations to Move Ones to the End
 *
 * @author Baltan
 * @date 2024/7/27 15:11
 */
public class MaxOperations4 {
    public static void main(String[] args) {
        System.out.println(maxOperations("1001101"));
        System.out.println(maxOperations("00111"));
    }

    public static int maxOperations(String s) {
        int result = 0;
        /**
         * 字符串s中已有子串"00……00"（最大数量匹配）的数量
         */
        int zeroSegments = 0;
        /**
         * 字符串s中某个字符右边的字符，对于s中的最后一个字符，假设右边字符为'1'不影响结果
         */
        char next = '1';
        /**
         * 对于字符串s中的某个字符'1'，只要它右边还有子串"00……00"（最大数量匹配），就能被右移。它的右边有几个子串"00……00"，它最多就可以被
         * 移动几次。如果先右移字符串s中位置靠右的'1'，可能使得两个子串"00……00"连在一起后，对于位置靠左的'1'右移操作次数变少，所以每次总是
         * 将字符串s中最左侧的'1'执行右移操作
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (next == '1') {
                    next = '0';
                    /**
                     * 开始一个新的子串"00……00"
                     */
                    zeroSegments++;
                }
            } else {
                next = '1';
                /**
                 * 当前字符'1'右侧已有子串"00……00"（最大数量匹配）的数量为zeroSegments
                 */
                result += zeroSegments;
            }
        }
        return result;
    }
}
