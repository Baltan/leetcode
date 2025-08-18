package leetcode.algorithms;

/**
 * Description: 3612. Process String with Special Operations I
 *
 * @author Baltan
 * @date 2025/8/17 14:53
 */
public class ProcessStr {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*"));
        System.out.println(processStr("z*#"));
    }

    public static String processStr(String s) {
        StringBuilder builder = new StringBuilder();
        /**
         * 遍历字符串s，根据题意模拟
         */
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                builder.append(c);
            } else if (c == '*' && !builder.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            } else if (c == '#') {
                builder.append(builder);
            } else if (c == '%') {
                builder.reverse();
            }
        }
        return builder.toString();
    }
}
