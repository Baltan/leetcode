package leetcode.algorithms;

/**
 * Description: 13. Roman to Integer
 *
 * @author Baltan
 * @date 2018/8/2 09:25
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int value = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < charArray.length; i++) {
            char letter = charArray[i];

            if (letter == 'I') {
                if (i < length - 1 && charArray[i + 1] == 'V') {
                    value += 4;
                    i++;
                } else if (i < length - 1 && charArray[i + 1] == 'X') {
                    value += 9;
                    i++;
                } else {
                    value += 1;
                }
            } else if (letter == 'V') {
                value += 5;
            } else if (letter == 'X') {
                if (i < length - 1 && charArray[i + 1] == 'L') {
                    value += 40;
                    i++;
                } else if (i < length - 1 && charArray[i + 1] == 'C') {
                    value += 90;
                    i++;
                } else {
                    value += 10;
                }
            } else if (letter == 'L') {
                value += 50;
            } else if (letter == 'C') {
                if (i < length - 1 && charArray[i + 1] == 'D') {
                    value += 400;
                    i++;
                } else if (i < length - 1 && charArray[i + 1] == 'M') {
                    value += 900;
                    i++;
                } else {
                    value += 100;
                }
            } else if (letter == 'D') {
                value += 500;
            } else if (letter == 'M') {
                value += 1000;
            }
        }
        return value;
    }
}
