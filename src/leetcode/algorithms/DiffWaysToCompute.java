package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 241. Different Ways to Add Parentheses
 *
 * @author Baltan
 * @date 2019-06-13 09:31
 */
public class DiffWaysToCompute {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
        System.out.println(diffWaysToCompute("1+2+3-4*5-6+7+8*9"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();

        if (input == null || input.length() == 0) {
            return result;
        }

        int length = input.length();
        boolean flag = false;

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            if (c == '+') {
                flag = true;
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        result.add(left + right);
                    }
                }
            } else if (c == '-') {
                flag = true;
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        result.add(left - right);
                    }
                }
            } else if (c == '*') {
                flag = true;
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        result.add(left * right);
                    }
                }
            }
        }

        if (!flag) {
            result.add(Integer.valueOf(input));
            return result;
        }
        return result;
    }
}