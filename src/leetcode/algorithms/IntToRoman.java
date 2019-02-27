package leetcode.algorithms;

/**
 * Description: Integer to Roman
 *
 * @author Baltan
 * @date 2018/8/30 11:54
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(1000));
        System.out.println(intToRoman(1007));
        System.out.println(intToRoman(15));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int value1 = num % 10;
        num = num / 10;
        int value2 = num % 10;
        num = num / 10;
        int value3 = num % 10;
        num = num / 10;
        int value4 = num % 10;

        if (value4 != 0) {
            for (int i = 0; i < value4; i++) {
                sb.append("M");
            }
        }
        if (value3 != 0) {
            if (value3 >= 1 && value3 <= 3) {
                for (int i = 0; i < value3; i++) {
                    sb.append("C");
                }
            } else if (value3 == 4) {
                sb.append("CD");
            } else if (value3 == 5) {
                sb.append("D");
            } else if (value3 >= 6 && value3 <= 8) {
                sb.append("D");
                for (int i = 0; i < value3 - 5; i++) {
                    sb.append("C");
                }
            } else if (value3 == 9) {
                sb.append("CM");
            }
        }
        if (value2 != 0) {
            if (value2 >= 1 && value2 <= 3) {
                for (int i = 0; i < value2; i++) {
                    sb.append("X");
                }
            } else if (value2 == 4) {
                sb.append("XL");
            } else if (value2 == 5) {
                sb.append("L");
            } else if (value2 >= 6 && value2 <= 8) {
                sb.append("L");
                for (int i = 0; i < value2 - 5; i++) {
                    sb.append("X");
                }
            } else if (value2 == 9) {
                sb.append("XC");
            }
        }
        if (value1 != 0) {
            if (value1 >= 1 && value1 <= 3) {
                for (int i = 0; i < value1; i++) {
                    sb.append("I");
                }
            } else if (value1 == 4) {
                sb.append("IV");
            } else if (value1 == 5) {
                sb.append("V");
            } else if (value1 >= 6 && value1 <= 8) {
                sb.append("V");
                for (int i = 0; i < value1 - 5; i++) {
                    sb.append("I");
                }
            } else if (value1 == 9) {
                sb.append("IX");
            }
        }
        return sb.toString();
    }
}
