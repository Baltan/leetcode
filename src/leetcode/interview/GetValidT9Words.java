package leetcode.interview;

import java.util.*;

/**
 * Description: 面试题 16.20. T9键盘
 *
 * @author Baltan
 * @date 2020-03-31 17:24
 */
public class GetValidT9Words {
    public static void main(String[] args) {
        String[] words1 = {"tree", "used"};
        System.out.println(getValidT9Words("8733", words1));

        String[] words2 = {"a", "b", "c", "d"};
        System.out.println(getValidT9Words("2", words2));
    }

    public static List<String> getValidT9Words(String num, String[] words) {
        List<String> result = new LinkedList<>();
        int length = num.length();
        /**
         * keyboard[i]表示数字键盘上数字i上的字符集合
         */
        Set<Character>[] keyboard = new Set[10];
        keyboard[2] = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        keyboard[3] = new HashSet<>(Arrays.asList('d', 'e', 'f'));
        keyboard[4] = new HashSet<>(Arrays.asList('g', 'h', 'i'));
        keyboard[5] = new HashSet<>(Arrays.asList('j', 'k', 'l'));
        keyboard[6] = new HashSet<>(Arrays.asList('m', 'n', 'o'));
        keyboard[7] = new HashSet<>(Arrays.asList('p', 'q', 'r', 's'));
        keyboard[8] = new HashSet<>(Arrays.asList('t', 'u', 'v'));
        keyboard[9] = new HashSet<>(Arrays.asList('w', 'x', 'y', 'z'));

        outer:
        for (String word : words) {
            for (int i = 0; i < length; i++) {
                /**
                 * 判断键盘上按第i个数字能否可以打出第i个字符
                 */
                if (!keyboard[num.charAt(i) - '0'].contains(word.charAt(i))) {
                    continue outer;
                }
            }
            result.add(word);
        }
        return result;
    }
}
