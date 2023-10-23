package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1106. Parsing A Boolean Expression
 *
 * @author baltan
 * @date 2023/10/20 16:44
 */
public class ParseBoolExpr {
    public static void main(String[] args) {
        System.out.println(parseBoolExpr("&(|(f))"));
        System.out.println(parseBoolExpr("|(f,f,f,t)"));
        System.out.println(parseBoolExpr("!(&(f,t))"));
    }

    public static boolean parseBoolExpr(String expression) {
        /**
         * 保存遍历过程中的所有逻辑运算符
         */
        Deque<Character> signs = new ArrayDeque<>();
        /**
         * 保存遍历过程中的所有布尔值，每个逻辑运算符都要其
         */
        Deque<List<Boolean>> deques = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (c == '!' || c == '&' || c == '|') {
                signs.offerLast(c);
                /**
                 * 新建一个属于当前逻辑运算符的列表，用来保存它需要运算的布尔值
                 */
                deques.offerLast(new ArrayList<>());
            } else if (c == 't') {
                deques.peekLast().add(true);
            } else if (c == 'f') {
                deques.peekLast().add(false);
            } else if (c == ')') {
                /**
                 * 每当出现“)”，说明一段有效的布尔表达式结束，计算其结果
                 */
                char sign = signs.pollLast();
                List<Boolean> logicals = deques.pollLast();
                boolean bool = parseBoolExpr(logicals, sign);
                /**
                 * 如果不存在其他逻辑运算符，说明整个布尔表达式expression已运算完成，直接返回
                 */
                if (signs.isEmpty()) {
                    return bool;
                }
                deques.peekLast().add(bool);
            }
        }
        return true;
    }

    /**
     * 判断数组logicals中所有布尔值进行sign代表的逻辑运算后得到的布尔值
     *
     * @param logicals
     * @param sign
     * @return
     */
    public static boolean parseBoolExpr(List<Boolean> logicals, char sign) {
        return switch (sign) {
            /**
             * 只要存在false，按位与的结果就是false
             */
            case '&' -> !logicals.contains(false);
            /**
             * 只要存在true，按位或的结果就是true
             */
            case '|' -> logicals.contains(true);
            /**
             * 布尔值取反
             */
            default -> !logicals.get(0);
        };
    }
}
