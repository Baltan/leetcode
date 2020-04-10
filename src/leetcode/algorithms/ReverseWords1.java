package leetcode.algorithms;

/**
 * Description: 151. Reverse Words in a String
 *
 * @author Baltan
 * @date 2019-04-02 09:23
 */
public class ReverseWords1 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        /**
         * 当前单词第一个字母在s中的索引
         */
        int start = 0;
        /**
         * 当前单词最后一个字母在s中的索引+1
         */
        int end = 0;
        int length = s.length();

        while (end <= length) {
            /**
             * 如果start指向的是' '，向后移动start指针直到其指向某个字母为止，同时要移动end指针
             */
            if (start < length && s.charAt(start) == ' ') {
                start++;
                end++;
            } else if (end < length && s.charAt(end) != ' ') {
                /**
                 * 如果end指针指向某个字母，向后移动end指针，直到end指针超出索引范围或者end指针指向' '
                 */
                end++;
            } else {
                /**
                 * 在builder中拼接当前要翻转的单词
                 */
                builder.insert(0, s.substring(start, end).trim());
                builder.insert(0, ' ');
                /**
                 * 向后移动start指针，继续查找下一个单词，同时要移动end指针
                 */
                start = end + 1;
                end = start;
            }
        }
        return builder.toString().trim();
    }
}
