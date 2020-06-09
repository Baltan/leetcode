package leetcode.interview;

/**
 * Description: 面试题46. 把数字翻译成字符串
 *
 * @author Baltan
 * @date 2020-06-09 08:56
 */
public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(425534453));
        System.out.println(translateNum(989723846));
        System.out.println(translateNum(2130093939));
    }

    public static int translateNum(int num) {
        /**
         * 如果num只有一位，则只有一种翻译方法
         */
        if (num < 10) {
            return 1;
        }

        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        /**
         * dp[i]表示num前i+1位数字的翻译方法种类数
         */
        int[] dp = new int[length];
        dp[0] = 1;
        /**
         * 如果前两位数字在[10,25]范围内，则前两位数字有两种翻译方法（两个数字拆开和不拆开），否则只有一种翻译
         * 方法（拆开）
         */
        dp[1] = charArray[0] - '0' != 0 && (charArray[0] - '0') * 10 + (charArray[1] - '0') <= 25 ? 2 : 1;

        for (int i = 2; i < length; i++) {
            /**
             * 逐一判断每一位数字能否和前一位数字合并翻译
             */
            dp[i] = charArray[i - 1] - '0' != 0 &&
                    (charArray[i - 1] - '0') * 10 + (charArray[i] - '0') <= 25 ?
                    dp[i - 2] + dp[i - 1] :
                    dp[i - 1];
        }
        return dp[length - 1];
    }
}
