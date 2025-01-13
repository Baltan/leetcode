package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: 3412. Find Mirror Score of a String
 *
 * @author Baltan
 * @date 2025/1/13 23:19
 */
public class CalculateScore {
    public static void main(String[] args) {
        System.out.println(calculateScore("aczzx"));
        System.out.println(calculateScore("abcdef"));
    }

    public static long calculateScore(String s) {
        long result = 0L;
        /**
         * deques[0]-deques[25]依次保存字符串s中还未配对的字符a-z出现的索引值
         */
        Deque<Integer>[] deques = new Deque[26];
        Arrays.setAll(deques, x -> new ArrayDeque<>());

        for (int i = 0; i < s.length(); i++) {
            /**
             * 镜像字母在字母表中的索引值
             */
            int mirror = 25 - (s.charAt(i) - 'a');

            if (!deques[mirror].isEmpty()) {
                /**
                 * 将s[i]和之前最后一次出现的镜像字母配对，镜像字母在字符串s中的索引值为deques[mirror].pollLast()
                 */
                result += i - deques[mirror].pollLast();
            } else {
                deques[s.charAt(i) - 'a'].offerLast(i);
            }
        }
        return result;
    }
}
