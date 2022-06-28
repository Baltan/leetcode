package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 1807. Evaluate the Bracket Pairs of a String
 *
 * @author Baltan
 * @date 2022/6/26 14:20
 */
public class Evaluate {
    public static void main(String[] args) {
        System.out.println(evaluate("(name)is(age)yearsold",
                Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
        System.out.println(evaluate("hi(name)", Arrays.asList(Arrays.asList("a", "b"))));
        System.out.println(evaluate("(a)(a)(a)aaa", Arrays.asList(Arrays.asList("a", "yes"))));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder builder = new StringBuilder();
        /**
         * key -> value
         */
        Map<String, String> map =
                knowledge.stream().collect(Collectors.toMap(item -> item.get(0), item -> item.get(1)));
        /**
         * 当前遍历到的s中的字符是否是括号中的key的一部分
         */
        boolean isKey = false;
        /**
         * 记录遍历s时得到的key
         */
        StringBuilder key = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                /**
                 * 标记接下去的内容都是key的一部分
                 */
                isKey = true;
            } else if (c == ')') {
                /**
                 * 得到了完整的key后，查找替换成的value
                 */
                String value = map.getOrDefault(key.toString(), "?");
                builder.append(value);
                key = new StringBuilder();
                /**
                 * 标记接下去的内容不是key
                 */
                isKey = false;
            } else {
                if (isKey) {
                    key.append(c);
                } else {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
