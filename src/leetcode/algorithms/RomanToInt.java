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

        for (int i = 0; i < length; ) {
            char letter = charArray[i];

            if (letter == 'I') {
                if (i + 1 < length && charArray[i + 1] == 'V') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"IV"，表示数字4
                     */
                    value += 4;
                    i += 2;
                } else if (i + 1 < length && charArray[i + 1] == 'X') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"IX"，表示数字9
                     */
                    value += 9;
                    i += 2;
                } else {
                    /**
                     * charArray[i]不和后续字符构成组合，单独表示数字1
                     */
                    value += 1;
                    i++;
                }
            } else if (letter == 'V') {
                /**
                 * charArray[i]不和后续字符构成组合，单独表示数字5
                 */
                value += 5;
                i++;
            } else if (letter == 'X') {
                if (i + 1 < length && charArray[i + 1] == 'L') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"XL"，表示数字40
                     */
                    value += 40;
                    i += 2;
                } else if (i + 1 < length && charArray[i + 1] == 'C') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"XC"，表示数字90
                     */
                    value += 90;
                    i += 2;
                } else {
                    /**
                     * charArray[i]不和后续字符构成组合，单独表示数字10
                     */
                    value += 10;
                    i++;
                }
            } else if (letter == 'L') {
                /**
                 * charArray[i]不和后续字符构成组合，单独表示数字50
                 */
                value += 50;
                i++;
            } else if (letter == 'C') {
                if (i + 1 < length && charArray[i + 1] == 'D') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"CD"，表示数字400
                     */
                    value += 400;
                    i += 2;
                } else if (i + 1 < length && charArray[i + 1] == 'M') {
                    /**
                     * 如果charArray[i]和charArray[i+1]构成"CM"，表示数字900
                     */
                    value += 900;
                    i += 2;
                } else {
                    /**
                     * charArray[i]不和后续字符构成组合，单独表示数字100
                     */
                    value += 100;
                    i++;
                }
            } else if (letter == 'D') {
                /**
                 * charArray[i]不和后续字符构成组合，单独表示数字500
                 */
                value += 500;
                i++;
            } else if (letter == 'M') {
                /**
                 * charArray[i]不和后续字符构成组合，单独表示数字1000
                 */
                value += 1000;
                i++;
            }
        }
        return value;
    }
}
