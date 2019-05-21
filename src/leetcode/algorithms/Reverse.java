package leetcode.algorithms;

/**
 * Description: 7. Reverse Integer
 *
 * @author Baltan
 * @date 2018/1/10 10:06
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(0));
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        long longX = x;
        if (longX == 0) {
            return 0;
        }
        long y = longX > 0 ? longX : -longX;
        int zeroNumFollowY = 0;
        while (y % Math.pow(10, zeroNumFollowY + 1) == 0) {
            zeroNumFollowY++;
        }
        int yLength = 1;
        while ((int) (y / Math.pow(10, yLength)) != 0) {
            yLength++;
        }
        long reverseY = 0;
        int loopNum = 0;
        for (int i = yLength; i >= zeroNumFollowY + 1; i--) {
            reverseY += (int) (y % Math.pow(10, i) / Math.pow(10, i - 1)) * Math.pow(10, loopNum++);
        }
        if (reverseY > 2147483647) {
            return 0;
        } else {
            if (x > 0) {
                return (int) reverseY;
            } else {
                return -(int) reverseY;
            }
        }
    }
}
