package leetcode.algorithms;

/**
 * Description: 1614. Maximum Nesting Depth of the Parentheses
 *
 * @author Baltan
 * @date 2022/10/4 12:52
 */
public class MaxDepth2 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public static int maxDepth(String s) {
        int result = 0;
        /**
         * 记录遍历字符串s过程中的嵌套深度
         */
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                result = Math.max(result, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return result;
    }
}
