package leetcode.algorithms;

/**
 * Description: 2396. Strictly Palindromic Number
 *
 * @author Baltan
 * @date 2022/12/30 09:16
 */
public class IsStrictlyPalindromic {
    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(9));
        System.out.println(isStrictlyPalindromic(4));
    }

    public static boolean isStrictlyPalindromic(int n) {
        /**
         * 计算n在i进制下的值
         */
        for (int i = n - 2; i >= 2; i--) {
            StringBuilder builder = new StringBuilder();
            int m = n;

            while (m > 0) {
                int remainder = m % i;
                builder.append(remainder);
                m /= i;
            }

            if (!isPalindrome(builder)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串builder是否是回文字符串
     *
     * @param builder
     * @return
     */
    public static boolean isPalindrome(StringBuilder builder) {
        int lo = 0;
        int hi = builder.length() - 1;

        while (lo < hi) {
            if (builder.charAt(lo) != builder.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
