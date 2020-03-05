package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 *
 * @author Baltan
 * @date 2020-03-05 11:20
 */
public class MaxDepthAfterSplit {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maxDepthAfterSplit("(()())"));
        OutputUtils.print1DIntegerArray(maxDepthAfterSplit("()(())()"));
        OutputUtils.print1DIntegerArray(maxDepthAfterSplit("()(()())()()()()()(())"));
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] result = new int[length];
        /**
         * 子序列A的嵌套深度
         */
        int depthA = 0;
        /**
         * 子序列B的嵌套深度
         */
        int depthB = 0;
        /**
         * 尽可能保持两个子序列的嵌套深度相近即可
         */
        for (int i = 0; i < length; i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                if (depthA <= depthB) {
                    result[i] = 0;
                    depthA++;
                } else {
                    result[i] = 1;
                    depthB++;
                }
            } else {
                if (depthA > 0) {
                    result[i] = 0;
                    depthA--;
                } else {
                    result[i] = 1;
                    depthB--;
                }
            }
        }
        return result;
    }
}
