package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2299. Strong Password Checker II
 *
 * @author Baltan
 * @date 2023/2/17 09:19
 */
public class StrongPasswordCheckerII {
    public static void main(String[] args) {
        System.out.println(strongPasswordCheckerII("IloveLe3tcode!"));
        System.out.println(strongPasswordCheckerII("Me+You--IsMyDream"));
        System.out.println(strongPasswordCheckerII("1aB!"));
    }

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        /**
         * 密码中是否有小写英文字母
         */
        boolean lowercaseLetter = false;
        /**
         * 密码中是否有大写英文字母
         */
        boolean uppercaseLetter = false;
        /**
         * 密码中是否有数字
         */
        boolean digit = false;
        /**
         * 密码中是否有特殊字符
         */
        boolean specialCharacter = false;
        /**
         * 密码中是否有两个连续相同的字符
         */
        boolean sameCharacter = false;
        /**
         * 当前字符的前一个字符，初始化为一个在密码中肯定不存在的字符
         */
        char prevChar = ' ';
        char[] charArray = password.toCharArray();
        Set<Character> specialCharacters = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (Character.isLowerCase(c)) {
                lowercaseLetter = true;
            } else if (Character.isUpperCase(c)) {
                uppercaseLetter = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (specialCharacters.contains(c)) {
                specialCharacter = true;
            }

            if (c == prevChar) {
                sameCharacter = true;
            }
            prevChar = c;
        }
        return lowercaseLetter && uppercaseLetter && digit && specialCharacter && !sameCharacter;
    }
}
