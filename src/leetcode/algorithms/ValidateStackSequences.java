package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 946. Validate Stack Sequences
 *
 * @author Baltan
 * @date 2019-05-02 23:31
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed1 = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed1, popped1));

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed2, popped2));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int length = pushed.length;

        for (int i = 0; i < length; i++) {
            if (pushed[i] != popped[index]) {
                if (!stack.contains(popped[index])) {
                    stack.push(pushed[i]);
                } else {
                    if (stack.peek() == popped[index]) {
                        stack.pop();
                        index++;
                        i--;
                    } else {
                        return false;
                    }
                }
            } else {
                index++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[index++]) {
                return false;
            }
        }
        return true;
    }
}
