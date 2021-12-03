package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 2011. Final Value of Variable After Performing Operations
 *
 * @author Baltan
 * @date 2021/12/3 22:01
 */
public class FinalValueAfterOperations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            if (Objects.equals(operation, "++X") || Objects.equals(operation, "X++")) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
