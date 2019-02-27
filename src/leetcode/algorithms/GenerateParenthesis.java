package leetcode.algorithms;

import java.util.*;

/**
 * Description: Generate Parentheses
 *
 * @author Baltan
 * @date 2018/8/31 10:53
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        Set<String> set = new HashSet<>();
        addParenthesis("", n, n, set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            res.add(it.next());
        }
        return res;
    }

    public static void addParenthesis(String str, int restLeft, int restRight, Set<String> set) {
        if (restLeft == 0 && restRight == 0) {
            set.add(str);
            return;
        }
        addLeftParenthesis(str, restLeft, restRight, set);
        addRightParenthesis(str, restLeft, restRight, set);
    }

    public static void addLeftParenthesis(String str, int restLeft, int restRight, Set<String> set) {
        if (restLeft > 0) {
            str += "(";
            restLeft--;
            addParenthesis(str, restLeft, restRight, set);
        }
    }

    public static void addRightParenthesis(String str, int restLeft, int restRight, Set<String> set) {
        if (restRight > restLeft) {
            str += ")";
            restRight--;
            addParenthesis(str, restLeft, restRight, set);
        }
    }
}