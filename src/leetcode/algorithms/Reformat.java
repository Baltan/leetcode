package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1417. Reformat The String
 *
 * @author Baltan
 * @date 2020-04-22 08:07
 */
public class Reformat {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
        System.out.println(reformat("covid2019"));
        System.out.println(reformat("ab123"));
    }

    public static String reformat(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * 保存所有字母字符的队列
         */
        Queue<Character> letterQueue = new LinkedList<>();
        /**
         * 保存所有数字字符的队列
         */
        Queue<Character> digitQueue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digitQueue.offer(c);
            } else {
                letterQueue.offer(c);
            }
        }
        /**
         * 如果字母字符和数字字符发个数相差插过一个，肯定不能格式化城要求的字符串了，直接返回""
         */
        if (Math.abs(letterQueue.size() - digitQueue.size()) > 1) {
            return "";
        }
        /**
         * 交错将数字字符和字母字符出队拼接成一个格式化后的字符串
         */
        if (digitQueue.size() >= letterQueue.size()) {
            while (!digitQueue.isEmpty() || !letterQueue.isEmpty()) {
                if (!digitQueue.isEmpty()) {
                    builder.append(digitQueue.poll());
                }

                if (!letterQueue.isEmpty()) {
                    builder.append(letterQueue.poll());
                }
            }
        } else {
            while (!digitQueue.isEmpty() || !letterQueue.isEmpty()) {
                if (!letterQueue.isEmpty()) {
                    builder.append(letterQueue.poll());
                }

                if (!digitQueue.isEmpty()) {
                    builder.append(digitQueue.poll());
                }
            }
        }
        return builder.toString();
    }
}
