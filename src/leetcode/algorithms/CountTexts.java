package leetcode.algorithms;

/**
 * Description: 2266. Count Number of Texts
 *
 * @author Baltan
 * @date 2022/5/11 22:25
 */
public class CountTexts {
    public static void main(String[] args) {
        System.out.println(countTexts("22233"));
        System.out.println(countTexts("222222222222222222222222222222222222"));
    }

    public static int countTexts(String pressedKeys) {
        int mod = 1000000007;
        char[] charArray = pressedKeys.toCharArray();
        int length = charArray.length;
        /**
         * dp[i]表示pressedKeys的前i+1个字符总共可能发出多少种文字信息，对mod取余
         */
        int[] dp = new int[length];
        /**
         * 第一个字符只可能发出一种文字信息
         */
        dp[0] = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 第i+1个字符可以单独发出一个文字，这种情况下pressedKeys的前i+1个字符发出的文字信息种数和前i个字符相同
             */
            long total = dp[i - 1];
            /**
             * 如果第i+1个字符和第i个字符相同，则这两个字符可以连续点击发出一个文字，这种情况下pressedKeys的前i+1个字符发出的
             * 文字信息种数和前i-1个字符相同；如果当前只有两个字符，则只可能发出一种文字信息
             */
            if (charArray[i] == charArray[i - 1]) {
                total += i >= 2 ? dp[i - 2] : 1;
            }
            /**
             * 如果第i+1个字符和第i个字符、第i-1个字符相同，则这三个字符可以连续点击发出一个文字，这种情况下pressedKeys的前
             * i+1个字符发出的文字信息种数和前i-2个字符相同；如果当前只有三个字符，则只可能发出一种文字信息
             */
            if (i >= 2 && charArray[i] == charArray[i - 1] && charArray[i] == charArray[i - 2]) {
                total += i >= 3 ? dp[i - 3] : 1;
            }
            /**
             * 如果第i+1个字符为7或9，并且第i+1个字符和第i个字符、第i-1个字符、第i-2个字符相同，则这四个字符可以连续点击发出一
             * 个文字，因为按钮7和9上都有四个字母，可以连续点击4次发出一个文字，这种情况下pressedKeys的前i+1个字符发出的文字信
             * 息种数和前i-3个字符相同；如果当前只有四个字符，则只可能发出一种文字信息
             */
            if (i >= 3 && (charArray[i] == '7' || charArray[i] == '9') && charArray[i] == charArray[i - 1] &&
                    charArray[i] == charArray[i - 2] && charArray[i] == charArray[i - 3]) {
                total += i >= 4 ? dp[i - 4] : 1;
            }
            dp[i] = (int) (total % mod);
        }
        return dp[length - 1];
    }
}
