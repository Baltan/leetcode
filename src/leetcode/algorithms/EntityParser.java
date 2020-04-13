package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1410. HTML Entity Parser
 *
 * @author Baltan
 * @date 2020-04-13 09:30
 */
public class EntityParser {
    public static void main(String[] args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
        System.out.println(entityParser("Stay home! Practice on Leetcode :)"));
        System.out.println(entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }

    public static String entityParser(String text) {
        StringBuilder builder = new StringBuilder();
        int length = text.length();
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        for (int i = 0; i < length; ) {
            char c = text.charAt(i);
            /**
             * 如果出现"&"，则"&"和后面连着的字符可能构成一个特殊实体
             */
            if (c == '&') {
                /**
                 * 判断当前是否可能为&gt;或&lt;特殊实体
                 */
                if (map.containsKey(text.substring(i, i + 4))) {
                    builder.append(map.get(text.substring(i, i + 4)));
                    i += 4;
                    /**
                     * 判断当前是否可能为&amp;特殊实体
                     */
                } else if (map.containsKey(text.substring(i, i + 5))) {
                    builder.append(map.get(text.substring(i, i + 5)));
                    i += 5;
                    /**
                     * 判断当前是否可能为&quot;或&apos;特殊实体
                     */
                } else if (map.containsKey(text.substring(i, i + 6))) {
                    builder.append(map.get(text.substring(i, i + 6)));
                    i += 6;
                    /**
                     * 判断当前是否可能为&frasl;特殊实体
                     */
                } else if (map.containsKey(text.substring(i, i + 7))) {
                    builder.append(map.get(text.substring(i, i + 7)));
                    i += 7;
                } else {
                    /**
                     * 如果不可能构成特殊实体，则直接在builder后面追加当前字符
                     */
                    builder.append(c);
                    i++;
                }
            } else {
                /**
                 * 如果不可能构成特殊实体，则直接在builder后面追加当前字符
                 */
                builder.append(c);
                i++;
            }
        }
        return builder.toString();
    }
}
