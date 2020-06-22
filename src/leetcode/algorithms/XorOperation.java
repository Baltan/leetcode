package leetcode.algorithms;

/**
 * Description: 1486. XOR Operation in an Array
 *
 * @author Baltan
 * @date 2020-06-22 22:26
 */
public class XorOperation {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }

    public static int xorOperation(int n, int start) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }
}
