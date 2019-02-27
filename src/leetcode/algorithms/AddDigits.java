package leetcode.algorithms;

/**
 * Description:Add Digits
 *
 * @author Baltan
 * @date 2017/12/31 00:24
 */
public class AddDigits {
    public static void main(String[] args) {

    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
