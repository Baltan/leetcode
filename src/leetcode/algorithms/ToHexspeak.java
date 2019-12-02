package leetcode.algorithms;

/**
 * Description: 1271. Hexspeak
 *
 * @author Baltan
 * @date 2019-12-02 11:24
 */
public class ToHexspeak {
    public static void main(String[] args) {
        System.out.println(toHexspeak("257"));
        System.out.println(toHexspeak("3"));
        System.out.println(toHexspeak("747823223228"));
    }

    public static String toHexspeak(String num) {
        /**
         * 转为字母都大写的十六进制字符串
         */
        String hexString = Long.toHexString(Long.valueOf(num)).toUpperCase();
        String s1 = hexString.replace("0", "O");
        String s2 = s1.replace("1", "I");

        for (char c : s2.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return "ERROR";
            }
        }
        return s2;
    }
}