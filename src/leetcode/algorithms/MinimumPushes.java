package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 3014. Minimum Number of Pushes to Type Word I
 *
 * @author baltan
 * @date 2024/1/23 09:14
 * @see MinimumPushes1
 */
public class MinimumPushes {
    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xycdefghij"));
    }

    public static int minimumPushes(String word) {
        int result = 0;
        /**
         * counts[i]表示字符串word中字符(char)(i+'a')出现的次数
         */
        int[] counts = new int[26];
        /**
         * 保存可用的8个按键上每个按键已有的字母数，且始终是升序排列的
         */
        Queue<Integer> queue = new LinkedList<>();

        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        Arrays.sort(counts);
        /**
         * 对于每个字母来说，在字符串word中出现的次数越多，在键盘上输入它按键的次数就应该越少
         */
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 0) {
                break;
            }

            if (queue.size() < 8) {
                /**
                 * 按键上还没有字母
                 */
                result += counts[i];
                queue.offer(1);
            } else {
                int order = queue.poll() + 1;
                result += counts[i] * (order);
                queue.offer(order);
            }
        }
        return result;
    }
}
