package leetcode.interview;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 面试题 08.09. 括号
 *
 * @author Baltan
 * @date 2020-03-16 15:26
 * @see leetcode.algorithms.GenerateParenthesis
 * @see leetcode.algorithms.GenerateParenthesis1
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, new StringBuilder(), 0, n);
        return result;
    }

    /**
     * @param result
     * @param temp
     * @param value  temp中每加入一个"("，将value加1；每加入一个")"，将value减1
     * @param count  剩余可以用的"("的个数
     */
    public static void dfs(List<String> result, StringBuilder temp, int value, int count) {
        if (count == 0) {
            StringBuilder builder = new StringBuilder(temp);
            /**
             * 此时没有"("可以加入temp了，在temp最后加入若干")"直到value为0，此时构成一个有效组合，将该组合
             * 加入result
             */
            while (value != 0) {
                builder.append(")");
                value--;
            }
            result.add(builder.toString());
            return;
        }
        /**
         * 在temp后添加"("后递归
         */
        temp.append("(");
        dfs(result, temp, value + 1, count - 1);
        /**
         * 还原temp初始时的状态
         */
        temp.deleteCharAt(temp.length() - 1);
        /**
         * 如果value大于0，此时temp中的"("多余")"，可以在temp中加入")"递归
         */
        if (value > 0) {
            /**
             * 在temp后添加"("后递归
             */
            temp.append(")");
            dfs(result, temp, value - 1, count);
            /**
             * 还原temp初始时的状态
             */
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
