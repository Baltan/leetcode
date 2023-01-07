package leetcode.algorithms;

/**
 * Description: 2405. Optimal Partition of String
 *
 * @author Baltan
 * @date 2022/12/22 15:25
 */
public class PartitionString {
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }

    public static int partitionString(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        /**
         * isExisted的二进制值的最低位向高位的每一位依次表示字符a-z在子字符串中是否存在，"1"表示存在，"0"表示不存在
         */
        int isExisted = 0;

        for (char c : charArray) {
            int offset = c - 'a';
            /**
             * 添加当前字符前，子字符串中已经存在字符c或者当前子字符串是个空字符串，都需要将标记归零并且将结果数量加1
             */
            if (((isExisted >> offset) & 1) == 1 || isExisted == 0) {
                isExisted = 0;
                result++;
            }
            /**
             * 标记子字符串中已经存在字符c
             */
            isExisted |= (1 << offset);
        }
        return result;
    }
}
