package leetcode.algorithms;

import java.util.Objects;
import java.util.Stack;

/**
 * Description: 1209. Remove All Adjacent Duplicates in String II（5206. 删除字符串中的所有相邻重复项 II）
 *
 * @author Baltan
 * @date 2019-09-30 09:48
 */
public class RemoveDuplicates3 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int count = 0;
        char[] charArray = s.toCharArray();
        int lenght = charArray.length;
        /**
         * 将字符串s的字符逐一加入到stack1中
         */
        for (int i = 0; i < lenght; i++) {
            char c = charArray[i];
            /**
             * 如果stack1中还没有字符或者当前加入stack1中的字符和stack1中栈顶的字符相等，当前连续的相邻且
             * 相等的字符的数量要增加一个；如果当前加入stack1中的字符和stack1中栈顶的字符不相等，将当前字符
             * 加入stack1中后，重新计数
             */
            if (stack1.isEmpty() || c == stack1.peek()) {
                stack1.push(c);
                count++;
                /**
                 * 如果当前连续的相邻且相等的字符的数量达到了k个，这连续k个字符就要从stack1中出栈删除
                 */
                if (count == k) {
                    for (int j = 0; j < k; j++) {
                        stack1.pop();
                    }
                    /**
                     * 删除操作之后，将stack1栈顶相邻且相等的字符逐一出栈加入stack2中，用于计算stack1
                     * 栈顶相邻且相等的字符的数量，后续加入的字符可能和这串字符相等
                     */
                    count = 0;

                    if (!stack1.isEmpty()) {
                        do {
                            stack2.push(stack1.pop());
                        } while (!stack1.isEmpty() && Objects.equals(stack1.peek(), stack2.peek()));
                    }
                    /**
                     * 将stack2中的所有字符全部出栈重新加入stack1中，恢复stack1中的所有字符
                     */
                    while (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                        count++;
                    }
                }
            } else {
                stack1.push(c);
                count = 1;
            }
        }
        /**
         * 字符串的最后如果是k个连续的相邻且相等的字符，需要将这些字符全部出栈
         */
        if (count == k) {
            for (int i = 0; i < k; i++) {
                stack1.pop();
            }
        }
        /**
         * 将stack1中的字符重新还原成字符串
         */
        while (!stack1.isEmpty()) {
            builder.insert(0, stack1.pop());
        }
        return builder.toString();
    }
}
