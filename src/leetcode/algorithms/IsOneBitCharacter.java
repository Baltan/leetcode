package leetcode.algorithms;

/**
 * Description: 717. 1-bit and 2-bit Characters
 * @author Baltan
 *
 * @date 2017/11/7 09:42
 */
public class IsOneBitCharacter {
    public static void main(String[] args) {
        int[] bits1 = {1, 0, 0};
        int[] bits2 = {1, 1, 1, 0};
        int[] bits3 = {0};
        int[] bits4 = {1};
        System.out.println(isOneBitCharacter(bits1));
        System.out.println(isOneBitCharacter(bits2));
        System.out.println(isOneBitCharacter(bits3));
        System.out.println(isOneBitCharacter(bits4));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length - 1] != 0) {
            return false;
        } else {
            int i = 0;
            while (i < bits.length) {
                if (i == bits.length - 1) {
                    return true;
                }
                i = bits[i] == 0 ? i + 1 : i + 2;
            }
        }
        return false;
    }
}
