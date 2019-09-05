package leetcode.algorithms;

/**
 * Description: 906. Super Palindromes
 *
 * @author Baltan
 * @date 2019-09-05 14:25
 */
public class SuperpalindromesInRange {
    public static void main(String[] args) {
        System.out.println(superpalindromesInRange("4", "1000"));
        System.out.println(superpalindromesInRange("1", "999999999999999999"));
    }

    public static int superpalindromesInRange(String L, String R) {
        int result = 0;
        long l = Long.valueOf(L);
        long r = Long.valueOf(R);
        long palindrome;
        long power;
        /**
         * 判断[1,9]的平方是不是回文数（[1,9]是回文数）
         */
        for (long i = 1; i <= 9; i++) {
            power = i * i;

            if (between(l, r, power) && isPalindrome(String.valueOf(power))) {
                result++;
            }
        }
        /**
         * 判断
         * 11、101、111、121、131、141、151、161、171、181、191
         * 22、202、212、222、232、242、252、262、272、282、292
         * ……
         * 1001、10001、10101、10201、10301、10401、10501、10601、10701、10801、10901
         * 2002、20002、20102、20202、20302、20402、20502、20602、20702、20802、20902
         * ……
         * 9009、90009、90109、90209、90309、90409、90509、90609、90709、90809、90909
         * ……
         * 99999999、999909999、999919999、999929999、999939999、999949999、999959999、999969999、999979999
         * 、999989999、999999999
         * 的平方是不是回文数，讨论的上界到9999即可，若为10000，则以10000作为前半部分的回文数最小为1000000001，
         * 1000000001的平方已经超过题目R的上界（10^18）
         */
        for (int i = 1; i <= 9999; i++) {
            /**
             * 回文数的前半部分
             */
            String head = String.valueOf(i);
            /**
             * 回文数的后半部分
             */
            String tail = new StringBuilder(head).reverse().toString();
            palindrome = Long.valueOf(head + tail);
            power = palindrome * palindrome;

            if (between(l, r, power) && isPalindrome(String.valueOf(power))) {
                result++;
            }

            for (int j = 0; j <= 9; j++) {
                palindrome = Long.valueOf(head + j + tail);
                power = palindrome * palindrome;

                if (between(l, r, power) && isPalindrome(String.valueOf(power))) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串数字是不是回文数
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int lo = 0;
        int hi = str.length() - 1;

        while (lo <= hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    /**
     * 判断幂值是不是介于l和r之间
     *
     * @param l
     * @param r
     * @param num
     * @return
     */
    public static boolean between(long l, long r, long num) {
        return num >= l && num <= r;
    }
}
