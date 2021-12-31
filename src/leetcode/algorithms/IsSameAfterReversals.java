package leetcode.algorithms;

/**
 * Description: 2119. A Number After a Double Reversal
 *
 * @author Baltan
 * @date 2021/12/31 09:21
 */
public class IsSameAfterReversals {
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));
        System.out.println(isSameAfterReversals(1800));
        System.out.println(isSameAfterReversals(0));
        System.out.println(isSameAfterReversals(30));
        System.out.println(isSameAfterReversals(43344));
    }

    public static boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}
