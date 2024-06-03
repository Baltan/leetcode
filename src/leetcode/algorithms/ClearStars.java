package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3170. Lexicographically Minimum String After Removing Stars
 *
 * @author baltan
 * @date 2024/6/3 08:59
 */
public class ClearStars {
    public static void main(String[] args) {
        System.out.println(clearStars("d*c"));
        System.out.println(clearStars("aaba*"));
        System.out.println(clearStars("abc"));
    }

    public static String clearStars(String s) {
        StringBuilder builder = new StringBuilder();
        /**
         * isDeleted[i]表示字符s[i]是否被删除
         */
        boolean[] isDeleted = new boolean[s.length()];
        /**
         * 按序保存字符串s中每个字符的索引值，如果两个索引值对应的字符相等，则较大的索引排在前面，否则对应字符较小的索引排在前面
         */
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> s.charAt(x) != s.charAt(y) ? s.charAt(x) - s.charAt(y) : y - x);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                /**
                 * 将"*"删除后，需要删除"*"左侧字典顺序最小的一个英文字符，为了使得剩余字符串的字典顺序最小，应当删除索引值最大的那个
                 */
                isDeleted[i] = true;
                isDeleted[pq.poll()] = true;
            } else {
                pq.offer(i);
            }
        }
        /**
         * 将未被删除的字符按顺序重新拼接为新字符串
         */
        for (int i = 0; i < s.length(); i++) {
            if (!isDeleted[i]) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
