package leetcode.algorithms;

/**
 * Description: 1611. Minimum One Bit Operations to Make Integers Zero
 *
 * @author Baltan
 * @date 2023/3/14 21:26
 */
public class MinimumOneBitOperations {
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(minimumOneBitOperations(10000));
        System.out.println(minimumOneBitOperations(71683836));
        System.out.println(minimumOneBitOperations(1000000000));
    }

    public static int minimumOneBitOperations(int n) {
        int result = 0;
        boolean flag = true;
        int x = n;
        int y = n;

        while (true) {
            if (x == 0 || y == 0) {
                return result;
            }

            if (x != -1) {
                x = flag ? operationOne(x) : operationTwo(x);
            }

            if (y != -1) {
                y = flag ? operationTwo(y) : operationOne(y);
            }
            flag = !flag;
            result++;
        }
    }

    public static int operationTwo(int num) {
        int offset = 0;
        int copy = num;

        while (num > 0 && (num & 1) == 0) {
            num >>= 1;
            offset++;
        }

        if (num != 0) {
            num >>= 1;
            return (num & 1) == 1 ? copy - (1 << (offset + 1)) : copy + (1 << (offset + 1));
        }
        return -1;
    }

    public static int operationOne(int num) {
        return (num & 1) == 1 ? num - 1 : num + 1;
    }
}
