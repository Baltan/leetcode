package leetcode.algorithms;

/**
 * Description: 2698. Find the Punishment Number of an Integer
 *
 * @author Baltan
 * @date 2023/5/21 21:56
 */
public class PunishmentNumber {
    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
        System.out.println(punishmentNumber(1000));
    }

    public static int punishmentNumber(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            result += help(i, square) ? square : 0;
        }
        return result;
    }

    /**
     * 判断数字square表示的字符串能否拆成若干连续的子串，使得这些子串表示的数字之和等于i
     *
     * @param i
     * @param square
     * @return
     */
    public static boolean help(int i, int square) {
        if (i == square) {
            return true;
        }
        /**
         * 当前子串表示的数字之和
         */
        int value = 0;
        /**
         * 将数字square中某位上的数字拼到子串中时，这个数字在子串所表示的数字中的权重
         */
        int weight = 1;
        /**
         * 将数字square表示的字符串从低位向高位截取子串得到数字x，判断剩余部分的字符串能否通过同样的操作得到和i-x
         */
        while (value < i && square > 0) {
            /**
             * 子串最高位将要拼上的数字
             */
            int digit = square % 10;
            value += digit * weight;
            weight *= 10;
            /**
             * 截去数字square的最低位数字
             */
            square /= 10;

            if (help(i - value, square)) {
                return true;
            }
        }
        return false;
    }
}
