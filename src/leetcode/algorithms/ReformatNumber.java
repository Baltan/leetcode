package leetcode.algorithms;

/**
 * Description: 1694. Reformat Phone Number
 *
 * @author Baltan
 * @date 2022/8/27 21:56
 */
public class ReformatNumber {
    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
    }

    public static String reformatNumber(String number) {
        char[] charArray = number.toCharArray();
        /**
         * 字符串number中数字的个数
         */
        int digitCount = 0;
        /**
         * 计算字符串number中数字的个数
         */
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        /**
         * 格式化后的电话号码中破折号的个数
         *
         * 电话号码中数字的个数     1  2  3  4  5  6  7  8  ……
         * 电话号码中破折号的个数   0  0  0  1  1  1  2  2  ……
         */
        int dashCount = (digitCount - 1) / 3;
        int length = digitCount + dashCount;
        char[] result = new char[length];
        int index = 0;

        for (char c : charArray) {
            if (Character.isDigit(c)) {
                result[index++] = c;
                /**
                 * 每隔三个数字后面就放一个破折号，所以索引位置3、7、11……为破折号
                 */
                if (index < length && index % 4 == 3) {
                    result[index++] = '-';
                }
            }
        }
        /**
         * 如果倒数第二个字符是破折号，说明最后出现了"-000-0"的情况，将倒数第二个和倒数第三个字符互换位置变成"-00-00"
         */
        if (result[length - 2] == '-') {
            result[length - 2] = result[length - 3];
            result[length - 3] = '-';
        }
        return new String(result);
    }
}
