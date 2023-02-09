package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 2515. Shortest Distance to Target String in a Circular Array
 *
 * @author Baltan
 * @date 2023/2/3 09:25
 */
public class ClosetTarget {
    public static void main(String[] args) {
        System.out.println(closetTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
        System.out.println(closetTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));
        System.out.println(closetTarget(new String[]{"i", "eat", "leetcode"}, "ate", 0));
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        int length = words.length;
        /**
         * 保存起始的位置，用于出发时向左走和向右走两种情况的计算
         */
        int index = startIndex;
        /**
         * 出发时向右走到达target的步数
         */
        int right = 0;
        /**
         * 向右走查找字符串target
         */
        while (!Objects.equals(target, words[index])) {
            right++;
            index = (index + 1) % length;
            /**
             * 走了一圈又回到了startIndex索引处，说明数组words中没有字符串target，直接返回-1
             */
            if (index == startIndex) {
                return -1;
            }
        }
        index = startIndex;
        /**
         * 出发时向左走到达target的步数
         */
        int left = 0;
        /**
         * 向左走查找字符串target
         */
        while (!Objects.equals(target, words[index])) {
            left++;
            index = (index - 1 + length) % length;
        }
        return Math.min(left, right);
    }
}
