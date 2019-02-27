package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: Simplify Path
 *
 * @author Baltan
 * @date 2018/9/24 10:57
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        String[] array = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if ("/".equals(array[i]) || ".".equals(array[i]) || "".equals(array[i])) {
                continue;
            } else if ("..".equals(array[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(array[i]);
            }
        }
        for (int i = 0, l = stack.size(); i < l; i++) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
