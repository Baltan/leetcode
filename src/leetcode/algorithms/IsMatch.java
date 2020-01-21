package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 44. Wildcard Matching
 *
 * @author Baltan
 * @date 2020-01-21 13:03
 */
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch(
                "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }

    public static boolean isMatch(String s, String p) {
        Queue<Character> queue = new LinkedList<>();
        int sPollNum = 0;

        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '?') {
                if (queue.size() == 0) {
                    return false;
                }

                queue.poll();
                sPollNum++;
            } else if (c >= 'a' && c <= 'z') {
                if (queue.size() == 0) {
                    return false;
                }

                if (queue.peek() == c) {
                    queue.poll();
                    sPollNum++;
                } else {
                    return false;
                }
            } else {
                if (queue.size() == 0) {
                    continue;
                } else if (i == p.length() - 1) {
                    return true;
                } else {
                    while (sPollNum < s.length() && !isMatch(s.substring(sPollNum), p.substring(i + 1))) {
                        queue.poll();
                        sPollNum++;
                    }
                }
            }
        }
        return queue.size() == 0;
    }
}
