package leetcode.algorithms;

import java.util.*;

/**
 * Description: 22. Generate Parentheses
 *
 * @author Baltan
 * @date 2018/8/31 10:53
 * @see GenerateParenthesis1
 * @see leetcode.interview.GenerateParenthesis
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if (n <= 0) {
            return result;
        }
        /**
         * set用于去重
         */
        Set<String> set = new HashSet<>();
        addParenthesis("", n, n, set);
        result.addAll(set);
        return result;
    }

    /**
     * @param str
     * @param leftCount  剩余的"("的数量
     * @param rightCount 剩余的")"的数量
     * @param set
     */
    public static void addParenthesis(String str, int leftCount, int rightCount, Set<String> set) {
        if (leftCount == 0 && rightCount == 0) {
            set.add(str);
            return;
        }
        addLeftParenthesis(str, leftCount, rightCount, set);
        addRightParenthesis(str, leftCount, rightCount, set);
    }

    /**
     * 在str最后先加入"("后可以得到的所有组合
     *
     * @param str
     * @param leftCount  剩余的"("的数量
     * @param rightCount 剩余的")"的数量
     * @param set
     */
    public static void addLeftParenthesis(String str, int leftCount, int rightCount, Set<String> set) {
        if (leftCount > 0) {
            str += "(";
            leftCount--;
            addParenthesis(str, leftCount, rightCount, set);
        }
    }

    /**
     * 在str最后先加入")"后可以得到的所有组合
     *
     * @param str
     * @param leftCount  剩余的"("的数量
     * @param rightCount 剩余的")"的数量
     * @param set
     */
    public static void addRightParenthesis(String str, int leftCount, int rightCount, Set<String> set) {
        if (rightCount > leftCount) {
            str += ")";
            rightCount--;
            addParenthesis(str, leftCount, rightCount, set);
        }
    }
}