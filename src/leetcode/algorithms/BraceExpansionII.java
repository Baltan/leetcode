package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 1096. Brace Expansion II
 *
 * @author Baltan
 * @date 2023/3/12 14:06
 */
public class BraceExpansionII {
    public static void main(String[] args) {
        System.out.println(braceExpansionII("abc{d,e}fg"));
        System.out.println(braceExpansionII("abc"));
        System.out.println(braceExpansionII("{a,b}"));
        System.out.println(braceExpansionII("{c,{d,e}}"));
        System.out.println(braceExpansionII("a{b,c}d"));
        System.out.println(braceExpansionII("{a,b}{c,{d,e}}"));
        System.out.println(braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }

    public static List<String> braceExpansionII(String expression) {
        /**
         * expression可能是一个独立的表达式，可能是若干表达式的乘积形式，但是单个独立的表达式也能看做是特殊的乘积形式，所以先将expression拆分
         * 成若干要取乘积的表达式
         */
        List<String> splits = split(expression);

        if (splits.size() == 1) {
            if (expression.startsWith("{")) {
                /**
                 * 去除首尾的两个大括号
                 */
                expression = expression.substring(1, expression.length() - 1);
                /**
                 * 将expression拆分成若干取并集的表达式
                 */
                List<String> unions = union(expression);
                /**
                 * 对所有字符串进行递归、合并、去重，最后再按照升序排列
                 */
                return unions.stream().flatMap(x -> braceExpansionII(x).stream()).distinct().sorted().collect(Collectors.toList());
            } else {
                return Arrays.asList(expression);
            }
        } else {
            /**
             * 对所有字符串进行递归
             */
            List<List<String>> lists = splits.stream().map(BraceExpansionII::braceExpansionII).collect(Collectors.toList());
            /**
             * 对所有字符串数组进行乘积组合
             */
            return combo(lists);
        }
    }

    /**
     * 将多个字符串数组进行乘积组合
     *
     * @param lists
     * @return
     */
    public static List<String> combo(List<List<String>> lists) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (List<String> list : lists) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String prev = queue.poll();

                for (String next : list) {
                    queue.offer(prev + next);
                }
            }
        }
        /**
         * 对所有字符串先去重再按照升序排列
         */
        return queue.stream().distinct().sorted().collect(Collectors.toList());
    }

    /**
     * 将表达式expression拆分成要取并集的若干个表达式，例如：
     * {c,{d,e}} -> ["c","{d,e}"]
     * {{a,z},a{b,c},{ab,z}} -> ["{a,z}","a{b,c}","{ab,z}"]
     * a{b,c}d -> ["a{b,c}d"]
     *
     * @param expression
     * @return
     */
    public static List<String> union(String expression) {
        List<String> unions = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (char c : expression.toCharArray()) {
            if (c == ',' && count == 0) {
                unions.add(builder.toString());
                builder = new StringBuilder();
                continue;
            } else if (c == '{') {
                count++;
            } else if (c == '}') {
                count--;
            }
            builder.append(c);
        }
        /**
         * 表达式后缀剩余部分字符串
         */
        unions.add(builder.toString());
        return unions;
    }

    /**
     * 将表达式expression拆分成要进行乘积组合的若干个表达式，例如：
     * {c,{d,e}} -> ["{c,{d,e}}"]
     * {a,b}{c,{d,e}} -> ["{a,b}","{c,{d,e}}"]
     * a{b,c}d -> ["a","{b,c}","d"]
     * abc{d,e}fg -> ["abc","{d,e}","fg"]
     *
     * @param expression
     * @return
     */
    public static List<String> split(String expression) {
        List<String> intersections = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (char c : expression.toCharArray()) {
            if (c == '{') {
                if (count == 0 && builder.length() > 0) {
                    intersections.add(builder.toString());
                    builder = new StringBuilder();
                }
                builder.append(c);
                count++;
            } else if (c == '}') {
                builder.append(c);
                count--;

                if (count == 0) {
                    intersections.add(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(c);
            }
        }
        /**
         * 表达式后缀剩余部分字符串
         */
        if (builder.length() > 0) {
            intersections.add(builder.toString());
        }
        return intersections;
    }
}