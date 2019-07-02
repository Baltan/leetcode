package leetcode.algorithms;

import leetcode.entity.NestedInteger1;
import leetcode.entity.NestedInteger1Impl;

import java.util.Objects;

/**
 * Description: 385. Mini Parser
 *
 * @author Baltan
 * @date 2019-07-02 10:25
 */
public class Solution3 {
    public static void main(String[] args) {
        NestedInteger1 ni1 = deserialize("324");

        NestedInteger1 ni2 = deserialize("[123,[456,[789]]]");

        NestedInteger1 ni3 = deserialize("[]");
    }

    public static NestedInteger1 deserialize(String s) {
        if (Objects.equals(s, "[]")) {
            return new NestedInteger1Impl();
        } else if (!s.startsWith("[")) {
            return new NestedInteger1Impl(Integer.valueOf(s));
        } else {
            NestedInteger1 result = new NestedInteger1Impl();
            int bracketNum = 0;
            int start = 0;
            s = s.substring(1, s.length() - 1) + ",";
            int length = s.length();

            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == '[') {
                    bracketNum++;
                } else if (c == ']') {
                    bracketNum--;
                } else if (c == ',' && bracketNum == 0) {
                    String substr = s.substring(start, i);
                    result.add(deserialize(substr));
                    start = i + 1;
                }
            }
            return result;
        }
    }
}
