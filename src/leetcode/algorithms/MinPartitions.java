package leetcode.algorithms;

/**
 * Description: 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 *
 * @author Baltan
 * @date 2020-12-14 20:38
 */
public class MinPartitions {
    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        int result = 0;
        char[] charArray = n.toCharArray();
        /**
         * 查找n的每位数字上的最大值
         */
        for (char c : charArray) {
            result = Math.max(result, c - '0');
        }
        return result;
    }
}
