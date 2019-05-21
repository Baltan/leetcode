package leetcode.algorithms;

/**
 * Description: 476. Number Complement
 *
 * @author Baltan
 * @date 2017/12/29 09:52
 */
public class FindComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement(2));
        System.out.println(findComplement(2147483646));
        System.out.println(findComplement(2147483647));
    }

    public static int findComplement(int num) {
        int i = 1;
        while (Math.pow(2, i) <= num) {
            i++;
        }
        return (int) (Math.pow(2, i) - 1 - num);
    }
}
