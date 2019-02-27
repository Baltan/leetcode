package leetcode.algorithms;

/**
 * Description: Lemonade Change
 *
 * @author Baltan
 * @date 2018/8/1 17:29
 */
public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(lemonadeChange(new int[]{10, 10}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(lemonadeChange(new int[]{}));
        System.out.println(lemonadeChange(new int[]{5}));
        System.out.println(lemonadeChange(new int[]{10}));
        System.out.println(lemonadeChange(new int[]{20}));
    }

    public static boolean lemonadeChange(int[] bills) {
        int numOf5 = 0;
        int numOf10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                numOf5++;
            } else if (bill == 10) {
                numOf5--;
                numOf10++;
            } else {
                if (numOf10 > 0) {
                    numOf10--;
                    numOf5--;
                } else {
                    numOf5 -= 3;
                }
            }
            if (numOf5 < 0) {
                return false;
            }
        }
        return true;
    }
}
